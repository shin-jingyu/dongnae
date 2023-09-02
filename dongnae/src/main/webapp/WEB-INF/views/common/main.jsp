<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<jsp:include page="Category.jsp"></jsp:include>
	<%-- <jsp:include page="header2.jsp"></jsp:include> --%>
	<!-- Categories Section Begin -->

	<!-- Featured Section Begin 상품 목록-->
	<section class="featured spad">
		<div class="container">
			<div class="row featured__filter">
				<c:forEach items="${goodsList }" var="goods">
					<div class="col-lg-3 col-md-4 col-sm-6 mix">
						<div class="featured__item">
							<div class="featured__item__pic set-bg"
								data-setbg="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic01 }">
								<ul class="featured__item__pic__hover">
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
								</ul>
							</div>
							<div class="featured__item__text">
								<a class="move"
									href="<c:out value="goods/goods_detail/${goods.g_id }" />">
									<h6>
										<c:out value="${goods.g_name }" />
									</h6>
								</a>
								<h5>
									<fmt:formatNumber value="${goods.g_price}" pattern="#,###" />
									원
								</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Featured Section End -->


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>