/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Insegnamento {

    @Element
    private String denominazione;
    @Element(name="periodoAnnoAccademico")
    private PeriodoAnnoAccademico annoAccademico;

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public PeriodoAnnoAccademico getAnnoAccademico() {
        return annoAccademico;
    }

    public void setAnnoAccademico(PeriodoAnnoAccademico annoAccademico) {
        this.annoAccademico = annoAccademico;
    }

    @Root(strict = false)
    public static class PeriodoAnnoAccademico {

        @Element
        private Didattica didattica;

        public Didattica getDidattica() {
            return didattica;
        }

        public void setDidattica(Didattica didattica) {
            this.didattica = didattica;
        }

        @Root(strict = false)
        public static class Didattica {

            @Element(name = "orari")
            private Orario orario;

            public Orario getOrario() {
                return orario;
            }

            public void setOrario(Orario orario) {
                this.orario = orario;
            }

            @Root(strict = false)
            public static class Orario {

                @Element
                private String denominazione;
                @Element
                private EventoFormativo eventoFormativo;

                public String getDenominazione() {
                    return denominazione;
                }

                public void setDenominazione(String denominazione) {
                    this.denominazione = denominazione;
                }

                public EventoFormativo getEventoFormativo() {
                    return eventoFormativo;
                }

                public void setEventoFormativo(EventoFormativo eventoFormativo) {
                    this.eventoFormativo = eventoFormativo;
                }

                @Root(strict = false)
                public static class EventoFormativo {

                    @Element(required = false)
                    private String argomento;
                    @Element(required = false)
                    private String docente;
                    @Element(required = false)
                    private String aula;
                    @Element(required = false)
                    private String giorno;
                    @Element(required = false)
                    private String orarioInizio;
                    @Element(required = false)
                    private String orarioFine;

                    public String getArgomento() {
                        return argomento;
                    }

                    public void setArgomento(String argomento) {
                        this.argomento = argomento;
                    }

                    public String getDocente() {
                        return docente;
                    }

                    public void setDocente(String docente) {
                        this.docente = docente;
                    }

                    public String getAula() {
                        return aula;
                    }

                    public void setAula(String aula) {
                        this.aula = aula;
                    }

                    public String getGiorno() {
                        return giorno;
                    }

                    public void setGiorno(String giorno) {
                        this.giorno = giorno;
                    }

                    public String getOrarioInizio() {
                        return orarioInizio;
                    }

                    public void setOrarioInizio(String orarioInizio) {
                        this.orarioInizio = orarioInizio;
                    }

                    public String getOrarioFine() {
                        return orarioFine;
                    }

                    public void setOrarioFine(String orarioFine) {
                        this.orarioFine = orarioFine;
                    }
                }
            }
        }
    }
}
