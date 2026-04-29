package app.backend.pgserver.domain.entity;

import lombok.Getter;

@Getter
public enum Status {

	READY, DONE, CANCELED, ABORTED;

}
