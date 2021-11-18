package main.java.database;

import main.java.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

            Veicolo v = null;
            switch("tipo") {
                case "auto":
                    v = new Auto(codice, modello, marchio, targa, comune, prezzo_orario);
                    break;
                case "motorino":
                    v = new Motorino(codice, modello, marchio, targa, comune, prezzo_orario);
                    break;
                case "bicicletta":
                    v = new Bicicletta(codice, modello, marchio, comune, prezzo_orario);
                    break;
            }
            veicoli.add(v);
        }
        stmt.close();

        return veicoli;
    }

    public Veicolo getVeicoloByCodice(String codiceVeicolo) throws SQLException, ParseException {
        Veicolo v = null;

        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM veicolo WHERE codice='"+codiceVeicolo+"'";

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

            switch("tipo") {
                case "auto":
                    v = new Auto(codice, modello, marchio, targa, comune, prezzo_orario);
                    break;
                case "motorino":
                    v = new Motorino(codice, modello, marchio, targa, comune, prezzo_orario);
                    break;
                case "bicicletta":
                    v = new Bicicletta(codice, modello, marchio, comune, prezzo_orario);
                    break;
            }
        }
        stmt.close();
        return v;
    }


    public void registraVeicolo(Veicolo v) throws SQLException {
        Statement stmt = connection.createStatement();

        String tipo = v.getClass().getName().toString().toLowerCase();

        String sql = "INSERT INTO veicolo (modello, codice, tipo, carburante, marchio, prezzo_orario, patente_richiesta, targa, comune)" +
                " VALUES ('"+ v.getModello() +"', '"+ v.getCodice() +"', '"+ tipo +"', '"+ v.isCarburante() +"', '" +
                 v.getMarchio() +"', '"+ v.getPrezzoOrario() +"', '"+ v.isPatenteRichiesta() +"', '"+ v.getTarga() +"', '"+ v.getComune()+"');";

        System.out.println(sql);

        stmt.executeUpdate(sql);

        stmt.close();
    }
}
