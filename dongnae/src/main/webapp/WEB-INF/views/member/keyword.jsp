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
</head>
<body>
	<jsp:include page="../common/Category.jsp"></jsp:include>
	
	
		  <div class="sidebar__item ">
           <h4>My Page</h4>
           <ul>
               <li><a href="/member/detail">내 프로필</a></li>
               <li><a href="/member/changePassword">비밀번호 변경</a></li>
               <li><a href="/member/onSaleList">판매 중 상품</a></li>
               <li><a href="/member/soldList">판매내역</a></li>
               <li><a href="/member/buyList">구매내역</a></li>
               <li><a href="/member/wishlist">찜 목록</a></li>
               <li><a href="/member/review">내 거래 후기</a></li>
               <li><a href="/member/point">내 페이포인트</a></li>
           </ul>
       </div>
	
	
	
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
            <div class="col-lg-3 col-md-3">
                    <div class="sidebar">
                    	<jsp:include page="./sidebar.jsp"></jsp:include>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
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