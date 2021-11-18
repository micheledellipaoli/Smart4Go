package main.java;

import main.java.beans.*;
import main.java.database.NoleggioDAO;
import main.java.database.UtenteDAO;
import main.java.database.VeicoloDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

        //Creazione ArrayList Patente per un utente
        Patente p = new Patente("012345", Patente.Tipo_patente.Auto);
        ArrayList<Patente> patenti = new ArrayList<Patente>();
        patenti.add(p);



        //Registrazione di un utente
        Calendar data_nascita = Calendar.getInstance();
        Utente u = new Utente("mikeledellipaoli@gmail.com", "Michele", "Delli Paoli", data_nascita, "Marcianise");

        //Oggetto per manipolare la tabella Utente nel Database
        UtenteDAO utenteDAO = new UtenteDAO();

        //utenteDAO.registraUtente(u);
        ArrayList<Utente> utenti = new ArrayList<Utente>();
        utenti = utenteDAO.getAllUtenti();
        System.out.println("Lista utenti: \n" + utenti);




        //Registrazione di un veicolo
        Veicolo v = new Auto("1232411", "Panda", "auto", "AX023DG", "Napoli", 15.00);
        VeicoloDAO veicoloDAO = new VeicoloDAO();
        //veicoloDAO.registraVeicolo(v);
        ArrayList<Veicolo> veicoli = veicoloDAO.getAllVeicoli();
        System.out.println("\nLista veicoli: \n" + veicoli);




        //L'utente effettua due noleggi: uno da 120 min, e uno da 1 min.
        NoleggioDAO noleggioDAO = new NoleggioDAO();
        int lastCodiceNoleggio = noleggioDAO.getLastCodiceNoleggio();
        int newCodice = lastCodiceNoleggio + 1;
        Calendar now = java.util.Calendar.getInstance();

        Noleggio n1 = new Noleggio(newCodice, now, 120, u, v);
        //noleggioDAO.registraNoleggio(n1);

        lastCodiceNoleggio = noleggioDAO.getLastCodiceNoleggio();
        newCodice = lastCodiceNoleggio + 1;
        now = java.util.Calendar.getInstance();

        Noleggio n2 = new Noleggio(newCodice, now, 1, u, v);
        //noleggioDAO.registraNoleggio(n2);



        //L'utente controlla i noleggi effettuati ed i relativi costi.
        ArrayList<Noleggio> noleggiByUtente = noleggioDAO.getNoleggiByUtente(u.getEmail());
        System.out.println("\nNoleggi effettuati dall'utente '"+u.getEmail()+"':");
        for(Noleggio noleggio : noleggiByUtente){
            if(noleggio.isExpired()){
                double daPagare = noleggio.getCostoNoleggio();
                System.out.println("Codice noleggio: "+noleggio.getCodice()+" - da pagare: "+ daPagare);
            }else{
                System.out.println("Codice noleggio: "+noleggio.getCodice()+" - NON terminato. ");
            }
        }

    }
}
