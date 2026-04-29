package app.backend.pgserver.domain.dto.response;

import java.time.OffsetDateTime;

import app.backend.pgserver.domain.entity.Payment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentResponse {
	private String paymentKey;
	private String orderId;
	private String method;
	private OffsetDateTime approvedAt;
	private Long totalAmount;
	private String status;
	private Card card;
	private Receipt receipt;

	@Getter
	public static class Card {
		private String number;
		private String approveNo;
	}

	@Getter
	public static class Receipt {
		private String url;
	}

	public static PaymentResponse from(Payment payment) {
		return PaymentResponse.builder()
			.paymentKey(payment.getPaymentKey())
			.orderId(payment.getOrderId())
			.method(payment.getMethod().toString())
			.approvedAt(payment.getApprovedAt())
			.totalAmount(payment.getTotalAmount())
			.status(payment.getStatus().toString())
			.card(null)
			.receipt(null)
			.build();
	}
}
