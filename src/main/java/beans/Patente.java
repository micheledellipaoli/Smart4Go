package main.java.beans;

public class Patente {

    private String codice;
    public enum Tipo_patente{
        Auto, Moto
    };
    private Tipo_patente tipo_patente;


    public Patente(){
    }
    public Patente(String codice, Tipo_patente tipo_patente){
        this.codice = codice;
        this.tipo_patente = tipo_patente;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Tipo_patente getTipo_patente() {
        return tipo_patente;
    }

    public void setTipo_patente(Tipo_patente tipo_patente) {
        this.tipo_patente = tipo_patente;
    }

    @Override
    public String toString() {
        return "Patente{" +
                "codice='" + codice + '\'' +
                ", tipo_patente=" + tipo_patente +
                '}';
    }
}
