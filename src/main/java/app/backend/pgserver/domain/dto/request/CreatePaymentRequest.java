package app.backend.pgserver.domain.dto.request;

public record CreatePaymentRequest (
	String orderId,
	Long totalAmount
){
}
