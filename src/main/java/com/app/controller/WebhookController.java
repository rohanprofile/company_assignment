package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.PaymentEventRepository;
import com.app.dto.PaymentEventResponseDTO;
import com.app.pojos.PaymentEvent;
import com.app.service.PaymentEventService;
import com.app.utils.WebhookUtils;


@RestController
@RequestMapping
public class WebhookController {

    @Value("${webhook.shared.secret}")
    private String sharedSecret;

    @Autowired
    private PaymentEventService paymentEventService;
    
    @Autowired
    private PaymentEventRepository repo;

    @PostMapping("/webhook/payments")
    public ResponseEntity<?> handleWebhook(
        @RequestHeader("X-Razorpay-Signature") String signature,
        @RequestBody String paymentDetailReq
    ) {
        if (!WebhookUtils.isValidSignature(paymentDetailReq, signature, sharedSecret)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid signature");
        }

        PaymentEvent event = paymentEventService.processWebhook(paymentDetailReq);
        return ResponseEntity.ok("Received event: " + event.getEventId());
    }


    @GetMapping("/payments/{paymentId}/events")
    public List<PaymentEventResponseDTO> getEvents(@PathVariable String paymentId) {
    	
        return repo.findByPaymentIdOrderByCreatedAtAsc(paymentId).stream()
                .map(event -> new PaymentEventResponseDTO(event.getEventType(), event.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
