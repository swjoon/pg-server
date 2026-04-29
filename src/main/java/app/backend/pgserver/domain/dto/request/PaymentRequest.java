package app.backend.pgserver.domain.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PaymentRequest(
	@NotBlank
	String paymentKey,

	@NotNull
	@Min(0)
	Long amount,

	@NotBlank
	@Size(min = 6, max = 64)
	String orderId
) {
	public static PaymentRequest from(
		final String paymentKey,
		final Long amount,
		final String orderId
	) {

		return new PaymentRequest(paymentKey, amount, orderId);
	}
}
