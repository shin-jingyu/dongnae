<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 프로필</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<div class="container">
<h1>내 프로필 </h1>
<form name="updateForm" action=update method="post">
	<div class="form-group row">
		<label class="col-sm-2">아이디</label>
		<input readonly name="m_id" id="m_id" type="text" value="${member.m_id}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">비밀번호</label>
		<input name="m_pwd" id="m_pwd" type="m_pwd" value="${member.m_pwd}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">이름</label>
		<input name="m_name" id="m_name" type="m_name" value="${member.m_name}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">이메일</label>
		<input readonly name="m_email" id="m_email" type="text" value="${member.m_email}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">핸드폰</label>
		<input name="m_phone" id="m_phone" type="text" value="${member.m_phone}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">내 동네</label>
		<select name="si_id" id="si_id">
		  <option value="1" ${ (member.si_id == "1")? "selected" : "" }>수원</option>
		  <option value="2" ${ (member.si_id == "2")? "selected" : "" }>화성</option>
		  <option value="3" ${ (member.si_id == "3")? "selected" : "" }>오산</option>
		  <option value="4" ${ (member.si_id == "4")? "selected" : "" }>평택</option>
		</select>
	</div>
	<button>수정</button>
</form>
</div>
</body>
</html>