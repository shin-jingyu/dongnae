<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ogani | Template</title>

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="/resources/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="/resources/css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">

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
	fetchCategories();

})
		 
function fetchCategories() {
        $.ajax({
            url: '/api/getCategories',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                var category1Container = $('.category1');
                var listCategortContainer1 = $('.list_category');
                var category1List = data.category_1;
                
                category1Container.empty();

                // 카테고리1 li 생성
                category1List.forEach(function (category1) {
                    var category1Item = $('<li><a href="#">' + category1.c1_category + '</a></li>');
                	var category2Container = $('<ul class="category2 category2Container"></ul>');
                    
                    var listCategory1Item = $('<li><a href="#">' + category1.c1_category + '</a></li>');
					
                    category1Item.on('click', function(){
                    	var categoryId = category1.c1_id; // 카테고리 ID 가져오기
                    	var baseNewUrl = "${pageContext.request.contextPath }/goods/search/";
                   	 	var query = "";
                   	 	query = "?category=" + categoryId;
	                   	 var newUrl = baseNewUrl + query;
	                     
	                     // 페이지 이동
	                     window.location.href = newUrl;
                    })
                    
                    listCategory1Item.on('click', function() {
                        var categoryId = category1.c1_id; // 카테고리 ID 가져오기
                        var searchValue = document.querySelector(".searchName").textContent.trim(); // .search 클래스를 가진 요소의 텍스트 콘텐츠 가져오기
                        var encodedSearchValue = encodeURIComponent(searchValue);
                        console.log(searchValue)
                        var baseNewUrl = "${pageContext.request.contextPath }/goods/search/";
                        var query = "";
                        
                        if (searchValue != null) {
                            query = encodedSearchValue +"?category=" + categoryId;
                        } else {
                            query = "?category=" + categoryId;
                        }
                        
                        var newUrl = baseNewUrl + query;
                        
                        // 페이지 이동
                        window.location.href = newUrl;
                    });
                    // filter 를 통해 category2 list 정리
                    var category2List = data.category_2.filter(function(category2) {
                        return category2.c1_id === category1.c1_id;
                    });
                    
                    

                    category1Item.on('mouseover', function () {
                    	// 기존의 category2Container 비우기
//                         category2Item.empty(); 
                        
                        if (category2List.length > 0) {
                            category2List.forEach(function (category2) {
                                var category2Item = $('<li><a href="#">' + category2.c2_category + '</a></li>');
                                category2Container.append(category2Item);
                                category2Item.on('click', function() {
                                    var categoryId = category2.c2_id; // 카테고리 ID 가져오기
                                    var baseNewUrl = "/goods/search/"; // 상대 경로로 URL 설정
                                    var query = "?category=" + categoryId;
                                    var newUrl = baseNewUrl + query;

                                    // 페이지 이동
                                    window.location.href = newUrl;
                                });

                            });
                        }
                    });
                    category1Item.append(category2Container);
                    
                   
//                     category1Item.on('mouseout', function () {
//                         category2Container.empty();
//                     });

                    //goods_list 테스트
                    listCategortContainer1.append(listCategory1Item);
                    category1Container.append(category1Item);
                    
                });
                
            },
            error: function (xhr, status, error) {
                alert("데이터 안불러와지는중");
            }
        });
    }
    
    
</script>

<body>
	<header>
        <a href="/" class="logo"><img src="/resources/img/logo.png" alt=""></a>
        <nav class="navbar">
        <section class="hero">
	        <div class="container">
	            <div class="row">
	                <!-- 검색 -->
	                <div class="col-lg-9">
	                    <div class="hero__search">
	                        <div class="hero__search__form">
	                           <form id="searchForm" action="#" method="get">
								    <input type="text" placeholder="What do you need?" name="search">
								    <button type="submit" class="site-btn">SEARCH</button>
								</form>
								<script>
								document.getElementById("searchForm").addEventListener("submit", function(event) {
								    event.preventDefault();
								    
								    var searchInput = document.querySelector("input[name='search']").value;
								    var encodedSearchInput = encodeURIComponent(searchInput);
								    
								    var newUrl = "/goods/search/" + encodedSearchInput;
								    window.location.href = newUrl;
								});
								</script>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>
    	<div style="z-index: 2;">
            <ul>
                <li><a href="">카테고리</a>
                    <ul class="category1"></ul>
                </li>
                <li><a href="#">커뮤니티</a>
                	<ul class="communityCategory"></ul></li>
            </ul>
    	</div>
        </nav>
        <sec:authorize access="isAnonymous()">
	        <div class="login_set"><a href="/login"><i class="fa fa-user"></i></a></div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <div class="login_set">
	         <a href="/member/detail"><i class="fa fa-user"></i></a>
        </div>
         </sec:authorize>
	
	    <div class="header__cart">
	        <ul>
	            <li><a class="heart" href="#"><i class="fa fa-heart"></i></a></li>
	        </ul>
	        <div class="header__cart__price">내 페이포인트: <span>000.0P</span></div>
	    </div>
    </header>
    
</body>
</html>