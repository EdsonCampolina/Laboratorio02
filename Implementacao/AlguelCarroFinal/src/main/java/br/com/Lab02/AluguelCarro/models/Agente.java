package br.com.Lab02.AluguelCarro.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	

	

	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "agente")
	private List<Contrato> contratos = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void addContrato(Contrato contrato) {
		this.contratos.add(contrato);
	}
	
	public int getId() {
		return id;
	}

}
