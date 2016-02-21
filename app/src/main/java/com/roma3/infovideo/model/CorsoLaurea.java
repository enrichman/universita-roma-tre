/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.model;

import java.util.ArrayList;
import java.util.List;

public class CorsoLaurea {

    private String nome;
    private List<Insegnamento> insegnamenti;

    public CorsoLaurea(String nome) {
        this.nome = nome;
        this.insegnamenti = new ArrayList<>();
    }

    public List<Insegnamento> getInsegnamenti() {
        return insegnamenti;
    }

    public void setInsegnamenti(List<Insegnamento> insegnamenti) {
        this.insegnamenti = insegnamenti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
