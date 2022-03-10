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
import com.sun.istack.NotNull;
@Entity
@Table(name="cliente")
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idcliente")
    private Long idcliente;
  
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    
    @NotNull
    @Column(name = "apellido")
    private String apellido;
    
    @NotNull
    @Column(name = "cedula")
    private int cedula;
    @JsonIgnoreProperties({"cliente","hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<EncabezadoVenta> encabezadoventaList;
   
	
	public Clientes(Long idcliente) {
		super();
		this.idcliente = idcliente;
	}
	
	
	public Clientes() {
		super();
	}


	public Long getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}
	public List<EncabezadoVenta> getEncabezadoventaList() {
		return encabezadoventaList;
	}
	public void setEncabezadoventaList(List<EncabezadoVenta> encabezadoventaList) {
		this.encabezadoventaList = encabezadoventaList;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
    
}
