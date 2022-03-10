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

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	  private static final long serialVersionUID = 1L;
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name = "id_usuario")
	    private Long idUsuario;
	   
	    @Column(name = "nombre")
	    private String nombre;
	    
	    @Column(name = "contrasena")
	    private String contrasena;
	    @JsonIgnoreProperties({"usuario","hibernateLazyInitializer", "handler" })
	    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
	    private List<EncabezadoVenta> encabezadoventaList;
	    
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
	    @JoinColumn(name = "fktipousuario", referencedColumnName = "idtipousuario")
	    @ManyToOne(fetch = FetchType.LAZY)
	    private TipoUsuario tipousuario;
	    
	    
		
		public Usuario(Long idUsuario) {
			super();
			this.idUsuario = idUsuario;
		}
		public Usuario() {
			super();
		}
		public Long getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getContrasena() {
			return contrasena;
		}
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
	    
}
