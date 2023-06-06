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
public class StockDTO {
	
	/*
	 * Clase para la creación del JSON de los datos de la entidad
	 */

    @JsonProperty
    private SizeDTO size;
    
    @JsonProperty
    private Integer quantity;


}
