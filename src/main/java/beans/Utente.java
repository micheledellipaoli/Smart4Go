package main.java.beans;

import java.util.ArrayList;
import java.util.Calendar;

public class Utente {

    private String email;
    private String nome;
    private String cognome;
    private Calendar data_nascita;
    private String luogo_nascita;
    private ArrayList<Noleggio> noleggi;
    private ArrayList<Patente> patenti;

    public Utente(){
    }

    public Utente(String email, String nome, String cognome, Calendar data_nascita, String luogo_nascita){
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.luogo_nascita = luogo_nascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Calendar getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Calendar data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getLuogo_nascita() {
        return luogo_nascita;
    }

    public void setLuogo_nascita(String luogo_nascita) {
        this.luogo_nascita = luogo_nascita;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + StrumentoStampaData.getDataCastedToString(this.data_nascita) +
                ", luogo_nascita='" + luogo_nascita + '\'' +
                ", noleggi=" + noleggi +
                ", patenti=" + patenti +
                '}';
    }

}
