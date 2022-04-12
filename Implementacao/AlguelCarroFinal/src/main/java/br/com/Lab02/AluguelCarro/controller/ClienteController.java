package br.com.Lab02.AluguelCarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Lab02.AluguelCarro.models.Cliente;
import br.com.Lab02.AluguelCarro.repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public ModelAndView index() {

		List<Cliente> clientes = this.clienteRepository.findAll();
		ModelAndView mv = new ModelAndView("clientes/index");
		mv.addObject("clientes", clientes);
		return mv;
	}

	@GetMapping("/clientes/new")
	public String nnew() {
		return "clientes/new";

	}

	@PostMapping("/clientes")
	public String create(Cliente cliente) {
		this.clienteRepository.save(cliente);
		return "login";
	}

	@GetMapping("/clientes/{id}")
	public ModelAndView show(@PathVariable Integer id) {
		Optional<Cliente> optional = this.clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = optional.get();
			ModelAndView mv = new ModelAndView("clientes/show");
			mv.addObject("cliente", cliente);
			return mv;
		} else {
			return new ModelAndView("/redirect:/clientes");
		}

	}

	@GetMapping("clientes/{id}/delete")
	public ModelAndView delete(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");

		this.clienteRepository.deleteById(id);

		return mv;
	}

	@GetMapping("clinte/{id}/edit")
	public ModelAndView update(@PathVariable Integer id, Cliente requisicao) {

		Optional<Cliente> optional = this.clienteRepository.findById(id);

		if (optional.isPresent()) {
			Cliente cliente1 = optional.get();
			this.clienteRepository.save(cliente1);

			return new ModelAndView("redirect:/cliente/" + requisicao.getId());
		}
		return null;

	}

}
