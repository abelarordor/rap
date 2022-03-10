package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tipoServicio")
public class TipoServicio implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_tiposervicios")
    private Long idTiposervicios;
    
    @Column(name = "nombre")
    private String nombre;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposervicio")
    private List<Servicios> serviciosList;
    

	

	public Long getIdTiposervicios() {
		return idTiposervicios;
	}

	public void setIdTiposervicios(Long idTiposervicios) {
		this.idTiposervicios = idTiposervicios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
	
    
    
}
