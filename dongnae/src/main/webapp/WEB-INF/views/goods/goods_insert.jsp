<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
 <link href="https://webfontworld.github.io/TheJamsil/TheJamsil.css" rel="stylesheet">    
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../Header.jsp"/>
	
	<div class="container border my-3 rounded-5 text-center">
		<div class="container mx-auto" style="width: 80%;">
			<form action="goods_insert" method="post" enctype="multipart/form-data">
				<input type="file" value="" name="uploadFile">
				<div class="row my-3">
					<div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;">
                   		상품명
					</div>
					<div class="col-12 col-md-6 form-floating my-3 col-sm align-self-center">
                        <input type="text" class="form-control" id="floatingInput" placeholder="floatingName" name = "g_name">
                        <label for="floatingInput2">&nbsp;&nbsp; 상품 이름</label>
                    </div>
                     <div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;">
                     	상품 소개
                    </div>
                    <div class="col-12 col-md-6">
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" name ="g_text"
                                style="height: 100px"></textarea>
                            <label for="floatingTextarea2">상품소개 예시</label>
                        </div>
                    </div>
                    <div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;">
                   		카테고리
                    </div>
                    <div class="form-floating col-12 col-md-3 my-3 align-self-center">
                        <select class="form-select recipeKind" id="floatingSelect c1" name="" >
                            <!-- DB 에서 받아온 값 AJAX 처리 -->
                        </select>
                    </div>
                    <div class="form-floating col-12 col-md-3 my-3 align-self-center">
                        <select class="form-select recipeHow" id="floatingSelect c2" name = "c2_id">
                             <!-- DB 에서 받아온 값 AJAX 처리 -->
                        </select>
                    </div>
                    <div class="col-12 col-md-4 align-self-center my-3" style="font-size: 1.5rem;">
                   		상품 가격
					</div>
					<div class="col-12 col-md-6 form-floating my-3 col-sm align-self-center">
                        <input type="text" class="form-control" id="floatingInput" placeholder="floatingName" name = "g_price">
                        <label for="floatingInput">&nbsp;&nbsp; 상품 가격</label>
                    </div>
                    
                     <div class="col-12 mt-3 mb-5">
	                    <button type="submit" class="btn btn-warning btn_add_ingredient">등록하기</button>
	                    <button type="reset" class="btn btn-danger btn_add_ingredient">취소하기</button>
                	</div> 
				</div>
			</form>
		</div>
	</div>
</body>
</html>