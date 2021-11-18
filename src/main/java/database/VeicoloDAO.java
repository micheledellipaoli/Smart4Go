package main.java.database;

import main.java.beans.Utente;
import main.java.beans.Veicolo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VeicoloDAO {

    private Connection connection;

    public VeicoloDAO() throws SQLException, ClassNotFoundException {
        DBConnection db = new DBConnection();
        connection = db.getConnetion();
    }

    public ArrayList<Veicolo> getAllVeicoli() throws SQLException, ParseException {
        ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>();

        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM veicolo";

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String modello = rs.getString("modello");
            String codice = rs.getString("codice");
            String tipo = rs.getString("tipo");
            boolean carburante = rs.getBoolean("carburante");
            String marchio = rs.getString("marchio");
            double prezzo_orario = rs.getDouble("prezzo_orario");
            boolean patente_richiesta = rs.getBoolean("patente_richiesta");
            String targa = rs.getString("targa");
            String comune = rs.getString("comune");

            Veicolo v = new Veicolo(modello, codice, tipo, carburante, marchio, prezzo_orario, patente_richiesta, targa, comune);

            veicoli.add(v);
        }
        stmt.close();

        return veicoli;
    }


    public void registraVeicolo(Veicolo v) throws SQLException {
        Statement stmt = connection.createStatement();

        String sql = "INSERT INTO veicolo (modello, codice, tipo, carburante, marchio, prezzo_orario, patente_richiesta, targa, comune)" +
                " VALUES ('"+ v.getModello() +"', '"+ v.getCodice() +"', '"+ v.getTipo() +"', '"+ v.isCarburante() +"', '" +
                 v.getMarchio() +"', '"+ v.getPrezzoOrario() +"', '"+ v.isPatenteRichiesta() +"', '"+ v.getTarga() +"', '"+ v.getComune()+"');";

        System.out.println(sql);

        stmt.executeUpdate(sql);

        stmt.close();
    }
}
