<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>

<script >
 
	function deleteCommunity(mu_id) {
		var del= confirm("삭제하시겠습니까?");
		if(del){
			location.href="deleteCommunity/${communityDetail.mu_id }";
				
		}
	};
	
	

</script>
<body>
	<h2>상세보기 </h2>
	<P> 반갑습니다. ${m_id} 님! </P>
	<div class="container">
	 <table class="table table-borderd table table-hover">
		<tr>
			<td>글이름</td>
			<td>${communityDetail.mu_name }</td>
		</tr>
		
		<tr>
			<td>지역</td>
			<td>${communityDetail.si_area }</td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td>${communityDetail.ca_l }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td> ${communityDetail.m_id }</td>
		</tr>
		<tr>
			<td>작성시간</td>
			<td>${communityDetail.mu_data }</td>
		</tr>
		<tr>
			<td colspan="2">글 내용</td>
		</tr>	
		<tr>	
			<td colspan="2">${communityDetail.mu_detail }</td>
		</tr>
		
		<tr>	
			<td colspan="2" class="text-center">
				<div>
					
					
				</div>
				<br>	
				<a class="text-dark heart" style="text-decoration-line: none;">
					<img id="heart" width="30" src="/resources/img/blog/icon/HeartF.png">${communityDetail.heart }</a>
				<br><br>
				
				<button onclick="location.href='community'">목록으로</button>
				<button onclick="location.href='updateCommunity?mu_id=${communityDetail.mu_id }'">수정하기</button>
				<button onclick="deleteCommunity(${communityDetail.mu_id })" >삭제하기</button>
				
			</td>
		</tr>
		
		
		
	 </table>	
	</div>
	
</body>
<script type="text/javascript">
$(document).ready(function (){
	var heartval = ${heartview.h_num}
	if(heartval>0){
		console.log(heartval);
		$("#heart").prop("src","/resources/img/blog/icon/HeartS.png");
		$(".heart").prop("name",heartval)
	}
	else{
		console.log(heartval);
		$("#heart").prop("src","/resources/img/blog/icon/HeartF.png");
		$(".heart").prop("name",heartval)
	}
	 $(".heart").on("click", function () {
         var that = $(".heart");
	    $.ajax({
	    	url :'/heart',
	        type :'POST',
	        data : {'mu_id':${communityDetail.mu_id}, 'm_id':${m_id}},
	    	success : function(data){
	    		that.prop('name',data);
	        	if(data==1) {
	            	     $('#heart').prop("src","/resources/img/blog/icon/HeartS.png");
	        	} else {
                 	     $('#heart').prop("src","/resources/img/blog/icon/HeartF.png");
	        	}
          	}
	    });
     });
 });

</script>
</html>