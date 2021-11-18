package main.java.database;

import main.java.beans.Utente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UtenteDAO {

    private Connection connection;

    public UtenteDAO() throws SQLException, ClassNotFoundException {
        DBConnection db = new DBConnection();
        connection = db.getConnetion();
    }

    public ArrayList<Utente> getAllUtenti() throws SQLException, ParseException {
        ArrayList<Utente> utenti = new ArrayList<Utente>();

        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM utente";

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String cognome = rs.getString("cognome");

            //codice per convertite il formato Date estratto dal Database nel formato Calendar compatibile con l'oggetto java Operazione
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(rs.getString("data_nascita"));
            Calendar data_nascita = Calendar.getInstance();
            data_nascita.setTime(date);

            String luogo_nascita = rs.getString("luogo_nascita");
            Utente u = new Utente(email, nome, cognome, data_nascita, luogo_nascita);

            utenti.add(u);
        }
        stmt.close();

        return utenti;
    }

    public Utente getUtenteByEmail(String emailUtente) throws SQLException, ParseException {
        Utente u = null;

        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM utente WHERE email='"+emailUtente+"'";

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String cognome = rs.getString("cognome");

            //codice per convertite il formato Date estratto dal Database nel formato Calendar compatibile con l'oggetto java Operazione
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(rs.getString("data_nascita"));
            Calendar data_nascita = Calendar.getInstance();
            data_nascita.setTime(date);

            String luogo_nascita = rs.getString("luogo_nascita");
            u = new Utente(email, nome, cognome, data_nascita, luogo_nascita);
        }
        stmt.close();
        return u;
    }

    public void registraUtente(Utente u) throws SQLException {
        Statement stmt = connection.createStatement();

        java.sql.Date data_nascita = new java.sql.Date(u.getData_nascita().getTimeInMillis());

        String sql = "INSERT INTO utente (nome, email, cognome, data_nascita, luogo_nascita)" +
                " VALUES ('"+ u.getNome() +"', '"+ u.getEmail() +"', '"+ u.getCognome() +"', '"+ data_nascita +"', '" +
                 u.getLuogo_nascita() +"');";

        System.out.println(sql);

        stmt.executeUpdate(sql);

        stmt.close();
    }
}
