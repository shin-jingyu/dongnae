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
	<header>

        <a href="#" class="logo"><img src="/resources/img/logo.png" alt=""></a>

        <nav class="navbar">
        <section class="hero">
        <div class="container">
            <div class="row">
                <!-- 검색 -->
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div style="z-index: 2;">
            <ul>
            
                <li><a href="">메인화면</a></li>
                <li><a href="#">about</a></li>
                <li><a href="#">Pages +</a>
                    <ul>
                        <li><a href="">수입명품</a>
                            <ul>
                                <li><a href="">여성신발</a></li>
                                <li><a href="">남성신발</a></li>
                                <li><a href="">가방/핸드백</a></li>
                                <li><a href="">지갑/벨트</a></li>
                                <li><a href="">여성의류</a></li>
                                <li><a href="">남성의류</a></li>
                                <li><a href="">패션잡화</a></li>
                                <li><a href="">시계/쥬얼리</a></li>
                                <li><a href="">육아</a></li>
                                <li><a href="">기타</a></li>
                            </ul>
                        </li>
                        <li><a href="">패션의류</a>
                            <ul>
                                <li><a href="">여성의류</a></li>
                                <li><a href="">남성의류</a></li>
                                <li><a href="">js</a></li>
                            </ul>
                        </li>
                        <li><a href="">패션잡화</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">뷰티</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">모바일/테블릿</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">가전제품</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">노트북/PC</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">카메라/캠코더</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">가구/인테리어</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">리빙/생활</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">게임</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">반려동물</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">도서/음반</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">스포츠</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">공구/산업용품</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                        <li><a href="">무료나눔</a>
                            <ul>
                                <li><a href="">html</a></li>
                                <li><a href="">css</a></li>
                                <li><a href="">js</a></li>
                                <li><a href="">java</a></li>
                                <li><a href="">jsp</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">Review</a></li>
                <li><a href="#">Gallery +</a>
                    <ul>
                        <li><a href="">grid gallery</a></li>
                        <li><a href="">flex gallery</a></li>
                    </ul>
                </li>
                
                <li><a href="/member/login"><i class="fa fa-user"></i> Login</a></li>
            </ul>
    	</div>
        </nav>
    </header>
				<div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>$150.00</span></div>
                    </div>
                </div>
           
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>	
</body>
</html>