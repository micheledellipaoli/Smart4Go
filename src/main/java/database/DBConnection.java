package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private String url;
    private String user;
    private String password;

    public DBConnection(){
        this.url = "jdbc:postgresql://localhost:5432/postgres";
        this.password = "mikidp96";
        this.user = "postgres";
    }



    public DBConnection(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnetion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //Connessione al Database
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }














}
