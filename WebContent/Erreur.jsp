<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Erreur</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1>Une erreur a été détectée</h1>
		<p>L'erreur ci-dessous s'est produite durant l'enregistrement de votre réservation :</p>
		<p class="error"><%=request.getAttribute("message") %></p>
		<p>Merci de vérifier les informations qui ont été saisie.</p>
		
		<%@include file="/reservation.html" %>
	</body>
</html>