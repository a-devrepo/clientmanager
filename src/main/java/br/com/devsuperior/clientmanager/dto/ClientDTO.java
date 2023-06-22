package br.com.devsuperior.clientmanager.dto;

import br.com.devsuperior.clientmanager.entities.Client;

import java.time.LocalDate;

public class ClientDTO {
  private String name;

  private String cpf;

  private Double income;

  private LocalDate birthDate;

  private Integer children;

  public ClientDTO(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
    this.name = name;
    this.cpf = cpf;
    this.income = income;
    this.birthDate = birthDate;
    this.children = children;
  }

  public ClientDTO(Client entity) {
    this.name = entity.getName();
    this.cpf = entity.getCpf();
    this.income = entity.getIncome();
    this.birthDate = entity.getBirthDate();
    this.children = entity.getChildren();
  }

  public String getName() {
    return name;
  }

  public String getCpf() {
    return cpf;
  }

  public Double getIncome() {
    return income;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public Integer getChildren() {
    return children;
  }
}
