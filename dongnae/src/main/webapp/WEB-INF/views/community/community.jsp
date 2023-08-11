<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>	
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
<P> 반갑습니다. ${m_id} 님! </P>
<button onclick="location.href='/member/login'" >로그인</button>
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
				<th>댓글수</th>
				
			</tr>
		</thead>
		<tbody>
			
				
			<c:forEach var="communityAll" items="${list}"  >
				<tr>				
					<td>${communityAll.si_area}</td>
					<td><a href="/communityDetail?mu_id=${communityAll.mu_id}&&m_number=<sec:authentication property="principal.m_number"/>" >${communityAll.mu_name}</a></td>
					<td>${communityAll.m_id}</td>
					<td>${communityAll.mu_data}</td>
					<td>${communityAll.mu_c}</td>
					<td>${communityAll.heart}</td>
					<td>${communityAll.comment}</td>
				</tr>
			</c:forEach>
			
			
		</tbody>
	</table>
		<button  onclick="location.href='insertCommunity?m_id=${m_id}'">글쓰기</button>
	</div>
	
</body>
</html>