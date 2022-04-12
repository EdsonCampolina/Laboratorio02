package br.com.Lab02.AluguelCarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Lab02.AluguelCarro.models.Cliente;
import br.com.Lab02.AluguelCarro.repositories.ClienteRepository;

@Controller
public class LoginController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/")
	public String nnew() {
		return "login";

	}

	@PostMapping("/")
	public ModelAndView create(String cpf, String senha) {
		List<Cliente> clientes = this.clienteRepository.findAll();
		for (Cliente item : clientes) {
			if (item.getCPF().equals(cpf) && item.getSenha().equals(senha)) {
				Cliente client = item;
				ModelAndView mv = new ModelAndView("/home");
				mv.addObject("cliente", client);
				return mv;
			}
		}
		return new ModelAndView("login");
	}
	
	

}
