package main.java;

import main.java.beans.*;
import main.java.database.DBConnection;
import main.java.database.NoleggioDAO;
import main.java.database.UtenteDAO;
import main.java.database.VeicoloDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

        //Creazione ArrayList Patente
        Patente p = new Patente("012345", Patente.Tipo_patente.Auto);
        ArrayList<Patente> patenti = new ArrayList<Patente>();
        patenti.add(p);

        Calendar data_nascita = Calendar.getInstance();
        //Creazione utente
        Utente u = new Utente("mikeledellipaoli@gmail.com", "Michele", "Delli Paoli", data_nascita, "Marcianise");

        //Oggetto per manipolare la tabella Utente nel Database
        UtenteDAO utenteDAO = new UtenteDAO();

        //utenteDAO.registraUtente(u);
        ArrayList<Utente> utenti = new ArrayList<Utente>();
        utenti = utenteDAO.getAllUtenti();
        System.out.println("Lista utenti: \n" + utenti);

        Veicolo v = new Auto("1232411", "Panda", "auto", "AX023DG", "Napoli", 15.00);
        VeicoloDAO veicoloDAO = new VeicoloDAO();
        //veicoloDAO.registraVeicolo(v);
        ArrayList<Veicolo> veicoli = veicoloDAO.getAllVeicoli();
        System.out.println("Lista veicoli: \n" + veicoli);

        NoleggioDAO noleggioDAO = new NoleggioDAO();
        int lastCodiceNoleggio = noleggioDAO.getLastCodiceNoleggio();
        int newCodice = lastCodiceNoleggio + 1;

        Calendar now = java.util.Calendar.getInstance();
        Noleggio n = new Noleggio(newCodice, now, 120, u, v);
        noleggioDAO.registraNoleggio(n);

        ArrayList<Noleggio> noleggiByUtente = noleggioDAO.getNoleggiByUtente(u.getEmail());
        for(Noleggio noleggio : noleggiByUtente){
            if(noleggio.isExpired()){
                double daPagare = noleggio.getCostoNoleggio();
                System.out.println("Noleggio da pagare: "+ daPagare);
            }
        }

    }
}
