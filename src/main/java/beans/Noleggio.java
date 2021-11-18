package main.java.beans;

import java.util.Calendar;

public class Noleggio {

    private String codice;
    private Calendar data_inizio;
    private int durata;
    private Utente utente;
    private Veicolo veicolo;

    public Noleggio(){
    }

    public Noleggio(String codice, Calendar data_inizio, int durata, Utente utente, Veicolo veicolo){
        this.codice = codice;
        this.data_inizio = data_inizio;
        this.durata = durata;
        this.utente = utente;
        this.veicolo = veicolo;
    }

    public Boolean isExpired(){
        boolean result = false;

        return result;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Calendar getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Calendar data_inizio) {
        this.data_inizio = data_inizio;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    @Override
    public String toString() {
        return "Noleggio{" +
                "codice='" + codice + '\'' +
                ", data_inizio=" + StrumentoStampaData.getDataCastedToString(this.data_inizio) + " " + StrumentoStampaData.getOraCastedToString(this.data_inizio) +
                ", durata=" + durata +
                ", utente=" + utente +
                ", veicolo=" + veicolo +
                '}';
    }
}
