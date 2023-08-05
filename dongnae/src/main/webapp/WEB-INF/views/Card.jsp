<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Card</title>
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<link href="https://webfontworld.github.io/TheJamsil/TheJamsil.css" rel="stylesheet">
</head>
<style>
	#HotImg {
	width: 900px;
	height: auto;
	position :  relative;
	left: 500px;
	top: -620px;
	font-family: 'TheJamsil';
}
#HotImg2 {
	width: 900px;
	height: auto;
	position :  relative;
	left: 500px;
	top: 50px;
	font-family: 'TheJamsil';
}

#message {
	width: 20px;
	height: auto;
}

#Hart {
	width: 20px;
	height: auto;
}

#HartButton1, #HartButton2, #HartButton3, #HartButton4, #HartButton5, #HartButton6 {
	position :  relative;
	left: 90px;
}

#messageButton1, #messageButton2, #messageButton3, #messageButton4, #messageButton5, #messageButton6 {
	position :  relative;
	left: 70px;
	
}
</style>
<body>
	
	<div id="HotImg2" class="row row-cols-1 row-cols-md-3 g-4">
<div class="col">
    <div class="card h-100">
      <img src="resources/images/img1.png" class="card-img-top" alt="...">
      <div class="card-body">
	<div style=" cursor: pointer;" onclick="window.open('http://localhost:8080/Detail.jsp');">
        <h5 class="card-title">테스트 1</h5>
      </div>
        <h4 id="price" class="card-title">0000원</h4>
        <p class="card-text">내용입니다</p>
        <p class="card-text"><small class="text-muted">3분 전</small>
        
        <button id="messageButton1" type="button" class="btn btn-outline-primary position-relative"><img id="message" src="resources/images/message1.png">
        <span id="messageCounter1" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 0
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
 		 <script type="text/javascript">
			let countNumMessage1 = 0;
   			const messageCount1 = document.getElementById("messageCounter1");
   			const messageButton1 = document.getElementById("messageButton1");
   				
   			function clickCounter1() {
   				countNumMessage1+=1;
   	   			messageCount1.innerText = countNumMessage1;
   	   			if(countNumMessage1 >= 100) {
   	   			messageCount1.innerText = "99+";
   	   				
   	   			}
   			}
   			messageButton1.addEventListener("click",  clickCounter1);
   		</script>
  		<button id="HartButton1" type="button" class="btn btn-outline-primary position-relative"><img id="Hart" src="resources/images/Hart.png">
        <span id="hartCount1" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
        0
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  		<script type="text/javascript">
			let countNumHart1 = 0;
   			const hartCount1 = document.getElementById("hartCount1");
   			const HartButton1 = document.getElementById("HartButton1");
   			
   			function HartclickCounter1() {
   				countNumHart1+=1;
   	   			hartCount1.innerText = countNumHart1;
   	   			if(countNumHart1 >= 100) {
   	   			hartCount1.innerText = "99+";
   	   				
   	   			}
   			}
   			HartButton1.addEventListener("click",  HartclickCounter1);
   		</script>
  	</button>
        </p>
    </div>
  </div>
  </div>
  <div class="col">
    <div class="card h-100">
      <img src="resources/images/img2.png" class="card-img-top" alt="...">
      <div class="card-body">
	<div style=" cursor: pointer;" onclick="window.open('http://localhost:8080/Detail.jsp');">
        <h5 class="card-title">테스트 2</h5>
      </div>
        <h4 id="price" class="card-title">0000원</h4>
        <p class="card-text">내용입니다</p>
        <p class="card-text"><small class="text-muted">3분 전</small>
        <button id="messageButton2" type="button" class="btn btn-outline-primary position-relative"><img id="message" src="resources/images/message1.png">
        <span id="messageCounter2" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 0
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
  	<script type="text/javascript">
			let countNumMessage2 = 0;
   			const messageCount2 = document.getElementById("messageCounter2");
   			const messageButton2 = document.getElementById("messageButton2");
   				
   			function clickCounter2() {
   				countNumMessage2+=1;
   	   			messageCount2.innerText = countNumMessage2;
   	   			if(countNumMessage2 >= 100) {
   	   			messageCount2.innerText = "99+";
   	   				
   	   			}
   			}
   			messageButton2.addEventListener("click",  clickCounter2);
   		</script>
  		<button id="HartButton2" type="button" class="btn btn-outline-primary position-relative"><img id="Hart" src="resources/images/Hart.png">
        <span id="hartCount2" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		0
    	<span class="visually-hidden">unread messages</span>
 		 </span>
 		 
  	</button>
  	
        </p>
    </div>
  </div>
  </div>
 <div class="col">
    <div class="card h-100">
      <img src="resources/images/img3.png" class="card-img-top" alt="...">
      <div class="card-body">
	<div style=" cursor: pointer;" onclick="window.open('http://localhost:8080/Detail.jsp');">
        <h5 class="card-title">테스트 3</h5>
      </div>
        <h4 id="price" class="card-title">0000원</h4>
        <p class="card-text">내용입니다</p>
        <p class="card-text"><small class="text-muted">3분 전</small>
        <button id="messageButton" type="button" class="btn btn-outline-primary position-relative"><img id="message" src="resources/images/message1.png">
        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
  		<button id="HartButton3" type="button" class="btn btn-outline-primary position-relative"><img id="Hart" src="resources/images/Hart.png">
        <span id="hartCount3" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
        </p>
    </div>
  </div>
  </div>
