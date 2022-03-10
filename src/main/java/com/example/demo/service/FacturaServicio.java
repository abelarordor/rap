package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IFacturaDao;
import com.example.demo.models.entity.EncabezadoVenta;



@Service
public class FacturaServicio implements IfacturacionService {
	@Autowired
	private IFacturaDao factu;

	@Override
	@Transactional(readOnly = true)
	public List<EncabezadoVenta> findAll() {
    return (List<EncabezadoVenta>) factu.findAll();
	}

	
	@Override
	@Transactional(readOnly = true)
	public EncabezadoVenta findById(Long id) {
		
				return factu.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public EncabezadoVenta save(EncabezadoVenta encabezado) {
	
		return factu.save(encabezado);
	}

	@Override
	@Transactional(readOnly = true)
	public void delete(Long id) {
		factu.deleteById(id);
		
	}

	
	
	
	}




