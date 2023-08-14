<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이포인트</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript">
function kakaopay(){
	IMP.init('imp18070471');
	IMP.request_pay({		
		pg : 'kakaopay',
		name : '동네마켓 포인트 충전' ,         // 결제창에 뜨는 이름
		amount : $('#p_price').val()  	 	//가격 
	},function(rsp){
		var options = "";
		if(rsp.success){
			alert( "결제 완료") ;
			$("#putPoint").submit();
        }else{
        	alert( "결제 실패") ; 
        	document.location.href="/member/point";
        }
	})
};
</script>
		
</head>

<body>
<sec:authentication property="principal" var="member"/>

<jsp:include page="../header_member.jsp"></jsp:include>

 <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>My Page</h2>
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
                    <div class="sidebar">
                    	<jsp:include page="./sidebar.jsp"></jsp:include>
                    </div>
                </div>
                <div class="col-lg-9 col-md-9">
                <div class="row">
                	<div class="container border my-3 rounded-5">
                		<div class="row">
	                            <div class="col-lg-5 col-md-5  col-sm-11 col-11  my-4 text-center" >
	                           		<h2>내 페이포인트</h2>
	                           	</div>
	                            <div class="col-lg-4 col-md-4 col-sm-11 col-11  my-4  text-center" >
	                           		<h2><fmt:formatNumber value="${m_point}"/> p</h2>
	                           	</div>
	                            <div class="col-lg-3 col-md-3 col-sm-11 col-11  my-4  text-center" >
	                           		<button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">충전하기</button>
	                           	</div>
	                        </div>
	                     </div>
	            </div>
	            
                <div class="row">
	                <div class="container border my-3 rounded-5">
	                <!-- <div class="container mx-auto" style="width: 80%;"> -->
	                
	                            <div class="row mt-5  text-center" >
	                           		<h2>페이포인트 사용내역</h2>
	                           	</div>
	                           	
	                           	<div class="row my-3">
		                        	<div class="col-12 col-md-11 my-3 mx-auto">
		                        		<table class="table table-hover">
											<tr>
												<th>일자</th>
												<th>구분</th>
												<th>금액</th>
											</tr>
												<c:forEach var="p" items="${pointList}">
												<c:choose>
													<c:when test="${p.p_type == 'minus'}">  
													<tr>
														<td>${p.p_regdate}</td>
														<td>출금</td>
														<td>-<fmt:formatNumber value="${p.p_price}"/> p</td>
													</tr>
													</c:when>
													<c:when test="${p.p_type == 'plus'}">  
													<tr>
														<td>${p.p_regdate}</td>
														<td>입금</td>
														<td>+<fmt:formatNumber value="${p.p_price}"/> p</td>
													</tr>
													</c:when>
													<c:when test="${p.p_type == 'put'}">  
													<tr>
														<td>${p.p_regdate}</td>
														<td>충전</td>
														<td>+<fmt:formatNumber value="${p.p_price}"/> p</td>
													</tr>
													</c:when>
												</c:choose>
											</c:forEach>
										</table>
		                            </div>
	                            </div>
	                            
	                             
	                            <div class="row my-3">
	                            <div class="col-12 col-md-11 my-3 mx-auto">
	                            	<nav aria-label="Page navigation example  ">
									  <ul class="pagination justify-content-center">
									   
									   <c:set var="p" value="${page}" /> 
									   
									   <c:choose>
										   <c:when test="${p.prev > 0}" >
										    	<li class="page-item"><a class="page-link" href="/member/point?p=${p.prev}">Previous</a></li>
										   </c:when>
										   <c:otherwise>
										    	<li class="page-item disabled"><a class="page-link">Previous</a></li>
										   </c:otherwise>
									   </c:choose>
									   
									    <c:forEach var="pageNum" begin="${p.startPageNum}" end="${p.endPageNum}">
									    	<li class="page-item ${ (p.nowpage == pageNum )?  'active' : '' } " >
									    		<a class="page-link" href="/member/point?p=${pageNum}">${pageNum}</a>
									    	</li>
									    </c:forEach>
									    
									 	<c:choose>
										   <c:when test="${p.next <= p.realEndPageNum}" >
										    	<li class="page-item"><a class="page-link" href="/member/point?p=${p.next}">Next</a></li>
										   </c:when>
										   <c:otherwise>
										    	<li class="page-item disabled"><a class="page-link">Next</a></li>
										   </c:otherwise>
									   </c:choose>
									  </ul>
									</nav>
	                            </div>
	                        </div>
	                        
	                            
	                        </div>
	                    <!-- </div> -->
	                   </div>
	                   
	            </div>
                </div>
                </div>
    </section>
    <!-- Product Section End -->

	<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    <form id="putPoint" action="point" method="post">
       			<input hidden name="m_id" value="${member.m_id}">
       			<input hidden name="p_type" value="put">
			      <div class="modal-header">
					  <h5 class="modal-title">충전하기</h5>
			      </div>
			      
			      <div class="modal-body" id="p_priced" >
					 <input type="text" id="p_price" name="p_price" style="width: 100%;"> 포인트
			      </div>
			      
			      <div class="modal-footer">
			        <button type="button" class="btn btn-warning" onclick="kakaopay()">카카오페이 결제</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
			      </div>
		    </form>
		    </div>
		  </div>
		</div>
		
		<jsp:include page="../footer.jsp"></jsp:include>
		
	
</body>
</html>