<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Админ</title>

<link rel="stylesheet" href="css/design.css">

</head>
<body>
		<H1>Приветствуем вас в странице администратора</H1>
		<H2>Здесь вы можете поменять значения</H2>
<form action="${pageContext.request.contextPath}/Osnovnaya.jsp" method="post">

			<label for="first">Введите ТБ</label>
			<input type="text" name="first" id="first" value="${first}">
			<br><br>
			<label for="second">Введите КТ</label>
			<input type="text" name="second" id="second" value="${second}">
			<br><br>
			<label for="third">Введите КБМ</label>
			<input type="text" name="third" id="third" value="${third}">
			<br><br>
			<label for="fourth">Введите КВС</label>
			<input type="text" name="fourth" id="fourth" value="${fourth}">
			<br><br>
			<label for="fith">Введите КO</label>
			<input type="text" name="fith" id="fith" value="${fith}">
			<br><br>
			<label for="sixth">Введите КM</label>
			<input type="text" name="sixth" id="sixth" value="${sixth}">
			<br><br>
			<label for="seventh">Введите КС</label>
			<input type="text" name="seventh" id="seventh" value="${seventh}">
	<br><br>
		<input type="submit" name="sign" value="Сохранить значения и перейти к основному окну">	
	</form>
</body>
</html>