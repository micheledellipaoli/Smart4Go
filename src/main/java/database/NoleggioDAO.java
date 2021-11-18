package main.java.database;

import main.java.beans.Noleggio;
import main.java.beans.Utente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NoleggioDAO {

    private Connection connection;

    public NoleggioDAO() throws SQLException, ClassNotFoundException {
        DBConnection db = new DBConnection();
        connection = db.getConnetion();
    }

    public int getMaxCodiceNoleggio() throws SQLException {
        int maxCodice = 0;

        Statement stmt = connection.createStatement();

        String sql = "SELECT MAX(codice) FROM noleggio";

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            maxCodice = rs.getInt("MAX(codice");
        }
        stmt.close();
        return maxCodice;
    }

    public boolean registraNoleggio(Noleggio n) throws SQLException {
        Statement stmt = connection.createStatement();

        String sql = "INSERT INTO noleggio (codice, data_inizio, durata, utente, veicolo)" +
                " VALUES ('"+ n.getCodice() +"', '"+ n.getData_inizio() +"', '"+ n.getDurata() +"', '" +
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
