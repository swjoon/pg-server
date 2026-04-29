package app.backend.pgserver.domain.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "tbl_payment")
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String paymentKey;

	@Column(unique = true)
	private String orderId;

	@Column
	private Method method;

	@Column
	private Long totalAmount;

	@Column
	@Builder.Default
	private Status status = Status.READY;

	@Column
	private String cancelReason;

	@Column
	private OffsetDateTime approvedAt;

	@Column
	private OffsetDateTime canceledAt;

	public static Payment create(String paymentKey, String orderId, Method method, Long totalAmount) {
		return Payment.builder()
			.paymentKey(paymentKey)
			.orderId(orderId)
			.method(method)
			.totalAmount(totalAmount)
			.build();
	}

	public void done() {
		this.status = Status.DONE;
		this.approvedAt = OffsetDateTime.now();
	}

	public void cancel() {
		this.status = Status.CANCELED;
		this.canceledAt = OffsetDateTime.now();
	}

	public void abort() {
		this.status = Status.ABORTED;
	}
}
