package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.PaymentEvent;

public interface PaymentEventRepository extends JpaRepository<PaymentEvent, String> {
    List<PaymentEvent> findByPaymentId(String paymentId);
    List<PaymentEvent> findByPaymentIdOrderByCreatedAtAsc(String paymentId);
}
