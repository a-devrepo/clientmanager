package br.com.devsuperior.clientmanager.controllers;

import br.com.devsuperior.clientmanager.dto.ClientDTO;
import br.com.devsuperior.clientmanager.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
  @Autowired private ClientService service;

  @GetMapping
  public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
    return ResponseEntity.ok(service.findAll(pageable));
  }
}
