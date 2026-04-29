package app.backend.pgserver.domain.dto.response;

import java.time.OffsetDateTime;

public record PaymentCancelResponse(
	String status,
	String cancelReason,
	Long canceledAmount,
	OffsetDateTime canceledAt
) {
}
