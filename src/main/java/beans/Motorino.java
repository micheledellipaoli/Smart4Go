package main.java.beans;

public class Motorino extends Veicolo {
    public Motorino(String codice, String modello, String marchio, String targa, String comune, double prezzoOrario) {
        super(codice, modello, marchio, targa, comune, prezzoOrario);
        setTipo("motorino");
        setCarburante(true);
        setPatenteRichiesta(true);
    }
}