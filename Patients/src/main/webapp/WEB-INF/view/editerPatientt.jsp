<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>

<meta charset="windows-1256">
<title>Modifier un Patient</title>
</head>
<body>
<form action="updatePatient" method="post">
<pre>
id : <input type="text" name="idPatient" value="${patient.idPatient}">
nom :<input type="text" name="nomPatient" value="${patient.nomPatient}">
prenom :<input type="text" name="prenomPatient" value="${patient.prixPatient}">
Date naissance:
 <fmt:formatDate pattern="yyyy-MM-dd" value="${patient.datenaiss}"
var="formatDate" />
 <input type="date" name="date" value="${formatDate}"></input>
<input type="submit" value="Modifier">
</pre>
</form>
<br/>
<br/>
<a href="listePatients">Liste Patient</a>
</body>
</html>