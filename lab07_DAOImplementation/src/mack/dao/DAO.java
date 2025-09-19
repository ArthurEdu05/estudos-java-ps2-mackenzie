package mack.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DAO {

    protected Connection connection;

    protected Connection connect() throws Exception{
        if(this.connection == null || !this.connection.isClosed()){
            Class.forName("org.postgresql.Driver");
		    String url = "jdbc:postgresql://db.pqrgzgphhdkodrdtovdq.supabase.co:5432/postgres?user=postgres&password=OlaMundo01!";
		
            this.connection = DriverManager.getConnection(url);
        }
        return this.connection;
    }

    public Connection getConnection(){
        return this.connection;
    }

}