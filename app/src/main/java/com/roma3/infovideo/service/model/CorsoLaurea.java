/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class CorsoLaurea {

    @Element
    private String denominazione;
    @ElementList(entry = "insegnamento", inline = true)
    private List<Insegnamento> insegnamenti;

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public List<Insegnamento> getInsegnamenti() {
        return insegnamenti;
    }

    public void setInsegnamenti(List<Insegnamento> insegnamenti) {
        this.insegnamenti = insegnamenti;
    }
}
