<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이포인트</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<div class="container">
	<h1>내 페이포인트 : <fmt:formatNumber value="${m_point}"/> p</h1>
	<button>충전하기</button>
	<h1>페이포인트 사용내역 </h1>
	<table class="table table-hover">
		<tr>
			<th>일자</th>
			<th>구분</th>
			<th>금액</th>
		</tr>
			<c:forEach var="d" items="${dealDTO.dealDTOList}">
			<c:choose>
				<c:when test="${d.d_type == 'buy'}">  
				<tr>
					<td>${d.d_regdate}</td>
					<td>출금</td>
					<td>-<fmt:formatNumber value="${d.g_price}"/> p</td>
				</tr>
				</c:when>
				<c:otherwise> 
				<tr>
					<td>${d.d_regdate}</td>
					<td>입금</td>
					<td>+<fmt:formatNumber value="${d.g_price}"/> p</td>
				</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
</div>
</body>
</html>

