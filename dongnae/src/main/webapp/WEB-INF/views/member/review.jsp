<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 거래 후기</title>
</head>
<body>
<div class="container">
	<h1>내 거래 점수 : ${avgScore} 점</h1>
	<h1>내 거래 후기</h1>
		<div>구매자번호 : ${sold.b_m_number}</div>
		<div>거래후기 : ${sold.s_review}</div>
		<div>거래일 : ${sold.s_regdate}</div>
		<div>받은 거래점수 : ${sold.s_score}점</div>
</div>
</body>
</html>