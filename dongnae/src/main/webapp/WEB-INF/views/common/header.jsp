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
	            var categorySelectMain = $('.category1Container');
	            var category2Container = $('.category2Container');
	
	            categorySelectMain.empty();
	            category2Container.empty();
	
	            var categoryMainList = data.category_1;
	            categoryMainList.forEach(function (categoryMain) {
	                var categoryMainItem = $('<li value="' + categoryMain.c1_id + '"> ' + categoryMain.c1_category + '</li>');
	                categoryMainItem.on('mouseover', function () {
	                    displayCategory2(category2Container, data.category_2[categoryMain.c1_id]);
	                });
	                categorySelectMain.append(categoryMainItem);
	            });
	        },
	        error: function (xhr, status, error) {
	            // 에러 처리
	            alert("데이터 안불러와지는중");
	        }
	    });
	}

	function displayCategory2(container, category2List) {
	    container.empty();
	    if (category2List && category2List.length > 0) {
	        var ul = $('<ul class="category2List"></ul>');
	        category2List.forEach(function (category2) {
	            ul.append($('<li>' + category2.c2_category + '</li>'));
	        });
	        container.append(ul);
	    }
	}
	
	const menu=document.querySelector(".one");
	const subBar=document.querySelector(".one>.two");

	let subToggle=true,i=0;

	function slide_menu(){
	  if(subToggle){
	    subBar.style.display="block";
	    subBar.classList.remove("up");
	    subBar.classList.add("down");
	    subToggle=!subToggle;
	  }else{
	    subBar.classList.remove("down");
	    subBar.classList.add("up");
	    subToggle=!subToggle;
	  }
	  console.log(subBar.classList);
	}
	menu.addEventListener("click",slide_menu);
</script>

<body>

	<sec:authentication property="principal" var="member"/>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
  
        
               
         
       
    <!-- Header Section End -->
    
    <!-- Hero Section Begin -->
    
    <!-- Hero Section End -->
</body>

</html>