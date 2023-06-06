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
@Table(name = "size")
public class Size implements Serializable{
	
	/*
	 * Clase para la creación de la entidad Size, 
	 * que se encarga de mapear en la base de datos
	 */
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1162692400744211276L;

    @Column(name = "id")
    @Id
    private Integer id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productid", referencedColumnName = "id")
    private Product product;
    
    @Column(name = "backsoon")
    private Boolean backSoon;
    
    @Column(name = "special")
	private Boolean special;
    
}
