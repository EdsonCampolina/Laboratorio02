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
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String RG;
	private String CPF;
	private String nome;
	private String endereco;
	private String profissao;
	private String senha;
	private String entidadeEmpregadora;

	@OneToMany(mappedBy = "cliente")
	private List<RendimentoAuferido> rendimentosAuferidos = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Contrato> contrato = new ArrayList<>();

	public Cliente() {

	}

	public Cliente(String rG, String cPF, String nome, String endereco, String profissao, String entidadeEmpregadora,
			String senha) {
		RG = rG;
		CPF = cPF;
		this.nome = nome;
		this.endereco = endereco;
		this.profissao = profissao;
		this.entidadeEmpregadora = entidadeEmpregadora;
		this.senha = senha;
	}

	public Integer getId() {
		return Id;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEntidadeEmpregadora() {
		return entidadeEmpregadora;
	}

	public void setEntidadeEmpregadora(String entidadeEmpregadora) {
		this.entidadeEmpregadora = entidadeEmpregadora;
	}

	public void addRendimentoAuferidos(RendimentoAuferido red) {
		this.rendimentosAuferidos.add(red);
	}

	public List<RendimentoAuferido> getRendimentosAuferidos() {
		return rendimentosAuferidos;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Contrato> getContrato() {
		return contrato;
	}

	public void addContrato(Contrato contrato) {
		this.contrato.add(contrato);
	}

	public boolean getIsAdd() {
		if (this.rendimentosAuferidos.size() <= 2) {
			return true;
		}
		return false;
	}

}
