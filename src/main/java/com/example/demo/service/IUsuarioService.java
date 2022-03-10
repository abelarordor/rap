package com.example.demo.service;

import java.util.List;

import com.example.demo.models.entity.Usuario;


public interface IUsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario findBydeporte(Long id);
	public Usuario save(Usuario usuario);
	public void delete(Long id);

}
