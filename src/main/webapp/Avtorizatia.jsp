<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Авторизация</title>

<link rel="stylesheet" href="css/design.css">

</head>
<body>
 <form action="${pageContext.request.contextPath}/SignIn" method="post">
			<input type="text" name="login" id="login" placeholder="Логин" value="${login}">
			<br>
			<br>
			<input type="text" name="password" id="password" placeholder="Пароль" value="${password}">
			<br>
			<br>
			<input type="submit" name="signin" value="Войти">
		  </form>
			<br>	
			
	       <form action="${pageContext.request.contextPath}/Registratia.jsp" method="post">		
			<input type="submit" name="signup" value="Зарегистрироваться">
	        </form>
			<br>
</body>
</html>