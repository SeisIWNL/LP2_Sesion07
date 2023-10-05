package com.cibertec.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.modelo.Producto;

public interface IFerreteriaRepositorio extends JpaRepository<Producto,Integer>{
	@Query("SELECT p FROM Producto p WHERE LOWER(p.descripcion) LIKE %:descripcion%")
	List<Producto> findByDescripcion(@Param("descripcion") String descripcion);
}
