package main.java.beans;

public class Veicolo {
    private String codice;
    private String tipo;
    private String modello;
    private String marchio;
    private String targa;
    private String comune;
    private double prezzoOrario;
    private boolean carburante;
    private boolean patenteRichiesta;

    public Veicolo(String modello, String codice, String tipo, boolean carburante, String marchio, double prezzoOrario, boolean patenteRichiesta, String targa, String comune) {
        this.codice = codice;
        this.tipo = tipo;
        this.modello = modello;
        this.marchio = marchio;
        this.targa = targa;
        this.comune = comune;
        this.prezzoOrario = prezzoOrario;
        this.carburante = carburante;
        this.patenteRichiesta = patenteRichiesta;
    }

    public Veicolo(String codice, String modello, String marchio, String targa, String comune, double prezzoOrario) {
        this.codice = codice;
        this.modello = modello;
        this.marchio = marchio;
        this.targa = targa;
        this.comune = comune;
        this.prezzoOrario = prezzoOrario;
    }

    public Veicolo(String codice, String modello, String marchio, String comune, double prezzoOrario) {
        this.codice = codice;
        this.modello = modello;
        this.marchio = marchio;
        this.comune = comune;
        this.prezzoOrario = prezzoOrario;
    }

    public String getCodice() {
        return codice;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModello() {
        return modello;
    }

    public String getMarchio() {
        return marchio;
    }

    public String getTarga() {
        return targa;
    }

    public String getComune() {
        return comune;
    }

    public double getPrezzoOrario() {
        return prezzoOrario;
    }

    public boolean isCarburante() {
        return carburante;
    }

    public boolean isPatenteRichiesta() {
        return patenteRichiesta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setCarburante(boolean carburante) {
        this.carburante = carburante;
    }

    public void setPatenteRichiesta(boolean patenteRichiesta) {
        this.patenteRichiesta = patenteRichiesta;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "codice='" + codice + '\'' +
                ", tipo='" + tipo + '\'' +
                ", modello='" + modello + '\'' +
                ", marchio='" + marchio + '\'' +
                ", targa='" + targa + '\'' +
                ", comune='" + comune + '\'' +
                ", prezzoOrario=" + prezzoOrario +
                ", carburante=" + carburante +
                ", patenteRichiesta=" + patenteRichiesta +
                '}';
    }
}