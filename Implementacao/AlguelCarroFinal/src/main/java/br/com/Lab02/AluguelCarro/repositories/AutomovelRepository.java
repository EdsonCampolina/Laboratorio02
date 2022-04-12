package br.com.Lab02.AluguelCarro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Lab02.AluguelCarro.models.Automovel;

@Repository
public interface AutomovelRepository extends JpaRepository<Automovel, Integer> {

}
