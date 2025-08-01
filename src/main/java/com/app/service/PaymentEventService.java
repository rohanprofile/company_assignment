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
    	
			
    	
    /*	
    	JSONObject json = new JSONObject(payload);
          
        
        String eventId = json.getString("id");
        String eventType = json.getString("event");
        long createdAt = json.getLong("created_at");

        JSONObject entity = json
            .getJSONObject("payload")
            .getJSONObject("payment")
            .getJSONObject("entity");

        String paymentId = entity.getString("id");
        String status = entity.getString("status");
        int amount = entity.getInt("amount");
        String currency = entity.getString("currency");
*/
        // Deduplication check
//        if (repo.existsById(eventId)) {
//            return repo.findById(eventId).get();
//        }

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
