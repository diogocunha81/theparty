<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<script src="jquery.maskedinput.min.js"></script>
		<script src="jquery.maskedinput.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Create</title>
    </head>
    <body>
        <form action="/GiveParty/userCreate" method="post">
            Email: <input type="email" name="email"/> <br>
            Password: <input type="password" name="password"/> <br>
            Nome: <input type="text" name="nome"/> <br>            
            CPF/CNPJ: <input type="text" name="cpf"/> <br>
            Telefone: <input id="campoTelefone" type="text" name="telefone"/> <br>
            Data Nascimento: <input type="date" name="data_nascimento"/> <br>
            Sexo:
            <input type="radio" name="sexo" value="Masculino">Masculino</>
    		<input type="radio" name="sexo" value="Feminino">Feminino</> <br>
    	    Estado Civil: 
    	    <select name="estado_civil">
    	    	<option value="Solteiro">Solteiro</option>
    	    	<option value="Casado">Casado</option>
    	    	<option value="Divorciado">Divorciado</option>
    	    	<option value="Viuvo">Viúvo</option>
    	    </select>
    	    <br>
            <input type="submit" value="Create"/>
        </form>
    </body>
    <script>
		jQuery(function($){
			$("#campoTelefone").mask("(99) 9999-9999");
		});
	</script>

</html>
