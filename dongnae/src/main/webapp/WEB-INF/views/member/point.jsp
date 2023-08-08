<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이포인트</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script type="text/javascript">
function kakaopay(){
	let point = Number(${m_point}) + Number($('#pointInput').val() );
	IMP.init('imp18070471');
	IMP.request_pay({		
		pg : 'kakaopay',
		name : '동네마켓 포인트 충전' ,         // 결제창에 뜨는 이름
		amount : $('#pointInput').val() ,  //가격 
	},function(rsp){
		if(rsp.success){
			alert( "결제 완료") ;
			document.location.href="/member/pointSuccess?m_point="+point;
        }else{
        	alert( "결제 실패") ; 
        	document.location.href="/member/point";
        }
		
	});
}
</script>

<body>
<div class="container">
	<h1>내 페이포인트 : <fmt:formatNumber value="${m_point}"/> p</h1>
	<button data-bs-toggle="modal" data-bs-target="#staticBackdrop"> >충전하기</button>
	<h1>페이포인트 사용내역 </h1>
	<table class="table table-hover">
		<tr>
			<th>일자</th>
			<th>구분</th>
			<th>금액</th>
		</tr>
			<c:forEach var="d" items="${dealList}">
			<c:choose>
				<c:when test="${d.d_type == 'buy'}">  
				<tr>
					<td>${d.d_regdate}</td>
					<td>출금</td>
					<td>-<fmt:formatNumber value="${d.g_price}"/> p</td>
				</tr>
				</c:when>
				<c:when test="${d.d_type == 'sold'}">  
				<tr>
					<td>${d.d_regdate}</td>
					<td>입금</td>
					<td>+<fmt:formatNumber value="${d.g_price}"/> p</td>
				</tr>
				</c:when>
				<%-- 
				<c:when test="${d.d_type == 'point'}">  
				<tr>
					<td>${d.d_regdate}</td>
					<td>충전</td>
					<td>+<fmt:formatNumber value="${d.g_price}"/> p</td>
				</tr>
				</c:when>
				 --%>
			</c:choose>
		</c:forEach>
	</table>
</div>

<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
		      <div class="modal-header">
				  <h5 class="modal-title">충전하기</h5>
		      </div>
		      
		      <div class="modal-body">
				 <input type="text" id="pointInput" name="pointInput" style="width: 100%;"> 포인트
		      </div>
		      
		      <div class="modal-footer">
		        <button type="submit" class="btn btn-warning" onclick="kakaopay()">카카오페이 결제</button>
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		      </div>
	    </div>
	  </div>
	</div>
</body>
</html>

