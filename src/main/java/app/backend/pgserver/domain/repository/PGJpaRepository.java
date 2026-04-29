package app.backend.pgserver.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.backend.pgserver.domain.entity.Payment;

public interface PGJpaRepository extends JpaRepository<Payment, Long> {

	Optional<Payment> findByPaymentKey(String paymentKey);

}
