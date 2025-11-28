package com.example.IAtreinar.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // Anotação do Lombok

@Entity
@Data // Gera Getters, Setters, toString, hashCode, equals
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String musculoAlvo;
    private String descricaoExecucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMusculoAlvo() {
        return musculoAlvo;
    }

    public void setMusculoAlvo(String musculoAlvo) {
        this.musculoAlvo = musculoAlvo;
    }

    public String getDescricaoExecucao() {
        return descricaoExecucao;
    }

    public void setDescricaoExecucao(String descricaoExecucao) {
        this.descricaoExecucao = descricaoExecucao;
    }
}