package com.app.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.InvalidJsonException;
import com.app.dao.PaymentEventRepository;
import com.app.dto.PaymentDetail;
import com.app.pojos.PaymentEvent;
import com.app.utils.JsonConverterUtility;

@Service
public class PaymentEventService {

    @Autowired
    private PaymentEventRepository repo;
    
    @Autowired
    JsonConverterUtility jsonConverterUtility;

    public PaymentEvent processWebhook(String payload) {
        
    	
			PaymentDetail paymentDetail = jsonConverterUtility.convertStringToObject(payload,PaymentDetail.class);
		
			if(paymentDetail == null) {
				throw new InvalidJsonException("Invalid Json");
			}
    	
			
//         Deduplication check
        if (repo.existsById(paymentDetail.getId())) {
        	throw new InvalidJsonException("Event id record already exist = "+repo.findById(paymentDetail.getId()).get());
        }

        PaymentEvent event = new PaymentEvent();
        event.setEventId(paymentDetail.getId());
        event.setEventType(paymentDetail.getEvent());
        event.setPaymentId(paymentDetail.getPayload().getPayment().getEntity().getId());
        event.setStatus(paymentDetail.getPayload().getPayment().getEntity().getStatus());
        event.setAmount(paymentDetail.getPayload().getPayment().getEntity().getAmount());
        event.setCurrency(paymentDetail.getPayload().getPayment().getEntity().getCurrency());
        System.out.println(paymentDetail.getCreated_at());
        event.setCreatedAt(LocalDateTime.ofEpochSecond(paymentDetail.getCreated_at(), 0, ZoneOffset.UTC));

//        System.out.println(paymentDetail.getCreated_at());
//        event.setCreatedAt(LocalDateTime.ofEpochSecond(paymentDetail.getCreated_at(), 0, ZoneOffset.UTC));
        //event.setEventPayload(payload);

        return repo.save(event);
    }
}
