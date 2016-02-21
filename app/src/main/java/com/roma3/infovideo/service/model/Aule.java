/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service.model;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Aule {

    @ElementList(entry="aula", inline = true)
    private List<String> nomiAule;
    @ElementList(entry="capacita", inline = true)
    private List<String> capacita;

    public List<String> getNomiAule() {
        return nomiAule;
    }

    public void setNomiAule(List<String> nomiAule) {
        this.nomiAule = nomiAule;
    }

    public List<String> getCapacita() {
        return capacita;
    }

    public void setCapacita(List<String> capacita) {
        this.capacita = capacita;
    }
}
