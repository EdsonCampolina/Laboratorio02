package br.com.Lab02.AluguelCarro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Lab02.AluguelCarro.models.Agente;
import br.com.Lab02.AluguelCarro.models.Automovel;
import br.com.Lab02.AluguelCarro.models.Cliente;
import br.com.Lab02.AluguelCarro.models.Contrato;
import br.com.Lab02.AluguelCarro.repositories.AgenteRepository;
import br.com.Lab02.AluguelCarro.repositories.AutomovelRepository;
import br.com.Lab02.AluguelCarro.repositories.ClienteRepository;
import br.com.Lab02.AluguelCarro.repositories.ContratoRepository;

@Controller
public class ContratoController {

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private AgenteRepository agenteRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AutomovelRepository automovelRepository;

	@PostMapping("/contrato/criar")
	public ModelAndView create(String id) {
		int identificador = Integer.parseInt(id);
		Optional<Cliente> optional = this.clienteRepository.findById(identificador);
		Cliente cliente = optional.get();

		List<Agente> agentes = this.agenteRepository.findAll();
		List<Automovel> veiculos = this.automovelRepository.findAll();
		List<Automovel> veic = new ArrayList<>();
		for (Automovel item : veiculos) {
			if (item.isAlugado() == false) {
				veic.add(item);
			}
		}

		ModelAndView mv = new ModelAndView("/contrato");
		mv.addObject("agentes", agentes);
		mv.addObject("autos", veic);
		mv.addObject("cliente", cliente);

		return mv;

	}

	@PostMapping("/contrato/")
	public ModelAndView guardarBD(String id, String agente, String automovel, String isCredito, String concedidoPor) {
		int identificador = Integer.parseInt(id);
		int agenteId = Integer.parseInt(agente);
		int automovelId = Integer.parseInt(automovel);
		boolean credito;
		if (isCredito.equals("on")) {
			credito = true;
		} else {
			credito = false;
		}
		Optional<Cliente> optional = this.clienteRepository.findById(identificador);
		Cliente cliente = optional.get();
		Optional<Agente> optionalAgente = this.agenteRepository.findById(agenteId);
		Agente agenteIns = optionalAgente.get();
		Optional<Automovel> optionalAutomovel = this.automovelRepository.findById(automovelId);
		Automovel automovelIns = optionalAutomovel.get();

		Contrato cont = new Contrato();
		cont.setAgente(agenteIns);
		cont.setAutomovel(automovelIns);
		cont.setCliente(cliente);
		cont.setConcedidoPor(concedidoPor);
		cont.setContratoAceito(false);
		cont.setCredito(credito);

		automovelIns.setAlugado(true);
		this.automovelRepository.save(automovelIns);

		this.contratoRepository.save(cont);

		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("cliente", cliente);
		return mv;

	}

}
