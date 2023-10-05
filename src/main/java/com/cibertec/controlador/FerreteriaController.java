package com.cibertec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.repositorio.IFerreteriaRepositorio;
import com.cibertec.modelo.Producto;

@Controller
public class FerreteriaController {
	@Autowired
	private IFerreteriaRepositorio ferreteriarepo;
	
	@GetMapping("/")
	public String listado(Model model) {
		List<Producto> productos = ferreteriarepo.findAll();
		model.addAttribute("productos",productos);
		return "listado";
	}
	
	@GetMapping("/consultar")
	public String consultarProductos(@RequestParam("descripcion")String descripcion, Model model) {
		if (!descripcion.equals(null) && !descripcion.isEmpty()) {
			List<Producto> productos = ferreteriarepo.findByDescripcion(descripcion);
			model.addAttribute("productos",productos);
		}
		return "consulta";
	}
}
