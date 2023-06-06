package es.visibilidad.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.visibilidad.service.impl.VisibilidadServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(inheritProfiles = false, profiles = "test")
public class VisibilidadControllerTests {
	
	/*
	 * Clase para la comprobacion de los métodos del controller
	 */

    @MockBean
    VisibilidadServiceImpl visibilidadService;

    @Autowired
    private MockMvc mockMvc;
    
    List<Integer> result;


    @Before
    public void setUp() {
    	Mockito.when(visibilidadService.getStock()).thenReturn(result);             
    }

    @Test
    public void getVisibilidadTest() throws Exception {
    	
    	//Se comprueba que se devuelva una lista con los productos en stock
        this.mockMvc
                .perform(get("/visibilidad/v0"))
                .andExpect(status().isOk());
    }

}