</div>>

 <div class="jb-division-line"></div>

<h1 id="hot">최근 핫한 상품</h1>


<div id="HotImg" class="row row-cols-1 row-cols-md-3 g-4">
<div class="col">
    <div class="card h-100">
      <img src="resources/images/img1.png" class="card-img-top" alt="...">
      <div class="card-body">
	<div style=" cursor: pointer;" onclick="window.open('http://localhost:8080/Detail.jsp');">
        <h5 class="card-title">테스트 1</h5>
      </div>
        <h4 id="price" class="card-title">0000원</h4>
        <p class="card-text">내용입니다</p>
        <p class="card-text"><small class="text-muted">3분 전</small>
        <button id="messageButton" type="button" class="btn btn-outline-primary position-relative"><img id="message" src="resources/images/message1.png">
        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
  		<button id="HartButton4" type="button" class="btn btn-outline-primary position-relative"><img id="Hart" src="resources/images/Hart.png">
        <span id="hartCount4" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
        </p>
    </div>
  </div>
  </div>
  <div class="col">
    <div class="card h-100">
      <img src="resources/images/img2.png" class="card-img-top" alt="...">
      <div class="card-body">
	<div style=" cursor: pointer;" onclick="window.open('http://localhost:8080/Detail.jsp');">
        <h5 class="card-title">테스트 2</h5>
      </div>
        <h4 id="price" class="card-title">0000원</h4>
        <p class="card-text">내용입니다</p>
        <p class="card-text"><small class="text-muted">3분 전</small>
        <button id="messageButton" type="button" class="btn btn-outline-primary position-relative"><img id="message" src="resources/images/message1.png">
        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
  		<button id="HartButton5" type="button" class="btn btn-outline-primary position-relative"><img id="Hart" src="resources/images/Hart.png">
        <span id="hartCount5" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
        </p>
    </div>
  </div>
  </div>
 <div class="col">
    <div class="card h-100">
      <img src="resources/images/img3.png" class="card-img-top" alt="...">
      <div class="card-body">
	<div style=" cursor: pointer;" onclick="window.open('http://localhost:8080/Detail.jsp;">
        <h5 class="card-title">테스트 3</h5>
      </div>
        <h4 id="price" class="card-title">0000원</h4>
        <p class="card-text">내용입니다</p>
        <p class="card-text"><small class="text-muted">3분 전</small>
        <button id="messageButton" type="button" class="btn btn-outline-primary position-relative"><img id="message" src="resources/images/message1.png">
        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
  		<button id="HartButton6" type="button" class="btn btn-outline-primary position-relative"><img id="Hart" src="resources/images/Hart.png">
        <span id="hartCount6" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
   		 99+
    	<span class="visually-hidden">unread messages</span>
 		 </span>
  	</button>
        </p>
    </div>
  </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>