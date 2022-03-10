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
@Table(name = "tipousuario")
public class TipoUsuario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	   
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name = "idtipousuario")
	    private Long idtipousuario;
	   
	    @NotNull
	    @Column(name = "nombre")
	    private String nombre;
	    @JsonIgnoreProperties({"usuarioList","hibernateLazyInitializer", "handler" })
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipousuario")
	    private List<Usuario> usuarioList;
	    
	
		public Long getIdtipousuario() {
			return idtipousuario;
		}
		public void setIdtipousuario(Long idtipousuario) {
			this.idtipousuario = idtipousuario;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	  

}
