<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Erreur</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1>Une erreur a �t� d�tect�e</h1>
		<p>L'erreur ci-dessous s'est produite durant l'enregistrement de votre r�servation :</p>
		<p class="error"><%=request.getAttribute("message") %></p>
		<p>Merci de v�rifier les informations qui ont �t� saisie.</p>
		
		<%@include file="/reservation.html" %>
	</body>
</html>