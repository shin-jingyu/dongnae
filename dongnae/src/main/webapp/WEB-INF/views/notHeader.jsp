<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<link href="https://webfontworld.github.io/TheJamsil/TheJamsil.css" rel="stylesheet">
</head>
<style>
#header {
	position :  relative;
	left : 550px;
	font-family: 'TheJamsil';
	font-size: 30px;
	color : #6098F2;
}

#search {
	position :  relative;
	left : -700px;
}

#search-input {
	width : 400px;
	height : 50px;
}

#headerbox {
	background-color: #ffffff;
	}
	
#header2 {
	font-family: 'TheJamsil';
	background-color : #6098F2;

}	

#category {
	position :  relative;
	left : -180px;
	font-size: 20px;	
}

#comunity {
	position :  relative;
	left : -180px;
	font-size: 20px;	
}

#fakeChack {
	position :  relative;
	left : -180px;
	font-size: 20px;
}

#chack {
	position :  relative;
	left : -180px;
	font-size: 20px;
}
.v-line1, .v-line2, .v-line3{
  border-left : thin solid #ffffff;
  height : 40px;
  position :  relative;
  top : 5px;
  left : -180px;
}

.v-line4 {
	border-left : thin solid #ffffff;
  height : 30px;
  position :  relative;
  top : 5px;
}

.jb-division-line {
  border-top: 2px solid #6098F2;
  margin: 400px 0px;
  position :  relative;
  top : -300px
}
#categoryColor {
	color : #ffffff;
}

#comunityColor {
	color : #ffffff; 	
}

#fakeChackColor {
	color : #ffffff;
}

#chackColor {
	color : #ffffff;
}

#loginColor {
	color : #ffffff;
}

#joinColor {
	color : #ffffff;
}
</style>
<body>
	<nav class="navbar" class="navbar bg-body-tertiary" style="background-color: #ffffff;">
  <div class="container-fluid">
   <a id="header" class="navbar-brand" href="http://localhost:8080/Main.jsp">동네 마켓</a>
    <form id="search" class="d-flex" role="search">
      <input id="search-input" class="form-control me-2" type="search" placeholder="검색어를 입력해 주세요" aria-label="Search">
      <button id="search-button" class="btn btn-outline-primary" type="submit">검색</button>
    </form>
  </div>
</nav>

<ul id="header2" class="nav nav-tabs justify-content-center" >
  <li id="category" class="nav-item dropdown">
    <a id="categoryColor" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">☰ 카테고리</a>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">카테고리1</a></li>
      <li><a class="dropdown-item" href="#">카테고리2</a></li>
      <li><a class="dropdown-item" href="#">카테고리3</a></li>
    </ul>
  </li>
  <div class='v-line1'></div>
  <li id="comunity" class="nav-item dropdown">
    <a id="comunityColor" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">커뮤니티</a>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">- 사건사고</a></li>
      <li><a class="dropdown-item" href="#">- 분실/실종</a></li>
      <li><a class="dropdown-item" href="#">- 일상</a></li>
      <li><a class="dropdown-item" href="#">- 맛집</a></li>
      <li><a class="dropdown-item" href="#">- 취미</a></li>
      <li><a class="dropdown-item" href="#">- 동네질문</a></li>
    </ul>
  </li>
  <div class='v-line2'></div>
  <li id="fakeChack" class="nav-item">
    <a id="fakeChackColor" class="nav-link" href="#">사기 조회</a>
  </li>
  <div class='v-line3'></div>
  <li id="chack" class="nav-item">
    <a id="chackColor" class="nav-link" href="#">시세 조회</a>
  </li>
  <li id="login" class="nav-item">
    <a id="loginColor" class="nav-link" href="#">로그인</a>
  </li>
  <div class='v-line4'></div>
  <li id="join" class="nav-item">
    <a id="joinColor" class="nav-link" href="#">회원가입</a>
  </li>
</ul>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>