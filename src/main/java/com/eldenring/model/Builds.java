package com.eldenring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents the Build entity in the database.
 * Contains information about the build used against bosses, including damage type, resistance type, weapons, spells, talismans, and strategies.
 */

@Entity
public class Builds{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipoDano;
    private String tipoResistencia;
    private String armas;
    private String magias;
    private String talismas;
    private String estrategia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDano() {
        return tipoDano;
    }

    public void setTipoDano(String tipoDano) {
        this.tipoDano = tipoDano;
    }

    public String getTipoResistencia() {
        return tipoResistencia;
    }

    public void setTipoResistencia(String tipoResistencia) {
        this.tipoResistencia = tipoResistencia;
    }

    public String getArma() {
        return armas;
    }

    public void setArma(String armas) {
        this.armas = armas;
    }

    public String getMagias() {
        return magias;
    }

    public void setMagias(String magias) {
        this.magias = magias;
    }

    public String getTalismas() {
        return talismas;
    }

    public void setTalismas(String talismas) {
        this.talismas = talismas;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }
}
