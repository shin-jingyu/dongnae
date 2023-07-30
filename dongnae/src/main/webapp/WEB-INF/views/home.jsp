<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<!-- 임시 회원 메뉴 -->
<div>
	<a class="btn btn-secondary" href="/member/detail">내 프로필</a>
	<a class="btn btn-secondary" href="/member/soldList">판매내역</a>
	<a class="btn btn-secondary" href="/member/buyList">구매내역</a>
	<a class="btn btn-secondary" href="/member/review">내 거래 후기</a>
	<a class="btn btn-secondary" href="/member/point">내 페이포인트</a>
</div>
</body>
</html>
