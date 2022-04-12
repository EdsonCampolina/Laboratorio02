package br.com.Lab02.AluguelCarro.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean isCredito;
	private String concedidoPor;
	private boolean isContratoAceito;

	@ManyToOne
	@JoinColumn(name = "agente_id")
	private Agente agente;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToOne()
	@JoinColumn(name = "automovel_id")
	private Automovel automovel;

	public Contrato() {
	}

	public boolean isCredito() {
		return isCredito;
	}

	public void setCredito(boolean isCredito) {
		this.isCredito = isCredito;
	}

	public String getConcedidoPor() {
		return concedidoPor;
	}

	public void setConcedidoPor(String concedidoPor) {
		this.concedidoPor = concedidoPor;
	}

	public boolean isContratoAceito() {
		return isContratoAceito;
	}

	public void setContratoAceito(boolean isContratoAceito) {
		this.isContratoAceito = isContratoAceito;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public int getId() {
		return id;
	}

}
