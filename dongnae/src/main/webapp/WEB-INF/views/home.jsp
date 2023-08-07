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
	<a class="btn btn-secondary" href="/member/changePassword">비밀번호 변경</a>
	<a class="btn btn-secondary" href="/member/soldList">판매내역</a>
	<a class="btn btn-secondary" href="/member/buyList">구매내역</a>
	<a class="btn btn-secondary" href="/member/review">내 거래 후기</a>
	<a class="btn btn-secondary" href="/member/point">내 페이포인트</a>
	<a class="btn btn-secondary" href="/member/wishlist">찜목록</a>
	<a class="btn btn-secondary" href="community">커뮤니티</a>
	<c:choose>
		<c:when test="${empty m_id}">  
			<a class="btn btn-info" href="/member/login">로그인</a>
			<a class="btn btn-info" href="/member/regist">회원가입</a>
		</c:when>
		<c:otherwise>
			<a class="btn btn-info" href="/member/logout">로그아웃</a>
			<P> 반갑습니다. ${m_id} 님! </P>
			
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
