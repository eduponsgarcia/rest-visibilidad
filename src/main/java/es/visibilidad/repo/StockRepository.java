package es.visibilidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.visibilidad.entity.Stock;



/**
 * 
 * repositorio jpa contiene las operaciones basicas del crud
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	
}
