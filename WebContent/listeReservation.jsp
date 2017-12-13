<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.simplon.maisonHote.Reservation"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="main.css">
<title>Liste des réservations</title>
</head>
<body>
<h1>Liste des réservations en cours</h1>
			
		<table border=1 class="ticketTable">
		<tr>
			<th>Reference de réservation</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date d'arrivée</th>
			<th>Nombres de nuits</th>
			<th>Nombre de personnes</th>
			<th>Fumeur</th>
			<th>Animal</th>
			<th>Parking</th>
			<th>Type de séjour</th>
			<th>Téléphone</th>
			<th>Adresse mail</th>
			<th>Prix total</th>
			<th>Consulter</th>
			
			
			
		</tr>
		<%
			SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Collection<Reservation> listeReservations = (Collection<Reservation>) request.getAttribute("reservation");
			if(listeReservations != null){
				Iterator it = listeReservations.iterator() ;
			    while (it.hasNext()){
			    	Reservation serveur=(Reservation) it.next() ;
		%>
					<tr>
						<td><%=serveur.getNumeroResa()%></td>
						<td><%=serveur.getNom()%></td>
						<td><%=serveur.getPrenom()%></td>
						<td><%=serveur.getDateArrivee()%></td>
						<td><%=serveur.getNuits()%></td>
						<td><%=serveur.getNombrePersonnes()%></td>
						<td><%=serveur.fumeur()%></td>
						<td><%=serveur.animal()%></td>
						<td><%=serveur.parking()%></td>
						<td><%=serveur.getTypeSejour()%></td>
						<td><%=serveur.getTelephone()%></td>
						<td><%=serveur.getMail()%></td>
						<td><%=serveur.calculTarifSejour()%></td>
						<td><a href="http://ton lien"><img src="oeil.png" alt="Voir le détail de la réservation"></a></td>
					</tr>
		<%      }
			}
		%>
		</table>
		<a href="index.html" >Retour</a>

</body>
</html>