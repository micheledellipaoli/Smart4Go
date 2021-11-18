package main.java.database;

import main.java.beans.Utente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UtenteDAO {

    private Connection connection;

    public UtenteDAO() throws SQLException, ClassNotFoundException {
        DBConnection db = new DBConnection();
        connection = db.getConnetion();
    }

    public boolean registraUtente(Utente u) throws SQLException {
        Statement stmt = connection.createStatement();

        String sql = "INSERT INTO utente (email, nome, cognome, data_nascita, luogo_nascita)" +
                " VALUES ("+ u.getEmail() +", "+ u.getNome() +", "+ u.getCognome() +", "+ u.getData_nascita() +", " +
                ""+ u.getData_nascita() +");";

        int intResult = stmt.executeUpdate(sql);

        boolean result = false;
        if(intResult == 1){
            result = true;
        }
        stmt.close();

        return result;
    }
}
