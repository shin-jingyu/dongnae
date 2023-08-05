<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>메인화면 테스트</title>    
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<link href="https://webfontworld.github.io/TheJamsil/TheJamsil.css" rel="stylesheet">    
  </head>
<style>

#hot {
	position :  relative;
 	top : -650px;
 	left : 500px;
	font-family: 'TheJamsil';
	color : #6098F2;
}





</style>
<body>
<jsp:include page="Header.jsp"/>
<jsp:include page="Card.jsp"/>




<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
		<!-- <script type="text/javascript">
			let countNum = 0;
   			const hartCount = document.getElementById("hartCount");
   			const Button = document.getElementById("HartButton");
   			const countNumIn = hartCount.innerText;
   				
   			function clickCounter() {
   				countNum+=1;
   	   			hartCount.innerText = countNum;
   	   			if(countNum >= 100) {
   	   			hartCount.innerText = "99+";
   	   				
   	   			}
   			}
   			Button.addEventListener("click",  clickCounter);
   		</script> -->
   		
</html>