<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Регистрация</title>

<link rel="stylesheet" href="css/design.css">

</head>
<body>
	<form action="${pageContext.request.contextPath}/SignUp" method="post">
			<input type="text" name="login" id="login" placeholder="Логин">
			<br><br>
			<input type="text" name="password" id="password" placeholder="Пароль">
			<br><br>
			<label for="fith">Обычный пользователь или админ?</label>
			<select id="fith" name="fith">
				<option value="user">Обычный пользователь</option>
				<option value="admin">Администратор</option>
			</select>
			<br><br>
			<input type="submit" name="signup" value="Зарегистрироваться">
		  </form>
	<br>	
</body>
</html>