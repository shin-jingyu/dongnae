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
		<h2>글쓰기</h2>
		<P> 반갑습니다. ${m_id} 님! </P>
		<div>
			<form method="post" action="/insertCommunity">
			<input type="hidden" name="m_number" value="${member.m_number }">
				<table class="table table-borderd table table-hover">
				
					<tr>
						<label class="form-label">카테고리</label>
						<select name="ca_id"  >
							<option value="1" ${ (ca_id == "1")? "selected" : "" }>사건사고</option>
							<option value="2" ${ (ca_id == "2")? "selected" : "" }>분실/실종</option>
							<option value="3" ${ (ca_id == "3")? "selected" : "" }>일상</option>
							<option value="4" ${ (ca_id == "4")? "selected" : "" }>맛집</option>
							<option value="5" ${ (ca_id == "4")? "selected" : "" }>취미</option>
							<option value="6" ${ (ca_id == "4")? "selected" : "" }>동네질문</option>
						</select>
					</tr>
					<tr>
						<td>글제목<input type="text" name="mu_name">
						</td>
					</tr>
					<tr>
						<td>글내용</td>
					</tr>
					<tr>
						<td colspan="2"><textarea rows="10" cols="150"
								name="mu_detail"></textarea></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="등록"></td>
					</tr>
					
				</table>
			</form>
			<button onclick="location.href='community'">목록으로</button>
		</div>
	</div>
</body>
</html>