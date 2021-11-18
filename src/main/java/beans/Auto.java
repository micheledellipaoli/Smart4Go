package main.java.beans;

public class Auto extends Veicolo {
    public Auto(String codice, String modello, String marchio, String targa, String comune, double prezzoOrario) {
        super(codice, modello, marchio, targa, comune, prezzoOrario);
        setCarburante(true);
        setPatenteRichiesta(true);
    }
}