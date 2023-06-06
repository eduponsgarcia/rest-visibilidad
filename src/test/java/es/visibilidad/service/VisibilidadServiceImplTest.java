package es.visibilidad.service;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.visibilidad.entity.Stock;
import es.visibilidad.repo.StockRepository;
import es.visibilidad.utils.TestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(inheritProfiles = false, profiles = "test")
public class VisibilidadServiceImplTest {
	
	/*
	 * Clase para comprobar los método de la clase service
	 */
	
	@Autowired
	private VisibilidadService visibilidadService;
	
	@MockBean
	private StockRepository visibilidadRepository;
	

	
	@Before
	public void setUp() {
		List<Stock> existingStock = TestHelper.buildStock();
     
        Mockito.when(visibilidadRepository.findAll()).thenReturn(existingStock);
	}
		
	
	@Test
	public void getVisibilidadTest() {
		
	    // Se obtienen todos los objetos
		List<Integer>listStock = visibilidadService.getStock();
		List<Integer> result = new ArrayList<Integer>();
        result.add(5);
        result.add(1);
        result.add(3);
	    
	    // Se comprueba que la lista devuelve el resultado correcto
	    assertThat(listStock, is(result));
	}

}
