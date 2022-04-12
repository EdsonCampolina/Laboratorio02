package br.com.Lab02.AluguelCarro.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Automovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer matricula;
	private Integer ano;
	private String marca;
	private String modelo;
	private String placa;
	private boolean isAlugado = false;

	@JsonIgnore
	@OneToOne(mappedBy = "automovel")
	private Contrato contrato;

	public Automovel() {

	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public boolean isAlugado() {
		return isAlugado;
	}

	public void setAlugado(boolean isAlugado) {
		this.isAlugado = isAlugado;
	}

	public int getId() {
		return id;
	}

	public void addContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}
