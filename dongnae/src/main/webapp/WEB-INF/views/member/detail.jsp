<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 프로필</title>
</head>


<body>

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
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                    	<jsp:include page="./sidebar.jsp"></jsp:include>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                <div class="container">
                            <div class="row" style="margin-bottom: 50px">
                           		<h2>내 프로필</h2>
                           	</div>
                        	<div class="row">
                            	<form name="updateForm" action=update method="post" class="form-horizontal">
									<div class="form-group row">
										<label class="col-sm-2">아이디</label>
										<div class="col-sm-3">
											<input readonly name="m_id"  type="text" value="${member.m_id}" class="form-control">
										</div>	
									</div>
									<div class="form-group row">
										<label class="col-sm-2">이름</label>
										<div class="col-sm-3">
											<input name="m_name"   type="text" value="${member.m_name}" class="form-control">
										</div>	
									</div>
									<div class="form-group row">
										<label class="col-sm-2">이메일</label>
										<div class="col-sm-3">
											<input readonly name="m_email"   type="text" value="${member.m_email}" class="form-control">
										</div>	
									</div>
									<div class="form-group row">
										<label class="col-sm-2">핸드폰</label>
										<div class="col-sm-3">
											<input name="m_phone" type="text" value="${member.m_phone}" class="form-control">
										</div>	
									</div>
									<div class="form-group row">
										<label class="col-sm-2">내 동네</label>
										<div class="col-sm-3">
											<select name="si_id"  class="form-select"  >
											  <option value="1" ${ (member.si_id == "1")? "selected" : "" }>수원</option>
											  <option value="2" ${ (member.si_id == "2")? "selected" : "" }>화성</option>
											  <option value="3" ${ (member.si_id == "3")? "selected" : "" }>오산</option>
											  <option value="4" ${ (member.si_id == "4")? "selected" : "" }>평택</option>
											</select>
										</div>	
									</div>
									
									<div class="form-group  row">
										<div class="col-sm-offset-2 col-sm-10 ">
											<input type="submit" class="btn btn-primary" value="수정 ">
										</div>
									</div>
								</form>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
    </section>
    <!-- Product Section End -->
	
	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>