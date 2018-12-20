<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css"/>				
		<title>Rocket Analytics here</title>
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet">
		
				
		
	</head>
	<body>
		<h1>Rocket Analytics</h1>
		<div id="wrapper">
			<div id="yourData">
				<p id="visitorIP"></p>
		    	<p id="visitorCountry"></p>
		    	<p id="visitorBrowser"></p>
		    	<p id="visitorScreenResolution"></p>
	    	</div>
	    	
			
			<div id="generate"><a href="http://localhost:8080/Analytics/GetRapp">Générer le rapport</a></div>
		</div>
	 <div id="rapp">
		
			<ul id="listIp">
				<li class="lab"><strong>Adresse IP</strong></li>		
				<c:forEach var="utilisateur" items="${ utilisateurs }">		
				<li><c:out value="${ utilisateur.ip }" /></li>
				</c:forEach>
			</ul>
		
			<ul id="listPays">
				<li class="lab"><strong>Pays</strong></li>	
				<c:forEach var="utilisateur" items="${ utilisateurs }">			
				<li><c:out value="${ utilisateur.pays }" /></li>
				</c:forEach>
			</ul>
			<ul id="listNav">
				<li class="lab"><strong>Navigateur</strong></li>			
				<c:forEach var="utilisateur" items="${ utilisateurs }">	
				<li><c:out value="${ utilisateur.browser }" /></li>
				</c:forEach>
			</ul>
			<ul id="listEcran">
				<li class="lab"><strong>Ecran</strong></li>			
				<c:forEach var="utilisateur" items="${ utilisateurs }">	
				<li><c:out value="${ utilisateur.screen }" /></li>
				</c:forEach>
			</ul>			   	 
    	</div> 
    	
    	
    	  
		
		<script type="text/javascript" src="http://www.visitorjs.com/visitor.js?key=YOUR_KEY"></script>		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>		
		<script type="text/javascript" src="script/script.js"></script>     
	</body>
</html>