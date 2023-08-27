<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript"> 
	$(document).ready(function(){
		if($("#message").val()!=""){
		var message = $("#message").val();
		alert(message);
		}
	});
</script>
<body>

<sec:authentication property="principal" var="member"/>
<jsp:include page='../common/header.jsp'></jsp:include>

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
                <div class="col-lg-12 col-md-12">
	                <div class="container border my-3 rounded-5">
	                <div class="container mx-auto" style="width: 80%;">
	                			<div class="row my-5  text-center" >
	                           		<h2>로그인</h2>
	                           	</div>
	                        	<div class="row  my-3">
	                        	<form action="/login.do" method="post" method="post" class="form-horizontal">
	                        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	                        			<div class="form-group row">
	                        				<input hidden id="message" type="text" value="${message}"></input>
											<label class="form-label col-12 col-sm-4  " >
						                   		아이디
											</label>
											<div class="col-12 col-sm-5 align-self-center">
												<input type="text" class="form-control" name = "username" required autofocus>
											</div>	
										</div>
										<div class="form-group row">
											<label class="form-label col-12 col-sm-4  " >
						                   		비밀번호
											</label>
											<div class="col-12 col-sm-5 align-self-center">
												<input  type="password" class="form-control" name="password" required>
											</div>	
										</div>
										<%-- 
										<div class="form-group row">
											<div ${ (login == "fail")? '' : 'style="display: none;"' }  class="alert alert-danger" role="alert"  class="mb-3">
											  아이디와 비밀번호를 확인해주세요.
											</div>
										</div>
										 --%>
	                        			<div class="form-group  row">
						                	<div class="col-12 mt-3 mb-5  text-center">
							                    <button type="submit" class="btn btn-success ">로그인</button>
							                    <a class="btn btn-success" href="/member/regist">회원가입</a>
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