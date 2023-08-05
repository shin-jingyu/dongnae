<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<div class="container">
	<h1>찜 목록</h1>
	<c:forEach var="w" items="${wish_viewDTO.wish_viewDTOList}">
		<div class="card">
			<div>상품이름 : ${w.g_name}</div>
			<div>가격 : <fmt:formatNumber value="${w.g_price}"/> </div>
			<a class="btn btn-secondary" href="/member/cancelWish">찜 취소</a>
		</div>
	</c:forEach>
</div>
</body>
</html>