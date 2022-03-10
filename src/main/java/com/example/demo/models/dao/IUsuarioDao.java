package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.Usuario;


@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	  @Query(value = "SELECT * FROM usuario u INNER JOIN usuarios_roles ur ON u.id_usuario =ur.role_id WHERE ur.role_id=?1", nativeQuery=true)
	  Usuario eventsBySport(Long idUsuario);
	  //SELECT u.id_usuario, u.nombre,u.contrasena FROM usuario u INNER JOIN usuarios_roles ur ON u.id_usuario =ur.role_id WHERE ur.role_id=?2
}
