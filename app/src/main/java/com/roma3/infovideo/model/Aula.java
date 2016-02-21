/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.model;

import java.util.ArrayList;
import java.util.List;

public class Aula {

    private String nome;
    private Integer capacita;
    private List<Lezione> lezioni;

    public Aula(String nome) {
        this.nome = nome;
        this.lezioni = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacita() {
        return capacita;
    }

    public void setCapacita(Integer capacita) {
        this.capacita = capacita;
    }

    public List<Lezione> getLezioni() {
        return lezioni;
    }

    public void setLezioni(List<Lezione> lezioni) {
        this.lezioni = lezioni;
    }
}
