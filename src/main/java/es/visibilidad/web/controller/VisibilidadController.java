package es.visibilidad.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.visibilidad.dto.ResultErrorDTO;
import es.visibilidad.dto.StockDTO;
import es.visibilidad.service.VisibilidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/visibilidad/v0")
@Tag(name = "visibilidad", description = "Visibilidad API")
public class VisibilidadController {

	//variable para inyectar la dependecia del service
	@Autowired
    private VisibilidadService stockService;
	
	
	/**
	 * Controla las request de Get Visibilidad y hace las validaciones y la llamada al service para satisfacer la peticion.
	 * @return {List<Integer>}
	 * @see {@link StockServiceImpl#getStock()}
	 */
	@Operation(summary = "Get Stock", tags = {"visibilidad"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "List communications", content = {
						@Content(mediaType = "application/json", schema = @Schema(implementation = StockDTO.class)) }),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
						@Content(mediaType = "application/json", schema = @Schema(implementation = ResultErrorDTO.class)) })
	})
    @GetMapping(value = "", produces = {"application/json"})
    public List<Integer> getStock(Principal principal){
		// llamada al servicio
        return stockService.getStock();
    }

	
}
