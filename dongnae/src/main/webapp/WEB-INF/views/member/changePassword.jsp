<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changePassword</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

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
	                        	<form name="changePassword" action=changePassword method="post" class="form-horizontal">
	                        		<input hidden name="m_id"  type="text" value="${m_id}">  
	                        			<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		현재 비밀번호
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input name="current_password" id="current_password" type="password" value="" class="form-control" required  maxlength="20">
											</div>	
										</div>
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " ></div>
											<div ${ (password.message == "wrongCurrent")? '' : 'style="display: none;"' }   
											class="alert alert-danger align-self-center mb-3" role="alert" >
											  현재 비밀번호를 잘못 입력하셨습니다.
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
										<div class="form-group row">
											<div ${ (password.message == "WrongConfirm")? '' : 'style="display: none;"' }   class="alert alert-danger" role="alert"  class="mb-3">
											  비밀번호가 서로 일치하지 않습니다.
											</div>
										</div>
										
	                        			<div class="form-group  row">
											<div class="col-12  mt-3">
							                    <input type="submit" class="btn btn-primary" value="변경하기 ">
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