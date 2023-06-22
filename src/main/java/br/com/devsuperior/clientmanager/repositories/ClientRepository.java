package br.com.devsuperior.clientmanager.repositories;

import br.com.devsuperior.clientmanager.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {}
