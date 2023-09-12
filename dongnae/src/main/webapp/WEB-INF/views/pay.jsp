<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="/resources/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="/resources/css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>

<script>
	function dopay(){
		
		alert("송금이 완료되었습니다");
        window.close();
        window.opener.parent.location.href = '/'; 
       	return true;
		
	}
</script>

<body>

	<div class="container border my-3 rounded-5 text-center">
		<div class="container mx-auto" style="width: 80%;">
			<form action="doPay" method="POST">
				<input type="hidden" value="${member.m_number }" name="m_number">
				<div class="row my-3">
					<div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;">
                   		상품명
					</div>
					<div class="col-12 col-md-6 form-floating my-3 col-sm align-self-center">
                        <input type="text" class="form-control" id="송금할 금액" name = "g_name" value="${goods.g_name }" readonly="readonly">
                        <label for="floatingInput2"></label>
                    </div>
<!--                      <div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;"> -->
<!--                      	상품 소개 -->
<!--                     </div> -->
<!--                     <div class="col-12 col-md-6"> -->
<!--                         <div class="form-floating"> -->
<!--                             <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" name ="g_text" -->
<!--                                 style="height: 100px"></textarea> -->
<!--                             <label for="floatingTextarea2"></label> -->
<!--                         </div> -->
<!--                     </div> -->
                    <div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;">
                   		상품 가격
					</div>
					<div class="col-12 col-md-6 form-floating my-3 col-sm align-self-center">
                        <input type="text" class="form-control" id="floatingInput" placeholder="floatingName" name = "g_price" value="<fmt:formatNumber value="${goods.g_price}"  pattern="#,###"/>원" readonly="readonly">
                        <label for="floatingInput"></label>
                    </div>
                    <div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;">
                   		송금 가격
					</div>
					<div class="col-12 col-md-6 form-floating my-3 col-sm align-self-center">
                        <input type="text" class="form-control" id="floatingInput" placeholder="송금할 금액" name = "g_price" value="<fmt:formatNumber value=""  pattern="#,###"/>">
                        <label for="floatingInput"></label>
                    </div>
                     <div class="col-12 mt-3 mb-5">
	                    <button type="submit" class="btn btn-primary" onclick="dopay(); return false;">송금하기</button>
	                    <button type="reset" class="btn btn-danger ">취소하기</button>
                	</div> 
				</div>
			</form>
		</div>
	</div>

</body>
</html>