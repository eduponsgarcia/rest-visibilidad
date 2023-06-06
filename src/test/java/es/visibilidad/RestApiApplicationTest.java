package es.visibilidad;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.visibilidad.web.controller.VisibilidadController;

/**
 * Clase test que se encarga de probar que la aplicación se inicia correctamente y es capaz de cargar todas las clases del tipo 'controller'.<br/>
 */
// Esta anotación se encarga de unir las capacidades de pruebas de Spring Boot con JUnit
@RunWith(SpringRunner.class)
// Esta anotación se encarga de iniciar el contexto de Spring Boot para probar que todo se instancia correctamente
@SpringBootTest
public class RestApiApplicationTest {

  @Autowired
  private VisibilidadController visibilidadontroller;
  
  @Test
  public void mainTest() {
    
    // Se comprueba que el objeto UserController se ha instanciado correctamente
    assertThat(visibilidadontroller).isNotNull();
    
  }
  
  @Test
  public void main() {
	  SpringBootRestApiApplication.main(new String[] {});
  }
}
