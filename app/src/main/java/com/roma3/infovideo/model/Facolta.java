/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.model;

import java.util.ArrayList;
import java.util.List;

public class Facolta {

    private String nome;
    private List<Aula> aule;
    private List<CorsoLaurea> corsiLaurea;

    public Facolta(String nome) {
        this.nome = nome;
        this.aule = new ArrayList<>();
        this.corsiLaurea = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aula> getAule() {
        return aule;
    }

    public void setAule(List<Aula> aule) {
        this.aule = aule;
    }

    public List<CorsoLaurea> getCorsiLaurea() {
        return corsiLaurea;
    }

    public void setCorsiLaurea(List<CorsoLaurea> corsiLaurea) {
        this.corsiLaurea = corsiLaurea;
    }
}
