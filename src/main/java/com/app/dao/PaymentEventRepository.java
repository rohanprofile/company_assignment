package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.PaymentEvent;

@Repository
public interface PaymentEventRepository extends JpaRepository<PaymentEvent, String> {
    List<PaymentEvent> findByPaymentId(String paymentId);
    List<PaymentEvent> findByPaymentIdOrderByCreatedAtAsc(String paymentId);
}
