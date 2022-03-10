package com.example.demo.service;

import java.util.List;

import com.example.demo.models.entity.DetalleVenta;



public interface detalleVentasInterfaz {
	public List<DetalleVenta> findAll();
	public DetalleVenta findById(Long id);
	public DetalleVenta save(DetalleVenta detalle);
	public void delete(Long id);
}
