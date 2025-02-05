package br.com.locfilms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locfilms.api.models.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
