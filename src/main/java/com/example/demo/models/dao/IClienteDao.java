package com.example.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entity.Clientes;




public interface IClienteDao extends JpaRepository<Clientes, Long> {
	

}
