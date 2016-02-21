/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.model;

import java.util.Date;

public class Lezione {

    private Insegnamento insegnamento;
    private String tipo;
    private String argomento;
    private Docente docente;
    private Aula aula;
    private Date inizio;
    private Date fine;

    public Insegnamento getInsegnamento() {
        return insegnamento;
    }

    public void setInsegnamento(Insegnamento insegnamento) {
        this.insegnamento = insegnamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Date getInizio() {
        return inizio;
    }

    public void setInizio(Date inizio) {
        this.inizio = inizio;
    }

    public Date getFine() {
        return fine;
    }

    public void setFine(Date fine) {
        this.fine = fine;
    }
}
