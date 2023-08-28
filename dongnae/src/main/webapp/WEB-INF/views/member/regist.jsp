<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:"/regist/do_area", 
			type: 'POST',
			dataType: "json",
			success: function(data){
				var options = "<option value='' id='do_default' >도/광역시</option>";
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
			url: '/regist/si_area',
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
	
	function checkId(){
		let checkId = $("#m_id").val();
		$.ajax({
			url: '/checkId',
			type:'POST',
			data: checkId,
			success:function(response){
				var options = "";
				if(response == 'duplicated'){
					alert("중복된 아이디입니다. 다른 아이디를 입력하세요");
				}
				else{
					alert("사용가능한 아이디입니다.");
				}
			},
			error:function(response){
			}			
		})
	};
	
	function checkId_post(){
		$('#regist').submit(false);
		let checkId = $("#m_id").val();
		 if($("#regist")[0].checkValidity()) {
			$.ajax({
				url: '/checkId_post',
				type:'POST',
				data: checkId,
				success:function(response){
					var options = "";
					if(response == 'duplicated'){
						alert("중복된 아이디입니다. 다른 아이디를 입력하세요");
					}
					else{
						$("#regist").submit();
					}
				},
				error:function(response){
				}			
			}) 
		 }
	};
	
</script>

</head>


<body>
<sec:authentication property="principal" var="member"/>

<jsp:include page="../header_member.jsp"></jsp:include>

 <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>My Page</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
<!-- Breadcrumb Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
             <div class="row">
                <%-- <div class="col-lg-3 col-md-3">
                    <div class="sidebar">
                    	<jsp:include page="./sidebar.jsp"></jsp:include>
                    </div>
                </div> --%>
                <div class="col-lg-12 col-md-12">
	                <div class="container border my-3 rounded-5 text-center">
	                <div class="container mx-auto" style="width: 80%;">
	                            <div class="row my-5" >
	                           		<h2>회원가입</h2>
	                           	</div>
	                        	<div class="row  my-3">
	                            	<form id="regist" name="regist" action="regist" method="post" class="form-horizontal">
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		아이디
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input id="m_id"  name="m_id"  type="text" class="form-control" required autofocus  maxlength="20" >
											</div>	
											<div class="col-12 col-sm-3 align-self-center">
						                   		<button type="button" class="btn btn-success" onclick="checkId()" >중복 확인</button>
					                		</div> 
										</div>
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		비밀번호
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input name="m_pwd"  type="password"  class="form-control" required minlength="4" maxlength="20" >
											</div>		
										</div>
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		이름
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input   name="m_name"  type="text"  class="form-control" required maxlength="20">
											</div>		
										</div>
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											  이메일            		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input name="m_email"  type="email"  class="form-control" required  maxlength="30">
											</div>		
										</div>
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											    핸드폰          		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input   name="m_phone"  type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"  class="form-control" required  maxlength="20" >
											</div>	
										</div>
										<div class="form-group row">
											<label class="col-sm-4">내 동네</label>
											<div class="col-12 col-sm-3 align-self-center">
												 <select onchange="do_select()"  id="do_id" name="do_id" class="form-select" required>
										    	</select>
											</div>	
											<div class="col-12 col-sm-5 align-self-center">
										  		 <select  id="si_id"  name = "si_id" class="form-select" required>
											   		<option  value="" >시/군/구</option>
												</select> 
											</div>
										</div>	
									
										 
										
										<div class="form-group  row">
										<div class="col-12  mt-3">
						                    <input type="submit" class="btn btn-primary" value="회원가입 ">
					                	</div> 
					                	</div>
									</form>
	                            </div>
	                        </div>
	                    </div>
	                    </div>
                </div>
                </div>
    </section>
    <!-- Product Section End -->
	
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>