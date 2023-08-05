<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<body>
	
	<div class="container">
	<h2>수정하기</h2>
		<div>
			<form action="/updateCommunity" method="post">
				<table class="table table-borderd table table-hover">
				<tr>
					<td>글이름</td>
					<td>${community.mu_name }</td>
				</tr>
				
				<tr>
					<td>지역</td>
					<td>${community.si_area }</td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td>${community.ca_l }</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${community.mu_name }</td>
				</tr>
				<tr>
					<td>작성시간</td>
					<td>${community.mu_data }</td>
				</tr>
				<tr>
					<td colspan="2">글 내용</td>
				</tr>	
				<tr>	
					<td colspan="2">${community.mu_detail }</td>
				</tr>
				</table>	
			</form>
		</div>
	</div>
</body>
</html>