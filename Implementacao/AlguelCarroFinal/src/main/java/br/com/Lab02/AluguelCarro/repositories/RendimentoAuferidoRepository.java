package br.com.Lab02.AluguelCarro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Lab02.AluguelCarro.models.RendimentoAuferido;


@Repository
public interface RendimentoAuferidoRepository extends JpaRepository<RendimentoAuferido , Long>  {

}
