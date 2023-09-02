<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<meta charset="UTF-8">
<title>changePassword</title>

<script type="text/javascript">
function check(){
	$('#changePassword').submit(false);
	var formdata =  $('#changePassword').serialize() ; 
	 if($("#changePassword")[0].checkValidity()) {
		$.ajax({
			url: '/member/checkpsw',
			type:'POST',
			data: formdata,
			success:function(response){
				if(response == 'wrongCurrent'){
					alert("현재 비밀번호가 일치하지 않습니다.");
				}
				else if(response == 'WrongConfirm'){
					alert("새 비밀번호 확인이 일치하지 않습니다.");
				}
				else{
					alert("비밀번호가 변경되었습니다. 다시 로그인해주세요.");
					$("#changePassword")[0].submit();
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

<jsp:include page="../common/Category.jsp"></jsp:include>

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
                <div class="col-lg-3 col-md-3">
                    <div class="sidebar">
                    	<jsp:include page="./sidebar.jsp"></jsp:include>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
	                <div class="container border my-3 rounded-5 text-center">
	                <div class="container mx-auto" style="width: 80%;">
	                            <div class="row my-5" >
	                           		<h2>비밀번호 변경</h2>
	                           	</div>
	                        	<div class="row  my-3">
	                        	<form name="changePassword" id="changePassword" action="changePassword" method="post" class="form-horizontal">
	                        			<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		현재 비밀번호
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input name="current_password" id="current_password" type="password" value="" class="form-control" required  maxlength="20">
											</div>	
										</div>
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		새 비밀번호
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input name="new_password" id="new_password" type="password" value="" class="form-control" required  maxlength="20">
											</div>		
										</div>
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											  새 비밀번호 확인           		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input  name="new_password_confirm" id="new_password_confirm" type="password" value="" class="form-control" required  maxlength="20">
											</div>		
										</div>
										
	                        			<div class="form-group  row">
											<div class="col-12  mt-3">
							                    <input type="submit" class="btn btn-primary" onclick="check()"  value="변경하기 " >
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