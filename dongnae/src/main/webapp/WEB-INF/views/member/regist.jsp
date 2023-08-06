<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:"/member/regist/do_area", 
			type: 'POST',
			dataType: "json",
			success: function(data){
				var options = "";
				for(var i= 0 ; i< data.length; i++){
					options+= "<option value='" + data[i].do_id + "'>" + data[i].do_area + "</option>"
				}
				$("#do_id").html(options);
			},
			error: function(){
				alert("error load area");
			}
		});
	})
	/*  <option selected value="1" ${ (member.si_id == "1")? "selected" : "" }>경기</option> */
</script>

<body>

<form class="container" action="/member/regist" method="post">
	  <div class="mb-3">
	    <label class="form-label">아이디</label>
	    <input type="text" class="form-control" name = "m_id"> 
	  </div>
	  <div class="mb-3">
	    <label  class="form-label">비밀번호</label>
	    <input type="password" class="form-control" name="m_pwd">
	  </div>  
	  <div class="mb-3">
	    <label class="form-label">이름</label>
	    <input type="text" class="form-control" name = "m_name">  
	  </div>
	  <div class="mb-3">
	    <label class="form-label">이메일</label>
	    <input type="text" class="form-control" name = "m_email">  
	  </div>
	  <div class="mb-3">
	    <label class="form-label">핸드폰 번호</label>
	    <input type="text" class="form-control" name = "m_phone">  
	  </div>
	  <div class="mb-3">
	    <label class="form-label">지역</label>
	    <select id="do_id" name="do_id"></select>
		<%-- 
		<select style="display: none;" name="si_default" id="si_default"  name = "si_default">
		  <option selected value="1" ${ (member.si_id == "1")? "selected" : "" }>시/구</option>
		</select>
		 --%>
	   <select  name="si_id" id="si_id"  name = "si_id">
	   		<option selected value="1" ${ (member.si_id == "1")? "selected" : "" }>시/구</option>
		  <%-- <option selected value="1" ${ (member.si_id == "1")? "selected" : "" }>수원</option>
		  <option value="2" ${ (member.si_id == "2")? "selected" : "" }>화성</option>
		  <option value="3" ${ (member.si_id == "3")? "selected" : "" }>오산</option>
		  <option value="4" ${ (member.si_id == "4")? "selected" : "" }>평택</option> --%>
		</select> 
	  </div>
	  <button class="btn btn-primary" id="login">Submit</button>
</form>

</body>
</html>