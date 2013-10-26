package br.com.giveparty.controle;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.giveparty.dao.DAOUser;
import br.com.giveparty.modelo.User;

 
public class UserValidator extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
 
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd;
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        
        
        User user = validateLogin(name, password);
       
        if (user == null){
            rd = req.getRequestDispatcher("/loginError.jsp");
        }
        else{
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            rd = req.getRequestDispatcher("/index.html");
        }
         
        rd.forward(req, res);
    }
 
    private User validateLogin(String name, String password) throws ServletException, IOException {
        // All parameters must be valid
    	
        if (name == null || password == null){
            return null;
        }
        
        password = criptografa(password);
        
        DAOUser DAO = new DAOUser();
        User user = new User(name, password, "");
        boolean u = DAO.VerificaLogin(user);
        
        if (u == true){
        	return user;
        }
        else
        	return null;
    }
	private String criptografa(String password) throws ServletException, IOException {
		
        MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        String senha = hexString.toString();
		return senha;
	}
}