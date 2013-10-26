package br.com.giveparty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.giveparty.modelo.User;

public class DAOUser {
	private Connection connection;
	private ResultSet r;
	private PreparedStatement stmt;
	
	public DAOUser(){
		/*try
		{
			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/party","postgres","");
		}
		catch (Exception e)
		{
		}*/
		this.connection = new ConnectionFactory().getConnection();
	}
	public boolean VerificaLogin(User l) {
		String sql = "SELECT * FROM public.user WHERE name = ? AND password = ?";
		boolean a;
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, l.getNome());
			stmt.setString(2, l.getPassword());
			r = stmt.executeQuery();
			if (r.next()){
				if(r.getString("status").equals("I")){
					a = false;
				}
				else
					a = true;
			}
			else 
				a = false;
			stmt.close();
			return a;
		}
		catch(SQLException e){
			String sqlState = e.getSQLState();
			if(sqlState.equals("23505")){
			  	JOptionPane.showMessageDialog(null, "Erro de duplicidade.");
			}
			if(sqlState.equals("23502")){
			 	JOptionPane.showMessageDialog(null, "Os campos obrigatórios não estão preenchidos.");
			}
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean CreateUser(User l) {
		String sql = "INSERT INTO public.usuario (nome, password, perfil) VALUES (?,?,?)";
		try
		{
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, l.getNome());
			stmt.setString(2, l.getPassword());
			stmt.setString(3, l.getPerfil());
			stmt.addBatch();
			stmt.executeBatch();
			connection.commit();
			stmt.close();
			return true;
		}
		catch (SQLException e)
		{
		    String sqlState = e.getSQLState();
		    if(sqlState.equals("23505")){
		    	JOptionPane.showMessageDialog(null, "Erro de duplicidade.");
		    }
		    if(sqlState.equals("23502")){
		    	JOptionPane.showMessageDialog(null, "Os campos obrigatórios não estão preenchidos.");
		    }
		    e.printStackTrace();
		    return false;
		}			
			
	}
}
