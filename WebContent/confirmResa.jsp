<%@page import="co.simplon.maisonHote.Reservation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
 <link rel="stylesheet" href="main.css">
<title>Confirmation Réservation</title>
</head>
<body>

<% Reservation reservation = (Reservation) request.getAttribute("reservation"); %>
		<h1 id='titre'>Merci pour votre confiance !</h1>
		<p>Votre réservation a été enregistrée : Référence: <%=reservation.getDateEnregistrement()%> avec les informations suivantes :</p>
		<table class="resultTable">
			<tr>
				<td>Identifiant réservation</td>
				<td><%=reservation.getNumeroResa()%></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><%=reservation.getNom()%></td>
			</tr>
			<tr>
				<td>Prénom</td>
				<td><%=reservation.getPrenom()%></td>
			</tr>
			<tr>
				<td>Adresse mail</td>
				<td><%=reservation.getMail()%></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><%=reservation.getTelephone()%></td>
			</tr>
			<tr>
				<td>Date arrivée</td>
				<td><%=reservation.getDateArrivee()%></td>
			</tr>
			<tr>
				<td>Date départ</td>
				<td><%=reservation.getDateDepart()%></td>
			</tr>
			<tr>
				<td>Nombres de personnes</td>
				<td><%=reservation.getNombrePersonnes()%></td>
			</tr>
			<tr>
				<td>Votre région d'origine</td>
				<td><%=reservation.getRegionOrigine()%></td>
			</tr>
			<tr>
				<td>Type de séjour</td>
				<td><%=reservation.getTypeSejour()%></td>
			</tr>
			<tr>
				<td>Fumeur</td>
				<td><%=reservation.fumeur()%></td>
			</tr>
			<tr>
				<td>Parking</td>
				<td><%=reservation.parking()%></td>
			</tr>
			<tr>
				<td>Animal</td>
				<td><%=reservation.animal()%></td>
			</tr>
			
			
		</table>
		
		<h4>Le montant de votre séjour est de:<%=reservation.calculTarifSejour()%> Euros</h4>
		<!-- <a href="index.html" >Retour</a> -->

</body>
</html>