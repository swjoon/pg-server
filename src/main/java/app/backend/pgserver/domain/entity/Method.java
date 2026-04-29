package app.backend.pgserver.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Method {

	CARD("카드"), PHONE("휴대폰");

	private final String name;

}
