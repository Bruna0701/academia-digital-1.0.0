package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  //define a classe como tabela; exige um ID
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  
  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)   //as informações carregadas não incluirão as avaliações automaticamente
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

  public List<AvaliacaoFisica> getAvaliacoes() {
    return avaliacoes;
  }

  public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
    this.avaliacoes = avaliacoes;
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public String getBairro() {
    return bairro;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public void setDataDeNascimento(LocalDate dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }


}
