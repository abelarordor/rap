package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IUsuarioDao;
import com.example.demo.models.entity.Usuario;


@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioDao usuariodao;
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
	
		return (List<Usuario>) usuariodao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuariodao.save(usuario);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		usuariodao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuariodao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findBydeporte(Long id) {
		// TODO Auto-generated method stub
		return usuariodao.eventsBySport(id);
	}



}
