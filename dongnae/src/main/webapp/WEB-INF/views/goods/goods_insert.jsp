<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
 <link href="https://webfontworld.github.io/TheJamsil/TheJamsil.css" rel="stylesheet">    
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script>
	var token = $("meta[name='_csrf']").attr('content');
	var header = $("meta[name='_csrf_header']").attr('content');
	$(function(){
	    if(token && header) {
	        $(document).ajaxSend(function(event, xhr, options) {
	            xhr.setRequestHeader(header, token);
	        });
	    }
	    insertCategory();
	
	})
			 
	function insertCategory() {
    $.ajax({
        url: '/api/getCategories',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var categorySelect_c1 = $('.c1');
            categorySelect_c1.empty();
            categorySelect_c1.append($('<option value="0" selected>대분류</option>'));
            var categoryList_c1 = data.category_1;

            var categorySelect_c2 = $('.c2');
            categorySelect_c2.empty();
            categorySelect_c2.append($('<option value="0" selected>중분류</option>'));
            var categoryList_c2 = data.category_2;

            categoryList_c1.forEach(function (category1) {
                categorySelect_c1.append($('<option value="' + category1.c1_id + '">' + category1.c1_category + '</option>'));
            });

            categorySelect_c1.on('change', function () {
                var selectedC1Id = parseInt($(this).val());
                categorySelect_c2.empty();
                categorySelect_c2.append($('<option value="0" selected>중분류</option>'));

                categoryList_c2.forEach(function (category2) {
                    if (category2.c1_id === selectedC1Id) {
                        categorySelect_c2.append($('<option value="' + category2.c2_id + '">' + category2.c2_category + '</option>'));
                    }
                });
            });
        },
        error: function (xhr, status, error) {
            // 에러 처리
            alert("데이터 안불러와지는중");
        }
    });
}
</script>
<body>
	 <sec:authentication property="principal" var="member"/>

	<jsp:include page="../common/Category.jsp"/>
	<div class="container border my-3 rounded-5 text-center">
		<div class="container mx-auto" style="width: 80%;">
			<form action="goods_insert" method="POST" enctype="multipart/form-data">
				<input type="hidden" value="${member.m_number }" name="m_number">
				<input type="file" name="uploadFile" multiple="multiple">
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
                        <select class="form-select c1" id="floatingSelect" name="" >
                            <!-- DB 에서 받아온 값 AJAX 처리 -->
                        </select>
                    </div>
                    <div class="form-floating col-12 col-md-3 my-3 align-self-center">
                        <select class="form-select c2" id="floatingSelect" name = "c2_id">
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
	                    <button type="submit" class="btn btn-primary ">등록하기</button>
	                    <button type="reset" class="btn btn-danger ">취소하기</button>
                	</div> 
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>