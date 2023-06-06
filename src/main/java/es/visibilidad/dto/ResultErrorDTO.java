package es.visibilidad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultErrorDTO {
	
	/*
	 * Clase para la devolucion de las excepciones personalizadas en JSON
	 */
	
	@JsonProperty
	private Integer code;
	
	@JsonProperty
	private String message;

}