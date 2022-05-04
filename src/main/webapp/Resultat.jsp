<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>

<link rel="stylesheet" href="css/design.css">

</head>
<body>
<p><strong>Стоимость осаго составит: </strong> ${result}</p>
<br><br>
 <form action="${pageContext.request.contextPath}/Osnovnaya.jsp">
	<input type="submit" name="back" value="Назад">
</form>
</body>
</html>