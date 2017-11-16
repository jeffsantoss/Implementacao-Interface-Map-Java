<!DOCTYPE html>

<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>Comparações algoritmos</title>    
      <script type="text/javascript">
        $(document).ready(function() {
        	var qtd = prompt("Quantidade de números para inserir");
        	
        	if(qtd){
        	$.ajax({
    			url: "/comparar/executar-algoritmo/",
    			type: "POST",
    			dataType: "json",
    			contentType:'application/json',
    			data: qtd,
    			success: function(data) {
    				
    			}
    		});
        	}
        	
        	        	             
        });
    </script>
</head>
<body>	
</body>
</html>