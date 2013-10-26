package br.com.giveparty.controle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

public class UserCreate extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
        String nome = request.getParameter("nome");
        String password = request.getParameter("password");
        String perfil = ("A");
        
        password = criptografa(password);
        
        DAOUser DAO = new DAOUser();
        User user = new User(nome, password, perfil);
        boolean u = DAO.CreateUser(user);
        
        if (u == false){
        	HttpSession session = request.getSession();
            session.setAttribute("user", user);
            rd = request.getRequestDispatcher("/WEB-INF/info.jsp");
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            rd = request.getRequestDispatcher("/index.html");
        }
         
        rd.forward(request, response);
        
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
