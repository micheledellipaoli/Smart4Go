package main.java.database;

import main.java.beans.Noleggio;
import main.java.beans.Utente;
import main.java.beans.Veicolo;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class NoleggioDAO {

    private Connection connection;

    public NoleggioDAO() throws SQLException, ClassNotFoundException {
        DBConnection db = new DBConnection();
        connection = db.getConnetion();
    }

    public ArrayList<Noleggio> getAllNoleggi() throws SQLException, ParseException, ClassNotFoundException {
        ArrayList<Noleggio> noleggi = new ArrayList<Noleggio>();

        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM noleggio";

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int codice = rs.getInt("codice_noleggio");

            //codice per convertite il formato Date estratto dal Database nel formato Calendar compatibile con l'oggetto java Operazione
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = sdf.parse(rs.getString("data_inizio"));
            Calendar data_inizio = Calendar.getInstance();
            data_inizio.setTime(date);

            int durata = rs.getInt("durata");

            String emailUtente = rs.getString("utente");
            String codiceVeicolo = rs.getString("veicolo");

            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.getUtenteByEmail(emailUtente);

            VeicoloDAO veicoloDAO = new VeicoloDAO();
            Veicolo veicolo = veicoloDAO.getVeicoloByCodice(codiceVeicolo);
        }
        stmt.close();
        return noleggi;
    }

    public ArrayList<Noleggio> getNoleggiByUtente(String emailUtente) throws SQLException, ParseException, ClassNotFoundException {
        ArrayList<Noleggio> noleggi = new ArrayList<Noleggio>();

        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM noleggio WHERE utente='"+emailUtente+"'";

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int codice = rs.getInt("codice_noleggio");

            //codice per convertite il formato Date estratto dal Database nel formato Calendar compatibile con l'oggetto java Operazione
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = sdf.parse(rs.getString("data_inizio"));
            Calendar data_inizio = Calendar.getInstance();
            data_inizio.setTime(date);

            int durata = rs.getInt("durata");

            String email = rs.getString("utente");
            String codiceVeicolo = rs.getString("veicolo");

            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.getUtenteByEmail(emailUtente);

            VeicoloDAO veicoloDAO = new VeicoloDAO();
            Veicolo veicolo = veicoloDAO.getVeicoloByCodice(codiceVeicolo);
        }
        stmt.close();
        return noleggi;
    }


    public int getLastCodiceNoleggio() throws SQLException {
        int maxCodice = 0;

        Statement stmt = connection.createStatement();

        String sql = "SELECT MAX(codice_noleggio) FROM noleggio";

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            if(rs.getInt("max") != 0){
                maxCodice = rs.getInt("max");
            }
        }
        stmt.close();
        return maxCodice;
    }

    public boolean registraNoleggio(Noleggio n) throws SQLException {
        Statement stmt = connection.createStatement();

        java.sql.Date data_inizio = new java.sql.Date(n.getData_inizio().getTimeInMillis());

        String sql = "INSERT INTO noleggio (codice_noleggio, data_inizio, durata, utente, veicolo)" +
                " VALUES ('"+ n.getCodice() +"', '"+ data_inizio +"', '"+ n.getDurata() +"', '" +
                 n.getUtente().getEmail() +"', '" + n.getVeicolo().getCodice() +"');";

        int intResult = stmt.executeUpdate(sql);

        boolean result = false;
        if(intResult == 1){
            result = true;
        }
        stmt.close();

        return result;
    }
}
