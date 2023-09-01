<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	/*  function updatePage() 로 대체할 수 있는 방법은?*/
	$.ajax({
	    url: "/keywordapi/keywordList",
	    type: "get",
	    dataType: "json",
	    success: function (data) {
	        var keywordListDiv = "";
	        for (var i = 0; i < data.length; i++) {
	        	keywordListDiv +=
	                '<tr class="table">' +
	                '<td>' + data[i].keyword + '</td>' +
	                '<td><a class="badge text-bg-danger" onclick="deleteKeyword(' + data[i].key_id + ')" >삭제</a></td>' +
	                '</tr>';
	        }
	        $("#keywordListDiv").html(keywordListDiv);
	    }
	});
	
	$.ajax({
	    url: "/keywordapi/keywordGoodsList",
	    type: "get",
	    dataType: "json",
	    success: function (data) {
	        var goodsListsDiv = "";
	        for (var i = 0; i < data.length; i++) {
	            goodsListsDiv +=
	            	'<div class="col-lg-4 col-md-6 col-sm-6"><div class="featured__item">' +
	                '<div class="featured__item__pic set-bg" data-setbg="/resources/upload/goods/' + data[i].g_picpath + '/' + data[i].g_pic01 + '">' +
	                '</div>' +
	                '<div class="featured__item__text">' +
	                '<a class="move" href="/goods/goods_detail/' + data[i].g_id + '"/>' +
	                '<h6>' + data[i].g_name + '</h6>' +
	                '</a>' +
	                '<h5>' + data[i].g_price + '원</h5>' +
	                '</div></div></div>' ;
	        }
	        $("#goodsListDiv").html(goodsListsDiv);
	    }
	});

});

function updatePage(){
	$.ajax({
	    url: "/keywordapi/keywordList",
	    type: "get",
	    dataType: "json",
	    success: function (data) {
	        var keywordListDiv = "";
	        for (var i = 0; i < data.length; i++) {
	        	keywordListDiv +=
	                '<tr class="table">' +
	                '<td>' + data[i].keyword + '</td>' +
	                '<td><a class="badge text-bg-danger" onclick="deleteKeyword(' + data[i].key_id + ')" >삭제</a></td>' +
	                '</tr>';
	        }
	        $("#keywordListDiv").html(keywordListDiv);
	    }
	});
	$.ajax({
	    url: "/keywordapi/keywordGoodsList",
	    type: "get",
	    dataType: "json",
	    success: function (data) {
	        var goodsListsDiv = "";
	        for (var i = 0; i < data.length; i++) {
	            goodsListsDiv +=
	            	'<div class="col-lg-4 col-md-6 col-sm-6"><div class="featured__item">' +
	                '<div class="featured__item__pic set-bg" data-setbg="/resources/upload/goods/' + data[i].g_picpath + '/' + data[i].g_pic01 + '">' +
	                '</div>' +
	                '<div class="featured__item__text">' +
	                '<a class="move" href="/goods/goods_detail/' + data[i].g_id + '"/>' +
	                '<h6>' + data[i].g_name + '</h6>' +
	                '</a>' +
	                '<h5>' + data[i].g_price + '원</h5>' +
	                '</div></div></div>' ;
	        }
	        $("#goodsListDiv").html(goodsListsDiv);
	    }
	});
}


function insertKeyword(){
	$('#insertKeyword').submit(false);
	let keyword = $("#inputKeyword").val();
	$.ajax({
	    url: "/keywordapi/insertKeyword",
	    type: "post",
	    data : keyword ,
	    success: function () {
	    	$("#inputKeyword").val('');
	    	updatePage();
	    },error: function(){
	    	$("#inputKeyword").val('');
			alert("이미 존재하는 키워드입니다.");
		}
	});
}

function deleteKeyword(key_id_input){
	let key_id = key_id_input;
	$.ajax({
	    url: "/keywordapi/delete/" + key_id ,
	    type: "delete",
	    success: function () {
	    	updatePage();
	    },error: function(){
			alert("error delete");
		}
	});
}

</script>
<body>
	<jsp:include page="../header_member.jsp"></jsp:include>

 <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>키워드 알람</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
<!-- Breadcrumb Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container mx-5">
            <div class="row">
            
             	<div class="col-lg-3 col-md-3">
             	<div class="container border my-3 rounded-3">
             		<div class="sidebar__item ">
			           <table class="table table-hover" id="keywordListDiv">
						</table>
					      <form id="insertKeyword" class="d-flex" action="insertKeyword" method="post">
					        <input id="inputKeyword" class="form-control me-2" placeholder="Search" aria-label="Search" required>
					        <input class="btn btn-outline-success btn-sm" type="submit" onclick="insertKeyword()" value="add">
					      </form>

			       </div>
                </div>
                </div>
                
                <div class="col-lg-9 col-md-9">
                    <!-- 키워드 상품 리스트 -->
                     <div class="row goodsList"  id="goodsListDiv" >
					</div>
                </div>
                
                
            </div>
        </div>
    </section>
    <!-- Product Section End -->

	
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>