<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Hello Page</title>
</head>
<body>

<h2>List of Names:</h2>

<c:forEach var="name" items="${msg}">
    <p>${name}</p>
</c:forEach>

</body>
</html>