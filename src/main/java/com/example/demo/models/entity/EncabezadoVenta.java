package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


@Entity
@Table(name = "encabezadoventa")
public class EncabezadoVenta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "idencabezado")
    private Long idencabezado;
    
    @NotNull
    @Column(name = "total")
    private int total;
    
    @NotNull
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;

	
    
	
	@JsonIgnoreProperties({"encabezadoventaList","hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "fkusuario", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @JsonIgnoreProperties(value={"encabezadoventaList", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JoinColumn(name = "fkcliente", referencedColumnName = "idcliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Clientes cliente;
    @JsonIgnoreProperties({"encabezadoventa","hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "encabezadoventa")
    private List<DetalleVenta> detalleventaList;
    
    
	
	public EncabezadoVenta(Long idencabezado, int total, Date fechaventa, Usuario usuario, Clientes cliente,
			List<DetalleVenta> detalleventaList) {
		super();
		this.idencabezado = idencabezado;
		this.total = total;
		this.fechaventa = fechaventa;
		this.usuario = usuario;
		this.cliente = cliente;
		this.detalleventaList = detalleventaList;
	}
	

	public EncabezadoVenta() {
		super();
	}


	public Long getIdencabezado() {
		return idencabezado;
	}

	public void setIdencabezado(Long idencabezado) {
		this.idencabezado = idencabezado;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<DetalleVenta> getDetalleventaList() {
		return detalleventaList;
	}

	public void setDetalleventaList(List<DetalleVenta> detalleventaList) {
		this.detalleventaList = detalleventaList;
	}
    
    
    
}


