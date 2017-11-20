<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="form" class="com.ffb.construcao.controller.ComparacaoForm"/>

<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Comparações algoritmos</title>    
      <script type="text/javascript">
        $(document).ready(function() {
        	
        	$("#btn-comparar").click(function(){
        		
        		var qtd = prompt("Quantidade de números para inserir");
            	
            	$.ajax({
        			url: "/comparar/executar-algoritmo/",
        			type: "POST",
        			dataType: "json",
        			contentType:'application/json',
        			data: qtd,
        			success: function(data) {
        				console.log("tempo da minha implementação: " + data.tempoMeu);
        				console.log("tempo da implementação da caelum: " + data.tempoCaelum);
        				console.log("tempo da implementação do java: " + data.tempoJava);    				
        			}
        		});        	             
        		
        	});
        	
		});
    </script>
</head>

<div class="container">
  <h2>Condensed Table</h2>
  <p>The .table-condensed class makes a table more compact by cutting cell padding in half:</p>            
  <table class="table table-condensed">
    <thead>
      <tr>
        <th>Imple.</th>
        <th>10.000</th>
        <th>100.000</th>        
        <th>1.000.000</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>FFB</td>
        <td>Caleum</td>
        <td>Java</td>
      </tr>
      <tr>
      <c:forEach var="tempoCaelum" items="${form.tempoCaleum}">
        <td>${tempoCaelum}</td>
      </c:forEach>
      </tr>
      <tr>
      <c:forEach var="tempoFBuni" items="${form.tempoFBuni}">
        <td>${tempoFBuni}</td>
      </c:forEach>
      </tr>
      <tr>
      <c:forEach var="tempoJava" items="${form.tempoJava}">
        <td>${tempoJava}</td>
      </c:forEach>
      </tr>
    </tbody>
  </table>
</div>

</body>
</html>