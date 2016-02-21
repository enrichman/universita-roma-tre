/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.roma3.infovideo.model.Aula;
import com.roma3.infovideo.model.CorsoLaurea;
import com.roma3.infovideo.model.Docente;
import com.roma3.infovideo.model.Facolta;
import com.roma3.infovideo.model.Insegnamento;
import com.roma3.infovideo.model.Lezione;
import com.roma3.infovideo.persistence.DBHelper;
import com.roma3.infovideo.persistence.RomaTreContract;
import com.roma3.infovideo.service.model.Aule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonModelConverter {

    public static Facolta convert(com.roma3.infovideo.service.model.Facolta facoltaXml) {

        Map<String, Insegnamento> insegnamentoMap = new HashMap<>();
        Map<String, Docente> docentiMap = new HashMap<>();

        Facolta facolta = new Facolta(facoltaXml.getDenominazione());

        // get aule
        List<Aula> aule = facolta.getAule();

        Aule auleAsservite = facoltaXml.getListaAuleAsservite();
        for(int i=0; i<auleAsservite.getNomiAule().size(); i++) {
            String nomeAula = auleAsservite.getNomiAule().get(i);
            String capacitaAula = auleAsservite.getCapacita().get(i);

            if(nomeAula != null && !nomeAula.equals("")) {
                Aula aula = new Aula(nomeAula);

                if(capacitaAula != null && !capacitaAula.equals("")) {
                    aula.setCapacita(Integer.valueOf(capacitaAula));
                }
                aule.add(aula);
            }
        }

        // set corsi laurea
        List<CorsoLaurea> corsiLaurea = new ArrayList<>();
        facolta.setCorsiLaurea(corsiLaurea);

        for(com.roma3.infovideo.service.model.CorsoLaurea corsoLaureaXml : facoltaXml.getCorsiDiLaurea()) {
            CorsoLaurea corsoLaurea = new CorsoLaurea(corsoLaureaXml.getDenominazione());

            for(com.roma3.infovideo.service.model.Insegnamento insegnamentoXml : corsoLaureaXml.getInsegnamenti()) {

                String nome = insegnamentoXml.getDenominazione();

                Insegnamento insegnamento = insegnamentoMap.get(nome);
                if(insegnamento == null) {
                    insegnamento = new Insegnamento(nome);
                    insegnamentoMap.put(nome, insegnamento);
                }

                Lezione lezione = new Lezione();
                lezione.setInsegnamento(insegnamento);

                com.roma3.infovideo.service.model.Insegnamento.PeriodoAnnoAccademico.Didattica.Orario orario =
                        insegnamentoXml.getAnnoAccademico().getDidattica().getOrario();
                lezione.setTipo(orario.getDenominazione());
                lezione.setArgomento(orario.getEventoFormativo().getArgomento());

                String giorno = orario.getEventoFormativo().getGiorno();
                String oraInizio = orario.getEventoFormativo().getOrarioInizio();
                String oraFine = orario.getEventoFormativo().getOrarioFine();

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
                    lezione.setInizio(sdf.parse(giorno + oraInizio));
                    lezione.setFine(sdf.parse(giorno + oraFine));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String nomeDocente = orario.getEventoFormativo().getDocente();
                Docente docente = docentiMap.get(nomeDocente);
                if(docente == null) {
                    docente = new Docente(nomeDocente);
                    docentiMap.put(nomeDocente, docente);
                }

                docente.getLezioni().add(lezione);
                lezione.setDocente(docente);

                for(Aula aula : facolta.getAule()) {
                    String nomeAula = orario.getEventoFormativo().getAula();
                    if(aula.getNome().equals(nomeAula)) {
                        lezione.setAula(aula);
                        aula.getLezioni().add(lezione);
                        break;
                    }
                }

                insegnamento.getLezioni().add(lezione);

                corsoLaurea.getInsegnamenti().add(insegnamento);
            }

            corsiLaurea.add(corsoLaurea);
        }

        return facolta;
    }

    public static void saveDB(Context context, Facolta facolta) {
        DBHelper mDbHelper = new DBHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        for(CorsoLaurea corso : facolta.getCorsiLaurea()) {
            ContentValues values = new ContentValues();
            values.put(RomaTreContract.CorsoEntry.COLUMN_NAME_FACOLTA_ID, "ing");
            values.put(RomaTreContract.CorsoEntry.COLUMN_NAME_FACOLTA_NOME, facolta.getNome());
            values.put(RomaTreContract.CorsoEntry.COLUMN_NAME_NOME, corso.getNome());

            long newRowId = db.insert(RomaTreContract.CorsoEntry.TABLE_NAME, null, values);
        }
    }

}
