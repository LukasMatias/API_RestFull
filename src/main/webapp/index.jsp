<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="<%=request.getContextPath()%>/Hello">
		Nome: <input type="text" name="nome" /> <br /> <br />
	 Sobrenome: <input type="text" name="sobrenome" /> <br /> 
	 CPF: <input type="text" name= "cpf" maxlength="11" placeholder="000.000.000-00">
	  <br /> 
	 <input type="submit" name="Enviar" />
	 
	</form>
</body>
</html>