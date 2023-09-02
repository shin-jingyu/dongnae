<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<jsp:include page="../common/Category.jsp"></jsp:include>
<style>
    .img-thumbnail {
       width: 100px;
    }
</style>

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic01 }" alt="">
                        </div>
                        <div class="product__details__pic__slider owl-carousel">
                            <img data-imgbigurl="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic02 }"
                                src="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic02 }" alt="">
                            <img data-imgbigurl="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic03 }"
                                src="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic03 }" alt="">
                            <img data-imgbigurl="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic01 }"
                                src="/resources/upload/goods/${goods.g_picpath}/${goods.g_pic01 }" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3><c:out value="${goods.g_name }"/></h3>
                        <div class="product__details__price"><fmt:formatNumber value="${goods.g_price}"  pattern="#,###"/>원</div>
                        <p><c:out value="${goods.g_text }"></c:out></p>
                        <a href="/chat" class="primary-btn">구매하기</a>
                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                    </div>
                    <div class="mt-5">
                    	<p>판매자의 다른 상품</p>
                    </div>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item member_goods">
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic goods_pic">
                                    <img src="/resources/img/latest-product/lp-1.jpg" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6 class="goods_name"></h6>
                                    <span class="goods_price"></span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

    <!-- Related Product Section Begin -->
    <section class="related-product">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related__product__title">
                        <h2>관련 상품</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="/resources/img/product/product-1.jpg">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Related Product Section End -->
    
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
		    getMemberGoods();
		
		})
				 
		function getMemberGoods() {
		    var m_number = ${goods.m_number};
		
		    $.ajax({
		        url: '/goods/memberGetGoodsList',
		        type: 'post',
		        data: { m_number: m_number },
		        dataType: 'json',
		        success: function (data) {
		            console.log(data);
		            var latest_product_item = $('.latest-prdouct__slider__item.member_goods');
		
		            latest_product_item.empty();
		
		            var memberGoodsData = data.memberGoods;
		            memberGoodsData.forEach(function (membergoods) {
		                var imgSrc = '/resources/upload/goods/' + membergoods.g_picpath + '/' + membergoods.g_pic01;
		                var goodsprice = membergoods.g_price.toLocaleString('ko-KR');
		                var goodsname = membergoods.g_name;
		
		                var product_item = $('<a>').attr('href', '#').addClass('latest-product__item');
		                var product_pic = $('<div>').addClass('latest-product__item__pic goods_pic img-thumbnail');
		                var img = $('<img>').attr('src', imgSrc).attr('alt', '');
		                var product_text = $('<div>').addClass('latest-product__item__text');
		                var h6 = $('<h6>').addClass('goods_name').text(goodsname);
		                var span = $('<span>').addClass('goods_price').text(goodsprice);
		
		                product_pic.append(img);
		                product_text.append(h6);
		                product_text.append(span);
		                product_item.append(product_pic);
		                product_item.append(product_text);
		
		                var slider_item = $('<div>').addClass('latest-prdouct__slider__item member_goods');
		                slider_item.append(product_item);
		
		                latest_product_item.append(slider_item);
		            });
		        },
		        error: function (xhr, status, error) {
		            // 에러 처리
		            alert("데이터를 불러오는 중에 문제가 발생했습니다.");
		        }
		    });
		}


	</script>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>