<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.simplon.maisonHote.Reservation"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des réservations</title>
</head>
<body>
<h1>Liste des réservationse</h1>
		<p>Liste des réservations en cours</p>
			
		<table border=1 class="ticketTable">
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Numero de réservationt</th>
			<th>Date de l'enregistrement</th>
			<th>Date d'arrivée</th>
			<th>Date de départ</th>
			<th>Nombre de personnes</th>
			<th>Téléphone</th>
			<th>Adresse mail</th>
			
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
						<td><%=serveur.getNom()%></td>
						<td><%=serveur.getPrenom()%></td>
						<td><%=serveur.getNumeroResa()%></td>
						<td><%=dateFormater.format(serveur.getDateEnregistrement())%></td>
						<td><%=dateFormater.format(serveur.getDateArrivee())%></td>
						<td><%=dateFormater.format(serveur.getDateDepart())%></td>
						<td><%=serveur.getNombrePersonnes()%></td>
						<td><%=serveur.getTelephone()%></td>
						<td><%=serveur.getMail()%></td>
					</tr>
		<%      }
			}
		%>
		</table>
		<a href="index.html" >Retour</a>

</body>
</html>