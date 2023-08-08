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
                        <div class="sidebar__item">
                            <h4>My Page</h4>
                            <ul>
                                <li><a href="#">내 프로필</a></li>
                                <li><a href="#">비밀번호 변경</a></li>
                                <li><a href="#">판매 중 상품</a></li>
                                <li><a href="#">판매내역</a></li>
                                <li><a href="#">구매내역</a></li>
                                <li><a href="#">찜 목록</a></li>
                                <li><a href="#">내 거래 후기</a></li>
                                <li><a href="#">내 페이포인트</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="product__discount">
                        <div class="section-title product__discount__title">
                            <h2>Profil</h2>
                        	<div class="row">
                            	<form name="updateForm" action=update method="post">
									<div class="row">
										<label class="col-sm-2">아이디</label>
										<input readonly name="m_id"  type="text" value="${member.m_id}">
									</div>
									<div class="form-group row">
										<label class="col-sm-2">이름</label>
										<input name="m_name"   type="text" value="${member.m_name}">
									</div>
									<div class="form-group row">
										<label class="col-sm-2">이메일</label>
										<input readonly name="m_email"   type="text" value="${member.m_email}">
									</div>
									<div class="form-group row">
										<label class="col-sm-2">핸드폰</label>
										<input name="m_phone" type="text" value="${member.m_phone}">
									</div>
									<div class="form-group row">
										<label class="col-sm-2">내 동네</label>
										<select name="si_id"  >
										  <option value="1" ${ (member.si_id == "1")? "selected" : "" }>수원</option>
										  <option value="2" ${ (member.si_id == "2")? "selected" : "" }>화성</option>
										  <option value="3" ${ (member.si_id == "3")? "selected" : "" }>오산</option>
										  <option value="4" ${ (member.si_id == "4")? "selected" : "" }>평택</option>
										</select>
									</div>
									<button>수정</button>
								</form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->
	
	<jsp:include page="../footer.jsp"></jsp:include>



<%-- <div class="container">
<h1>내 프로필 </h1>
<form name="updateForm" action=update method="post">
	<div class="form-group row">
		<label class="col-sm-2">아이디</label>
		<input readonly name="m_id"  type="text" value="${member.m_id}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">이름</label>
		<input name="m_name"   type="text" value="${member.m_name}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">이메일</label>
		<input readonly name="m_email"   type="text" value="${member.m_email}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">핸드폰</label>
		<input name="m_phone" type="text" value="${member.m_phone}">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">내 동네</label>
		<select name="si_id"  >
		  <option value="1" ${ (member.si_id == "1")? "selected" : "" }>수원</option>
		  <option value="2" ${ (member.si_id == "2")? "selected" : "" }>화성</option>
		  <option value="3" ${ (member.si_id == "3")? "selected" : "" }>오산</option>
		  <option value="4" ${ (member.si_id == "4")? "selected" : "" }>평택</option>
		</select>
	</div>
	<button>수정</button>
</form>
</div> --%>

</body>
</html>