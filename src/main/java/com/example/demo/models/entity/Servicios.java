package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "servicios")
public class Servicios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	    @Column(name = "id_servicios")
	    private Long idServicios;
	   
	    @NotNull
	  
	    @Column(name = "nombre")
	    private String nombre;
	   
	    @NotNull
	 
	    @Column(name = "descripcion")
	    private String descripcion;
	  
	    @NotNull
	    @Column(name = "precio")
	    private long precio;
	   
	    @NotNull
	
	    @Column(name = "imgservicos")
	    private String imgservicos;
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
	    @JoinColumn(name = "fktiposervicio", referencedColumnName = "id_tiposervicios")
	    @ManyToOne(fetch = FetchType.LAZY)
	    private TipoServicio tiposervicio;
	    @JsonIgnoreProperties({"serviciost","hibernateLazyInitializer", "handler" })
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios")
	    private List<DetalleVenta> detalleventaList;

	

		public Long getIdServicios() {
			return idServicios;
		}

		public void setIdServicios(Long idServicios) {
			this.idServicios = idServicios;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public long getPrecio() {
			return precio;
		}

		public void setPrecio(long precio) {
			this.precio = precio;
		}

		public String getImgservicos() {
			return imgservicos;
		}

		public void setImgservicos(String imgservicos) {
			this.imgservicos = imgservicos;
		}
	    
	    

}
