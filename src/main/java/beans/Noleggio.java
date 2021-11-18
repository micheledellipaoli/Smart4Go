package main.java.beans;

import java.util.Calendar;

public class Noleggio {

    private int codice;
    private Calendar data_inizio;
    private int durata;
    private Utente utente;
    private Veicolo veicolo;

    public Noleggio(){
    }

    public Noleggio(int codice, Calendar data_inizio, int durata, Utente utente, Veicolo veicolo){
        this.codice = codice;
        this.data_inizio = data_inizio;
        this.durata = durata;
        this.utente = utente;
        this.veicolo = veicolo;
    }

    public Boolean isExpired(){
        boolean expired = false;

        Calendar dataScadenza = this.data_inizio;
        dataScadenza.add(Calendar.MINUTE, this.durata);

        if(dataScadenza.before(Calendar.getInstance())){
            expired = true;
        }
        return expired;
    }

    public double getCostoNoleggio(){
        double costo = (this.durata/60)*this.getVeicolo().getPrezzoOrario();
        return costo;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
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
