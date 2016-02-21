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
public class Facolta {

    @Element
    private String denominazione;
    @Element
    private Aule listaAuleAsservite;

    @ElementList(entry="corsoLaurea", inline = true)
    private List<CorsoLaurea> corsiDiLaurea;

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public Aule getListaAuleAsservite() {
        return listaAuleAsservite;
    }

    public void setListaAuleAsservite(Aule listaAuleAsservite) {
        this.listaAuleAsservite = listaAuleAsservite;
    }

    public List<CorsoLaurea> getCorsiDiLaurea() {
        return corsiDiLaurea;
    }

    public void setCorsiDiLaurea(List<CorsoLaurea> corsiDiLaurea) {
        this.corsiDiLaurea = corsiDiLaurea;
    }
}
