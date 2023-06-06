package es.visibilidad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class VisibilidadException extends RuntimeException {
	
	/*
	 * Clase para el manejo de las excepciones personalizadas
	 */
	
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status;

	@Nullable
	private final Integer code;
	
	@Nullable
	private final String message;

	public VisibilidadException(HttpStatus status, Integer code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
