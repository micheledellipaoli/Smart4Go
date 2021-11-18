package main.java.beans;

public class Motorino extends Veicolo {
    public Motorino(String codice, String modello, String marchio, String targa, String comune, double prezzoOrario) {
        super(codice, modello, marchio, targa, comune, prezzoOrario);
        setCarburante(true);
        setPatenteRichiesta(true);
    }
}