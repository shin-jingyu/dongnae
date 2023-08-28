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
<body>
	<jsp:include page="../common/Category.jsp"></jsp:include>
	
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>필터</h4>
                            <div>
	                           	<c:out value="${search }"></c:out>
                            </div>
                            <hr>
                            <h4>카테고리</h4>
                            <ul class="list_category">
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="product__discount">
                        <div class="section-title product__discount__title searchName">
                            <h2>${search }</h2>
                        </div>
                    </div>
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                                <div class="filter__sort">
                                    <span>분류</span>
                                    <select>
                                        <option value="0">Default</option>
                                        <option value="0">Default</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="filter__found">
                                    <h6><span><b>${goodsLists.size()} </b></span> 개의 상품을 찾았습니다.</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 상품 리스트 -->
                       <div class="row">
					    <c:choose>
					        <c:when test="${not empty goodsLists}">
					            <c:forEach items="${goodsLists}" var="goods">
					                <div class="col-lg-4 col-md-6 col-sm-6">
					                    <div class="featured__item">
					                        <div class="featured__item__pic set-bg" data-setbg="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic01}">
					                            <ul class="featured__item__pic__hover">
					                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
					                            </ul>
					                        </div>
					                        <div class="featured__item__text">
					                            <a class="move" href="<c:out value='${pageContext.request.contextPath }/goods/goods_detail/${goods.g_id}' />">
					                                <h6><c:out value="${goods.g_name }"/></h6>
					                            </a>
					                            <h5><fmt:formatNumber value="${goods.g_price}"  pattern="#,###"/>원</h5>
					                        </div>
					                    </div>
					                </div>
					            </c:forEach>
					        </c:when>
					        <c:otherwise>
					            <p><c:out value="${search}" /> 해당 상품을 찾을 수 없습니다.</p>
					        </c:otherwise>
					    </c:choose>
					</div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->
	
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>