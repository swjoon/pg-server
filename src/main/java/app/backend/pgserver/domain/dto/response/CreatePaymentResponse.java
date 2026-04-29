package app.backend.pgserver.domain.dto.response;

import app.backend.pgserver.domain.entity.Payment;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreatePaymentResponse(
	@NotBlank
	String paymentKey,

	@NotNull
	@Min(0)
	Long amount,

	@NotBlank
	@Size(min = 6, max = 64)
	String orderId
) {
	public static CreatePaymentResponse from(Payment payment) {
		return new CreatePaymentResponse(payment.getPaymentKey(), payment.getTotalAmount(), payment.getOrderId());
	}

}
