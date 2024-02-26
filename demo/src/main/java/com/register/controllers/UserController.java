package com.register.controllers;

import com.register.domain.User;
import com.register.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		// Adicione a lógica para verificar se o usuário já existe e, se não existir, salve no banco de dados
		if (!userService.doesUserExist(user.getUserName())) {
			userService.saveUser(user);
			return "Usuário registrado com sucesso!";
		} else {
			return "Usuário já existe. Escolha outro nome de usuário.";
		}
	}

	@PostMapping("/login")
	public String loginUser(@RequestBody User user) {
		// Adicione a lógica para autenticar o usuário
		if (userService.authenticateUser(user.getUserName(), user.getPassword())) {
			return "Login bem-sucedido!";
		} else {
			return "Usuário ou senha incorretos.";
		}
	}
}

