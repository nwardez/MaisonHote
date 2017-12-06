<%@page import="co.simplon.maisonHote.Reservation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
 <link rel="stylesheet" href="main.css">
<title>Confirmation R�servation</title>
</head>
<body>

<% Reservation reservation = (Reservation) request.getAttribute("reservation"); %>
		<h1 id='titre'>Merci pour votre confiance !</h1>
		<p>Votre r�servation a �t� enregistr�e : R�f�rence: <%=reservation.getDateEnregistrement()%> avec les informations suivantes :</p>
		<table class="resultTable">
			<tr>
				<td>Identifiant r�servation</td>
				<td><%=reservation.getNumeroResa()%></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><%=reservation.getNom()%></td>
			</tr>
			<tr>
				<td>Pr�nom</td>
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
				<td>Date arriv�e</td>
				<td><%=reservation.getDateArrivee()%></td>
			</tr>
			<tr>
				<td>Date d�part</td>
				<td><%=reservation.getDateDepart()%></td>
			</tr>
			<tr>
				<td>Nombres de personnes</td>
				<td><%=reservation.getNombrePersonnes()%></td>
			</tr>
			<tr>
				<td>Votre r�gion d'origine</td>
				<td><%=reservation.getRegionOrigine()%></td>
			</tr>
			<tr>
				<td>Type de s�jour</td>
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
		
		<h4>Le montant de votre s�jour est de:<%=reservation.calculTarifSejour()%> Euros</h4>
		<!-- <a href="index.html" >Retour</a> -->

</body>
</html>