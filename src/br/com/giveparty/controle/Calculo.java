package br.com.giveparty.controle;
 
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Calculo extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException {
        int valor1;
        int valor2;
        int total = 0;
        String nome = (String) req.getParameter("nome");
        String aviso = "";
        try {
            // Eu sei que está feio, em um futuro poderemos refatorar e aplicar princípios de OO e Design 
            valor1 = Integer.parseInt((String) req.getParameter("valor1"));
        } catch (NumberFormatException e) {
            // Tratando para caso seja digitado um valor inválido 
            valor1 = 0;
            aviso = "Algum valor foi digitado incorretamente (em branco ou caractercs não numérimos), atribuímos 0";
        }
         
        try {
            // Eu sei que está feio, em um futuro poderemos refatorar e aplicar princípios de OO e Design 
            valor2 = Integer.parseInt((String) req.getParameter("valor2"));
        } catch (NumberFormatException e) {
            // Tratando para caso seja digitado um valor inválido
            valor2 = 0;
            aviso = "Algum valor foi digitado incorretamente (em branco ou caracters não numérimos), atribuímos 0";
        }
        // Colocando o nome digitado no request que será enviado ao cliente
        req.setAttribute("nome", nome);
         
        // Enviado o aviso ao cliente
        req.setAttribute("aviso", aviso);
 
        total = valor1 + valor2;
         
        // Atribuindo o valor da soma ao rquest que será enviado ao cliente
        req.setAttribute("total", total);
         
        // O Request Dispatcher determina o próximo caminho a seguir.
        // Vamos direcioná-lo para a JSP que iremos criar.
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/show.jsp");
         
        // Enviamos o processo para frente passando request e o response
        requestDispatcher.forward(req, res);
    }
}