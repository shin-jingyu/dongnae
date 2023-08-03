<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<h1>welcome 커뮤니티 사이트</h1>
	<div class="container">
	<table class="table table-boardered table table-hover">
		<thead>
			<tr>
				<th>지역</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>조회수</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			
				
			<c:forEach var="community" items="${list}"  >
				<tr>
					<c:forEach var="category" items="${category}"  >
						<td>${si_area.si_area}</td>
					</c:forEach>
					
					<td>${community.mu_name }</td>
					<td>${community.m_number}</td>
					<td>${community.mu_data}</td>
					<td>${community.mu_c}</td>
					<td>${con}</td>
				
				</tr>
			</c:forEach>
			
			
		</tbody>
	</table>
		<button onclick="location.href='write'">글쓰기</button>
	</div>
	
</body>
</html>