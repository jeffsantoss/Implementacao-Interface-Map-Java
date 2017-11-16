<!DOCTYPE html>

<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>Comparações algoritmos</title>    
      <script type="text/javascript">
        $(document).ready(function() {
        	
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
    </script>
</head>
<body>	
	<h1 id="carregando" style="display: inline-block;">CARREGANDO...</h1>
</body>
</html>