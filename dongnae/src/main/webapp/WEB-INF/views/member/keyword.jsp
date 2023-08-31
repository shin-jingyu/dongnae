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
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:"/keywordapi/keywordGoodsList", 
		type: 'GET',
		dataType: "json",
		success: function(data){
			
		},
		error: function(){
			alert("error load do area");
		}
	});
});
	
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
        <div class="container">
            <div class="row">
             	<div class="col-lg-3 col-md-3">
             	<div class="container border my-3 rounded-3">
             		<div class="sidebar__item ">
			           <table class="table table-hover ">
							<tr class="table ">
								<td>아이폰</td>
								<td><a href="/keywordapi/delete_?id=${c.cartId}" class="badge text-bg-danger">삭제</a></td>
							</tr>
							<tr class="table ">
								<td>아이폰</td>
								<td><a href="/cart/delete?id=${c.cartId}" class="badge text-bg-danger">삭제</a></td>
							</tr>
						</table>
			       </div>
                </div>
                </div>
                
                <div class="col-lg-9 col-md-9">
                    <!-- 상품 리스트 -->
                       <div class="row goodsList">
					    <c:choose>
					        <c:when test="${not empty goodsLists}">
					            <c:forEach items="${goodsLists}" var="goods">
					                <div class="col-lg-4 col-md-6 col-sm-6">
					                    <div class="featured__item">
					                        <div class="featured__item__pic set-bg" data-setbg="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic01}">
					                            <ul class="featured__item__pic__hover">
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