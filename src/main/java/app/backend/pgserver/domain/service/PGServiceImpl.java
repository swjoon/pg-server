package app.backend.pgserver.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.backend.pgserver.domain.dto.request.CreatePaymentRequest;
import app.backend.pgserver.domain.dto.request.PaymentRequest;
import app.backend.pgserver.domain.dto.response.CreatePaymentResponse;
import app.backend.pgserver.domain.dto.response.PaymentResponse;
import app.backend.pgserver.domain.entity.Method;
import app.backend.pgserver.domain.entity.Payment;
import app.backend.pgserver.domain.repository.PGRepository;
import app.backend.pgserver.global.util.RandomUtil;
import app.backend.pgserver.global.util.UuidUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PGServiceImpl implements PGService {

	private final PGRepository repository;

	@Override
	@Transactional
	public CreatePaymentResponse createPayment(final CreatePaymentRequest request) {

		return CreatePaymentResponse.from(repository.createPayment(
				Payment.create(
					UuidUtil.getUUID(16),
					request.orderId(),
					Method.CARD,
					request.totalAmount()

				)
			)
		);
	}

	@Override
	@Transactional(readOnly = true)
	public PaymentResponse readPayment(final String paymentKey) {

		Payment payment = getPayment(paymentKey);

		return PaymentResponse.from(payment);
	}

	@Override
	@Transactional
	public PaymentResponse confirmPayment(final PaymentRequest request) {

		Payment payment = getPayment(request.paymentKey());

		if (RandomUtil.chance(90)) {

			payment.done();
		} else {

			payment.abort();
		}

		return PaymentResponse.from(payment);
	}

	@Override
	@Transactional
	public PaymentResponse cancelPayment(final String paymentKey) {

		Payment payment = getPayment(paymentKey);

		payment.cancel();

		return PaymentResponse.from(payment);
	}

	private Payment getPayment(final String paymentKey) {

		return repository.readPaymentByPaymentKey(paymentKey).orElseThrow(
			() -> new RuntimeException("Payment not found")
		);
	}
}
