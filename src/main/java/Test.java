package main.java;

import main.java.beans.Patente;
import main.java.beans.Utente;
import main.java.beans.Veicolo;
import main.java.database.DBConnection;
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
        //utenteDAO.getAllUtenti();

        Veicolo v = new Veicolo("Panda", "1232411", "auto", true, "Fiat", 15.00, true, "AX023DG", "Napoli");
        VeicoloDAO veicoloDAO = new VeicoloDAO();
        veicoloDAO.registraVeicolo(v);
        ArrayList<Veicolo> veicoli = veicoloDAO.getAllVeicoli();
        System.out.println(veicoli);


    }
}
