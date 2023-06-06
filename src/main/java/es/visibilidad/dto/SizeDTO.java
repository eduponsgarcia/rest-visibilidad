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
public class SizeDTO {
	
	/*
	 * Clase para la creación del JSON de los datos de la entidad
	 */
	
	@JsonProperty
    private Integer id;

    @JsonProperty
    private ProductDTO product;
    
    @JsonProperty
    private Boolean backSoon;
    
    @JsonProperty
    private Boolean special;


}
