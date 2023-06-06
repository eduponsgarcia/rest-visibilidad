package es.visibilidad.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "stock")
public class Stock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1461974840340279028L;

	
	@Column(name = "sizeid")
    @Id
    private Integer sizeId;
	/*
	 * Clase para la creación de la entidad Stock, 
	 * que se encarga de mapear en la base de datos
	 */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sizeid", referencedColumnName = "id")
    private Size size;
    
    @Column(name = "quantity")
    private Integer quantity;

    
}
