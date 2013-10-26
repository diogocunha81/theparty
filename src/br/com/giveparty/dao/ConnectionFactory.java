package br.com.giveparty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public ConnectionFactory(){
		try
		{
			Class.forName("org.postgresql.Driver").newInstance();
		}
		catch (Exception e)
		{
		}
	}
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/party","postgres","");
        }
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}