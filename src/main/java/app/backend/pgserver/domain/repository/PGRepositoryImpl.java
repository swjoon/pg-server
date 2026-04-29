package app.backend.pgserver.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import app.backend.pgserver.domain.entity.Payment;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PGRepositoryImpl implements PGRepository {

	private final PGJpaRepository jpaRepository;

	@Override
	public Optional<Payment> readPaymentByPaymentKey(final String paymentKey) {

		return jpaRepository.findByPaymentKey(paymentKey);
	}

	@Override
	public Payment createPayment(final Payment payment) {

		return jpaRepository.save(payment);
	}
}

