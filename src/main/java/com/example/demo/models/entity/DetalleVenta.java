package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "detalleventa")
public class DetalleVenta implements Serializable {

	private static final long serialVersionUID = 1L;
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	    @Column(name = "idventadetalle")
	    private Long idventadetalle;
	   
	    
	    @Column(name = "preciounidad")
	    private long preciounidad;
	   
	    
	    @Column(name = "numlugares")
	    private int numlugares;
	 
	    
	    @Column(name = "cantidadagua")
	    private int cantidadagua;
	  
	   
	    @Column(name = "cantidad")
	    private int cantidad;
	    @JsonIgnoreProperties({"detalleventaList","hibernateLazyInitializer", "handler" })
	    @JoinColumn(name = "fkencabezado", referencedColumnName = "idencabezado")
	    @ManyToOne(fetch = FetchType.LAZY)
	    private EncabezadoVenta encabezadoventa;
	    @JsonIgnoreProperties({ "detalleventaList","hibernateLazyInitializer", "handler" })
	    @JoinColumn(name = "fkservicios", referencedColumnName = "id_servicios")
	    @ManyToOne(fetch = FetchType.LAZY)
	    private Servicios servicios;

		

		public Long getIdventadetalle() {
			return idventadetalle;
		}

		public void setIdventadetalle(Long idventadetalle) {
			this.idventadetalle = idventadetalle;
		}

		public long getPreciounidad() {
			return preciounidad;
		}

		public void setPreciounidad(long preciounidad) {
			this.preciounidad = preciounidad;
		}

		public int getNumlugares() {
			return numlugares;
		}

		public void setNumlugares(int numlugares) {
			this.numlugares = numlugares;
		}

	

		public int getCantidadagua() {
			return cantidadagua;
		}

		public void setCantidadagua(int cantidadagua) {
			this.cantidadagua = cantidadagua;
		}

		public EncabezadoVenta getEncabezadoventa() {
			return encabezadoventa;
		}

		public void setEncabezadoventa(EncabezadoVenta encabezadoventa) {
			this.encabezadoventa = encabezadoventa;
		}

		public Servicios getServicios() {
			return servicios;
		}

		public void setServicios(Servicios servicios) {
			this.servicios = servicios;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
	    
	    
}
