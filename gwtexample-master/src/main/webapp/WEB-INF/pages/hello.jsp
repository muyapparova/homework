<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Список товаров</h2>

<core:forEach var="good" items="${goods}">
    ${good.id} ${good.name} ${good.bought} <a href="buy?id=${good.id}">Купить</a> <br>
</core:forEach>

<br>
<a href="<core:url value="../j_spring_security_logout" />" > Logout</a>
<br>

<a href="../goods/admin">Admin</a>

</body>
</html>
