package es.visibilidad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6129237008864753749L;

	/*
	 * Clase para la creación de la entidad Product, 
	 * que se encarga de mapear en la base de datos
	 */
	
    
	@Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "sequence")
    private Integer sequence;
    
}
