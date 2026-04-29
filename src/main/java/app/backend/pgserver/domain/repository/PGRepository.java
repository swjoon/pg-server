package app.backend.pgserver.domain.repository;

import java.util.Optional;

import app.backend.pgserver.domain.entity.Payment;

public interface PGRepository {

	Optional<Payment> readPaymentByPaymentKey(String paymentKey);

	Payment createPayment(Payment payment);

}
