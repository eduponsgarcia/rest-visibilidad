package es.visibilidad.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import es.visibilidad.constant.Constantes;
import es.visibilidad.dto.ProductDTO;
import es.visibilidad.dto.SizeDTO;
import es.visibilidad.dto.StockDTO;
import es.visibilidad.entity.Stock;
import es.visibilidad.exception.VisibilidadException;
import es.visibilidad.repo.StockRepository;
import es.visibilidad.service.VisibilidadService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;

@Service
@Slf4j
public class VisibilidadServiceImpl implements VisibilidadService {

	//variable para inyectar la dependecia del repository
	@Autowired
	private StockRepository stockRepository;
	
	/**
	 * Consulta todos los registros de Stock.
	 * @return {List<Integer>}
	 * @throws VisibilidadException Error producido al no encontrar los registros.
	 */
	public List<Integer> getStock() {

		ModelMapper modelMapper = new ModelMapper();
		List<Integer> finalList;

		
		try {
			// Consulta de los datos de stock en BBDD a través del repo.
			List<Stock> listStock = stockRepository.findAll();
			
			// Mapeo de la entidad recuperada a DTO
			Type listType = new TypeToken<List<StockDTO>>(){}.getType();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			List<StockDTO> initialListDTO = modelMapper.map(listStock,listType);		
			
			// Nos quedamos con las tallas que tienen stock o backSoon
			List<SizeDTO> listSizesDTO = initialListDTO.stream()
				    .filter(s -> s.getQuantity()>0 || s.getSize().getBackSoon())
				    .map(StockDTO::getSize)
				    .collect(Collectors.toList());
			
			// Nos quedamos con los productos espaciales
			List<ProductDTO> listEspecialSizesDTO = listSizesDTO.stream()
				    .filter(s -> s.getSpecial())
                    .map(SizeDTO::getProduct)
                    .collect(Collectors.toList());
			
			// Nos quedamos con los productos no especiales
			List<ProductDTO> listNoEspecialSizesDTO = listSizesDTO.stream()
				    .filter(s -> !s.getSpecial())
                    .map(SizeDTO::getProduct)
                    .collect(Collectors.toList());
			
			// Nos quedamos con los productos que están tanto en especiales como no especiales
			List<ProductDTO> listEspecialProductDTO = listEspecialSizesDTO.stream()
					.filter(s -> listNoEspecialSizesDTO.contains(s)) 
                    .collect(Collectors.toList());
			
			// Nos quedamos con los productos que no tienen especiales.
			List<ProductDTO> listNoEspecialProductsDTO = listSizesDTO.stream()
					.filter(s -> !listEspecialSizesDTO.contains(s.getProduct())) 
                    .map(SizeDTO::getProduct)
                    .collect(Collectors.toList());
			
			// Merge de las listas con los resultados ordenando por secuencia y eliminando duplicados.
			finalList = Stream.concat(listEspecialProductDTO.stream(),listNoEspecialProductsDTO.stream())
                    .sorted(Comparator.comparingInt(ProductDTO::getSequence))
                    .map(s -> s.getId())
                    .distinct()
                    .collect(Collectors.toList());			
				
		}catch (Exception e) {
			//control y traza de la excepcion
			log.error("Error getStock : " + e.getMessage(), e);
			throw new VisibilidadException(HttpStatus.INTERNAL_SERVER_ERROR, Constantes.CODE_INTERNAL_SERVER_ERROR, Constantes.MESSAGE_INTERNAL_SERVER_ERROR);
		}		
		return finalList;
	}


}
