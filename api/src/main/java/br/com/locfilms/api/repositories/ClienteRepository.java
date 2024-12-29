package br.com.locfilms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locfilms.api.models.Cliente;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
