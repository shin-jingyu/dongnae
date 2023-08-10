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
				var options = "<option id='do_default' selected >도/광역시</option>";
				for(var i= 0 ; i< data.length; i++){
					options+= "<option value='" + data[i].do_id + "'>" + data[i].do_area + " </option>"
				}
				$("#do_id").html(options);
			},
			error: function(){
				alert("error load do area");
			}
		});
	});
		
	function do_select(){
		let doData = $("#do_id option:selected").val();
		$.ajax({
			url: '/member/regist/si_area',
			type:'POST',
			data: doData, 
			contentType: 'application/json',  /* 이거 넣으니까 오류 해결: 여기는 보내는 do_id */ 
			dataType: "json",	 	/* 여기는 받는 si_area List */ 
			success:function(data){		
				var options = "";
				for(var i= 0 ; i< data.length; i++){
					options+= "<option value='" + data[i].si_id + "'>" + data[i].si_area + "</option>"
				}
				$("#si_id").html(options);
				$("#do_default").remove();  // 여기서 도.광역시 애를 삭제하면 될 듯
			},
			error:function(){
				alert("error load si area");
			}
		})
	}
	
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
	    <select onchange="do_select()" id="do_id" name="do_id" ">
	    </select>
	   <select id="si_id"  name = "si_id">
	   		<option  selected >시/군/구</option>
		</select> 
	  </div>
	  <button class="btn btn-primary" id="login">Submit</button>
</form>

</body>
</html>

<div class="col-12 col-sm-2 align-self-center " >
  이메일            		
</div>
<div class="col-12 col-sm-3 align-self-center">
	<input readonly name="m_email"  type="text" value="${member.m_email}" class="form-control">
</div>	

<div class="col-12 col-sm-2 align-self-center " >
    핸드폰          		
</div>
<div class="col-12 col-sm-3 align-self-center">
	<input readonly name="m_phone"  type="text" value="${member.m_phone}" class="form-control">
</div>	
