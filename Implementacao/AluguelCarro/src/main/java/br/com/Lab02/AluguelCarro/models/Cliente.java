package br.com.Lab02.AluguelCarro.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String entidadeEmpregadora;
	private String rendimentosAuferidos;

	public Cliente() {

	}
	
	

	public Cliente(String rG, String cPF, String nome, String endereco, String profissao, String entidadeEmpregadora,
			String rendimentosAuferidos) {
		super();
		RG = rG;
		CPF = cPF;
		this.nome = nome;
		this.endereco = endereco;
		this.profissao = profissao;
		this.entidadeEmpregadora = entidadeEmpregadora;
		this.rendimentosAuferidos = rendimentosAuferidos;
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

	public String getRendimentosAuferidos() {
		return rendimentosAuferidos;
	}

	public void setRendimentosAuferidos(String endimentosAuferidos) {
		this.rendimentosAuferidos = endimentosAuferidos;
	}

	

}
