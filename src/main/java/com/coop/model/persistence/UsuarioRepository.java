package com.coop.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coop.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

//	public List<Usuario> findByProductoLike(String firstName);
	
}
