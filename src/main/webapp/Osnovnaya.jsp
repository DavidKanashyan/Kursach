<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OSAGO</title>

<link rel="stylesheet" href="css/design.css">

</head>
<body>
		<H1>Приветствуем вас в калькуляторе стоимости ОСАГО</H1>
		<H2>Введите необходимые для рассчёта данные</H2>
		<img src="images/merc.jpg" width="400" height="200" alt="Дорогое ОСАГО будет" align="right">
<form action="${pageContext.request.contextPath}/Osag" method="post">

			<label for="first">Введите ТБ</label>
			<input type="text" name="first" id="first" value="5436">
			<br><br>
			<label for="second">Введите КТ</label>
			<input type="text" name="second" id="second" value="1.72">
			<br><br>
			<label for="third">Введите КБМ</label>
			<select id="third" name="third">
				<option value="1">1</option>
				<option value="0.95">0.95</option>
				<option value="0.9">0.9</option>
				<option value="0.85">0.85</option>
				<option value="0.8">0.8</option>
				<option value="0.75">0.75</option>
				<option value="0.7">0.7</option>
				<option value="0.65">0.65</option>
				<option value="0.6">0.6</option>
				<option value="0.55">0.55</option>
				<option value="0.5">0.5</option>
			</select>
			<br><br>
			<label for="fourth">Введите КВС</label>
			<input type="text" name="fourth" id="fourth" value="1.93">
			<br><br>
			<label for="fith">Введите КO</label>
			<select id="fith" name="fith">
				<option value="1.94">1.94</option>
				<option value="1">1</option>
			</select>
			<br><br>
			<label for="sixth">Введите КM</label>
			<select id="sixth" name="sixth">
				<option value="0.6">0.6</option>
				<option value="1">1</option>
				<option value="1.1">1.1</option>
				<option value="1.2">1.2</option>
				<option value="1.4">1.4</option>
				<option value="1.6">1.6</option>
			</select>
			<br><br>
			<label for="seventh">Введите КС</label>
			<select id="seventh" name="seventh">
				<option value="1">1</option>
				<option value="0.95">0.95</option>
				<option value="0.9">0.9</option>
				<option value="0.8">0.8</option>
				<option value="0.7">0.7</option>
				<option value="0.65">0.65</option>
				<option value="0.6">0.6</option>
				<option value="0.5">0.5</option>
			</select>
	<br><br>
		<input type="submit" name="sign" value="Расcчитать плату и сгенерировать PDF">	
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/Sozdateli.jsp" method="post">
			<input type="submit" name="infotmation" value="Создатели">
	</form>
	<br>	
	<form action="${pageContext.request.contextPath}/Avtorizatia.jsp" method="post">		
			<input type="submit" name="sign" value="Выйти из аккаунта">
	</form>
</body>
</html>