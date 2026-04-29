package app.backend.pgserver.domain.service;

import app.backend.pgserver.domain.dto.request.CreatePaymentRequest;
import app.backend.pgserver.domain.dto.request.PaymentRequest;
import app.backend.pgserver.domain.dto.response.CreatePaymentResponse;
import app.backend.pgserver.domain.dto.response.PaymentResponse;

public interface PGService {

	CreatePaymentResponse createPayment(CreatePaymentRequest request);

	PaymentResponse confirmPayment(PaymentRequest request);

	PaymentResponse readPayment(String paymentKey);

	PaymentResponse cancelPayment(String paymentKey);
}
