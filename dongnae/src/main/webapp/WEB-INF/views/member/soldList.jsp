<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매내역</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<div class="container">
	<h1>판매내역</h1>
	<!-- list를 전달해야하는데 @ModelAttribute로는 dto로만 전달돼서, dto내에 list 변수를 만들어서 set해서 전달함 -->
	<c:forEach var="d" items="${dealDTO.dealDTOList}">
		<div class="card">
			<div>상품이름 : ${d.g_name}</div>
			<div>가격 : <fmt:formatNumber value="${d.g_price}"/> </div>
			<div>판매일 : ${d.d_regdate}</div>
		</div>
	</c:forEach>
</div>
</body>
</html>