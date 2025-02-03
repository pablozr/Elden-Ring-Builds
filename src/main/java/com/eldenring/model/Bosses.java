package com.eldenring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents the Boss entity in the database.
 * Contains information about the boss's name, description, difficulty, weaknesses, and resistances.
 */

@Entity
public class Bosses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String dificuldade;
    private String fraquezas;
    private String resistencias;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getFraquezas() {
        return fraquezas;
    }

    public void setFraquezas(String fraquezas) {
        this.fraquezas = fraquezas;
    }

    public String getResistencias() {
        return resistencias;
    }

    public void setResistencias(String resistencias) {
        this.resistencias = resistencias;
    }
}