package br.com.devsuperior.clientmanager.services;

import br.com.devsuperior.clientmanager.dto.ClientDTO;
import br.com.devsuperior.clientmanager.entities.Client;
import br.com.devsuperior.clientmanager.repositories.ClientRepository;
import br.com.devsuperior.clientmanager.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {
  @Autowired private ClientRepository repository;

  @Transactional(readOnly = true)
  public Page<ClientDTO> findAll(Pageable pageable) {
    Page<Client> result = repository.findAll(pageable);
    return result.map(x -> new ClientDTO(x));
  }

  @Transactional(readOnly = true)
  public ClientDTO findById(Long id) {
    Client entity =
        repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    return new ClientDTO(entity);
  }

  @Transactional
  public ClientDTO insert(ClientDTO dto) {
    Client entity = new Client();
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);
    return new ClientDTO(entity);
  }

  @Transactional
  public ClientDTO update(Long id, ClientDTO dto) {
    try {
      Client entity = repository.getReferenceById(id);
      copyDtoToEntity(dto, entity);
      entity = repository.save(entity);
      return new ClientDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Recurso não encontrado");
    }
  }

  @Transactional
  public void delete(Long id) {
    if(!repository.existsById(id)){
      throw new ResourceNotFoundException("Recurso não encontrado");
    }
    repository.deleteById(id);
  }

  private void copyDtoToEntity(ClientDTO dto, Client entity) {
    entity.setName(dto.getName());
    entity.setCpf(dto.getCpf());
    entity.setBirthDate(dto.getBirthDate());
    entity.setIncome(dto.getIncome());
    entity.setChildren(dto.getChildren());
  }
}
