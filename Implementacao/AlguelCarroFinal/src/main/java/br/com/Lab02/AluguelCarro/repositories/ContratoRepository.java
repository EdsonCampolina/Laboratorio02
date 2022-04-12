package br.com.Lab02.AluguelCarro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Lab02.AluguelCarro.models.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer>  {

}
