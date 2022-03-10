package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.Idetallefactura;
import com.example.demo.models.entity.DetalleVenta;


@Service
public class detalleimplementacion implements detalleVentasInterfaz {
	@Autowired
	private Idetallefactura factudetalle;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleVenta> findAll() {
		 return (List<DetalleVenta>) factudetalle.findAll();
	}
	@Override
	@Transactional
	public DetalleVenta findById(Long id) {
		return factudetalle.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DetalleVenta save(DetalleVenta detalle) {
		return factudetalle.save(detalle);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		factudetalle.deleteById(id);
		
	}

}
