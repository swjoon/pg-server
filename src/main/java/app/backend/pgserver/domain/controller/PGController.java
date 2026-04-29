package app.backend.pgserver.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.backend.pgserver.domain.dto.request.CreatePaymentRequest;
import app.backend.pgserver.domain.dto.request.PaymentRequest;
import app.backend.pgserver.domain.dto.response.CreatePaymentResponse;
import app.backend.pgserver.domain.dto.response.PaymentResponse;
import app.backend.pgserver.domain.service.PGService;
import app.backend.pgserver.global.util.RandomUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PGController {

	private final PGService service;

	@PostMapping
	public ResponseEntity<CreatePaymentResponse> createPayment(
		@RequestBody final CreatePaymentRequest request
	) {

		CreatePaymentResponse res = service.createPayment(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@PostMapping("/confirm")
	public ResponseEntity<PaymentResponse> confirmPayment(
		@RequestBody final PaymentRequest request
	) {

		PaymentResponse res = service.confirmPayment(request);

		RandomUtil.sleepByChance(5, 5_000, 15_000);

		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("/{paymentKey}")
	public ResponseEntity<PaymentResponse> readPayment(@PathVariable final String paymentKey) {

		PaymentResponse res = service.readPayment(paymentKey);

		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PostMapping("/{paymentKey}/cancel")
	public ResponseEntity<PaymentResponse> cancelPayment(@PathVariable final String paymentKey) {

		PaymentResponse res = service.cancelPayment(paymentKey);

		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
