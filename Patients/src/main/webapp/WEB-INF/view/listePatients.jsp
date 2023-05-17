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
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Patients</title>
</head>
<body>
 <h1 >
 Liste des Patients
 </h1> 
 <table >
 <tr>
 <th>ID</th><th>Nom Patients</th><th> prenom Patients</th><th>Date 
de naissance</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${Patients}" var="p">
 <tr>
 <td>${p.idPatient }</td>
 <td>${p.nomPatient}</td>
 <td>${p.prenomPatient}</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${p.datenaiss}" /></td>
 <td><a onclick="return confirm('Etes-vous sûr ?')"
href="supprimerPatient?id=${p.idPatient }">Supprimer</a></td>
 <td><a href="modifierPatient?id=${p.idPatient }">Edit</a></td>
 </tr>
 </c:forEach> 
 </table>
</body>
</html>