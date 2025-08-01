package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PaymentEvent {
    @Id
    private String eventId;
    private String paymentId;
    private String status;
    private Long amount;
    private String currency;
    private String eventType;
    private LocalDateTime createdAt;
}
