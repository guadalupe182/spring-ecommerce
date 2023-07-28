package com.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.model.Usuario;
import com.ecommerce.service.IUsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger  logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/registro")
	public String create() {
		return"usuario/registro";
	}
	
	//guardando usuario
	@PostMapping("/save")
	public String save(Usuario usuario) {
		logger.info("usuario registro {}", usuario);
		usuario.setTipo("USER");
		usuarioService.save(usuario);
		return "redirect:/";
	}

}
