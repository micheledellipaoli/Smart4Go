package main.java.beans;

public class Bicicletta extends Veicolo {
    public Bicicletta(String codice, String modello, String marchio, String comune, double prezzoOrario) {
        super(codice, modello, marchio, comune, prezzoOrario);
        setTipo("bicicletta");
        setTarga("");
        setCarburante(false);
        setPatenteRichiesta(false);

    }
}