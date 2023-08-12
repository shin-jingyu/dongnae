<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>

<script>
 
	function deleteCommunity(mu_id) {
		var del= confirm("삭제하시겠습니까?");
		if(del){
			location.href="deleteCommunity/${communityDetail.mu_id }";
				
		}
	};
	
	
	
</script>
<body>
	<h2>상세보기</h2>
	<P>반갑습니다. ${m_id} 님!</P>
	<div class="container">
		<table class="table table-borderd table table-hover">
			<tr>
				<td>글이름</td>
				<td>${communityDetail.mu_name }</td>
			</tr>
				
			<tr>
				<td>지역 ${sessionScope.m_number}</td>
				<td>${communityDetail.si_area }</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>${communityDetail.ca_l }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${communityDetail.m_id }</td>
			</tr>
			<tr>
				<td>작성시간</td>
				<td><fmt:formatDate value="${communityDetail.mu_data }" pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<td colspan="2">글 내용</td>
			</tr>
			<tr>
				<td colspan="2">${communityDetail.mu_detail }</td>
			</tr>

			<tr>
				<td colspan="2" class="text-center"><a class="text-dark heart"
					style="text-decoration-line: none;"> <img id="heart" width="30"
						src="/resources/img/blog/icon/HeartF.png">좋아요
				</a>



					<button onclick="location.href='community'">목록으로</button>
					
					<!--작성자만 보이는 버튼   -->
					<c:if test = '${sessionScope.m_id == communityDetail.m_id}'>
					<button onclick="location.href='updateCommunity?mu_id=${communityDetail.mu_id }'">수정하기</button>
					<button onclick="deleteCommunity(${communityDetail.mu_id })">삭제하기</button>
					</c:if>
				</td>
			</tr>


		
		</table>
		<!-- 로그인 한사람만 댓글 작성가능  -->
			<c:if test='${sessionScope.m_id != null}'>	
			<form method="post" action="/comment">

				<p>
					<input type="hidden" name="m_number"
						value="<sec:authentication property="principal.m_number"/>">
					<input type="hidden" name="mu_id" value="${communityDetail.mu_id }">
				</p>
				<p>
					<textarea rows="5" cols="50" name="com_c"></textarea>
				</p>
				<p>
					<button type="submit">댓글 작성</button>
				</p>
			</form>
			</c:if>
		
			
			<c:forEach var="comment" items="${comment}"  >
				<li>	
					<input type="hidden" name="m_number"
						   value="<sec:authentication property="principal.m_number"/>">
					<input type="hidden" name="mu_id" value="${comment.mu_id }">
					<input type="hidden" name="com_id" value="${comment.com_id }">
					<p>	작성자: ${m_id} 작성시간: <fmt:formatDate value="${comment.com_data}" pattern="yyyy-MM-dd HH:mm" /> </p>
					
					<div id="modifyComment" >
						<p>내용: <input id="updateid"  type="text" value="${comment.com_c}" readonly/>	
							<button id ="buttony" hidden="true" data-com_id="${comment.com_id }" >완료</button>
							<button id ="buttons" hidden="true" >취소</button>
						</p>
					</div>	
					
					<!-- 댓글 사용자만 수정및 삭제 가능 -->
					<c:if test = '${sessionScope.m_id != null}'>
					<button type="button" class="updateComment" >댓글 수정</button>
					<button type="button" id="deleteComments" class="deleteComment" data-com_id="${comment.com_id }">댓글 삭제</button>
					</c:if>
					
				</li>	
			</c:forEach>
			
			
		
	</div>


</body>

<script type="text/javascript">
//댓글 수정 버특 클릭시 
$(".updateComment").on('click',function(){
	//댓글 수정 활성화
	$('#updateid').attr('readonly',false);
	//버튼보이기
	$('#buttony').attr('hidden',false);
	$('#buttons').attr('hidden',false);
	
	$("#buttony").on('click',function(){
		var updatedComment = $("#updateid").val();
		var com_id = $("#deleteComments").data("com_id");
		
		$.ajax({
	        url: '/updateComment', // 컨트롤러 URL
	        method: 'POST', // POST 요청
	        data: {
	        	'com_id':com_id,
				'com_c':updatedComment
	        	
	        }, // 댓글 내용을 데이터로 전송
	        success: function (response) {
	            // 성공 시 처리
	            console.log('댓글 수정 완료');
	            location.reload();
	        }
	    });
	});
	$("#buttons").on('click',function(){
		location.reload();
	});

});
// 댓글 삭제 
$(".deleteComment").on('click',function(){
	var com_id = $("#buttony").data("com_id");
	var deletes= confirm("삭제하시겠습니까?");
	$.ajax({
        url: '/deleteComment', // 컨트롤러 URL
        method: 'POST', // POST 요청
        data: {'com_id':com_id}, // 댓글 내용을 데이터로 전송
        success: function (response) {
            // 성공 시 처리
    		if(deletes){
    			 console.log('댓글 삭제 완료');
    	            location.reload();        
    		}
        }
    });
});




//좋아요 구현
$(document).ready(function (){
	var heartval = '${heartview.h_num}';
	if(heartval>0){
		$("#heart").prop("src","/resources/img/blog/icon/HeartS.png");
		$(".heart").prop("name",heartval)
	}
	else {
		console.log(heartval);
		$("#heart").prop("src","/resources/img/blog/icon/HeartF.png");
		$(".heart").prop("name",heartval)
	}
	 $(".heart").on("click", function () {
		 var that = $(".heart");
        $.ajax({
	    	url :'/heart',
	        type :'POST',
	        data : {
	        	'mu_id':${communityDetail.mu_id},
	        	'm_number': <sec:authentication property="principal.m_number"/>
	        },
	    	success : function(data){
	    		that.prop('name',data);
	    		console.log(data);
	    		if(data==1) {
	        		$("#heart").prop("src","/resources/img/blog/icon/HeartS.png");
	        		location.reload();
	        		} else {
	        		$("#heart").prop("src","/resources/img/blog/icon/HeartF.png");	
	        		location.reload();
	        	}
	    		}
	        });
     }); 
     
 });

</script>

</html>