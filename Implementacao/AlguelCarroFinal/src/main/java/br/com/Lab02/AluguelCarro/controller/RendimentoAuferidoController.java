package br.com.Lab02.AluguelCarro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Lab02.AluguelCarro.models.Cliente;
import br.com.Lab02.AluguelCarro.models.RendimentoAuferido;
import br.com.Lab02.AluguelCarro.repositories.ClienteRepository;
import br.com.Lab02.AluguelCarro.repositories.RendimentoAuferidoRepository;

@Controller
public class RendimentoAuferidoController {

	@Autowired
	private RendimentoAuferidoRepository rendimentoAuferidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/novoRendimento")
	public ModelAndView create(RendimentoAuferido rend, String id) {
		int identificador = Integer.parseInt(id);
		Optional<Cliente> optional = this.clienteRepository.findById(identificador);
		Cliente cliente = optional.get();
		cliente.addRendimentoAuferidos(rend);
		rend.setCliente(cliente);
		this.clienteRepository.save(cliente);
		this.rendimentoAuferidoRepository.save(rend);
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@GetMapping("/rends/{id}/delete")
	public String delete(@PathVariable int id) {
		Long identificador = (long) id;
		this.rendimentoAuferidoRepository.deleteById(identificador);

		return "login";
	}

}
