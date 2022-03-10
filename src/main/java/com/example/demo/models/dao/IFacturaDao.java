package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.EncabezadoVenta;





public interface IFacturaDao extends CrudRepository<EncabezadoVenta, Long> {

}
