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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

</head>


<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<jsp:include page="../common/Category.jsp"></jsp:include>
<section class="breadcrumb-section set-bg" data-setbg="/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                 
                    <div class="breadcrumb__text">
                   <h2 >Community</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

<div style="display: flex;">	
	<div  style=" width: 15%; float: left  ; box-sizing: border-box; ">
		<div class="container" style="margin-left:50px;margin-top:100px;">
		<table class="table table-borderless">	
			<thead>
			 <tr><th><a href="/community/main" class="fs-3">Community</a></th></tr>
			</thead>
			<tbody>		
			
			<c:forEach var="categorys" items="${categorys}"  >
			<tr><td><a  href="/community/pageCategory?ca_l=${categorys.ca_l}&num=1"> ${categorys.ca_l}</a></td></tr>
			</c:forEach>
			
			</tbody>
			
			</table>
		</div>
	</div>
	<div class="container"  style="  width: 85%;  float: right; box-sizing: border-box;margin-top:100px;">
		${communityDetail.si_area } / ${communityDetail.ca_l }
		<div class="card">	 
		  
		  <div class="card-header">
		   작성자 : ${communityDetail.m_id }
		   <div style="float: right;"><fmt:formatDate value="${communityDetail.mu_data }" pattern="yy.MM.dd HH:mm" /></div>
		  </div>
		  <div class="card-header">
		   제목 : ${communityDetail.mu_name }
		  </div>
		  <div class="card-body">
		    <h5 class="card-title"></h5>
		    <p class="card-text">${communityDetail.mu_detail }</p>
		   
		  </div>
		  <div class="card-footer text-muted">
		   <a class="text-dark heart"style="text-decoration-line: none;"> 
		   	<img id="heart" width="30" src="/resources/img/blog/icon/HeartF.png">좋아요
		   </a>

					
			<button class="btn btn-outline-info" id="goBack" type="button" >목록으로</button>
					
					
					<!--작성자만 보이는 버튼   -->
					<c:if test = '${member.m_id == communityDetail.m_id}'>
					<button class="btn btn-outline-info" onclick="location.href='/community/updateCommunity?mu_id=${communityDetail.mu_id }'">수정하기</button>
					<button class="btn btn-outline-info" id="deleteCommunity" type="button">삭제하기</button>
					</c:if>
		  </div>
		  <div class="card-footer text-muted">
		
		

		<!-- 로그인 한사람만 댓글 작성가능  -->
			<c:if test='${member.m_id != null}'>	
				<form method="post" action="/comment">
	
					<p>
						<input type="hidden" name="m_number"value="${member.m_number}">
						<input type="hidden" name="mu_id" value="${communityDetail.mu_id }">
					</p>
					<p class="input-group mb-3">
						<textarea style="resize: none;" class="form-control" rows="5" cols="50" name="com_c"></textarea>
						<button class="btn btn-outline-secondary" type="submit">댓글 작성</button>
					</p>
					
				</form>
			</c:if>
		 </div>
		 <div class="card-footer text-muted">	
			<c:forEach var="comment" items="${comment}"  >
					
					<input type="hidden" name="m_number" value="${member.m_number}">
					<input type="hidden" name="mu_id" value="${comment.mu_id }">
					<input type="hidden" name="com_id" value="${comment.com_id }">

					<div id="modifyComment" style="margin-top:10px;" >
					<p> 
					<span > ${member.m_id}</span> 
					<span style="margin-left: 320px;"> <fmt:formatDate value="${comment.com_data}" pattern="yyyy-MM-dd HH:mm" /> </span>
					</p>
					<p> <textarea  class="form-control " maxlength="100" style=" width:500px; resize: none;  overflow-y: hidden;   border: none; word-break:normal;  " id="updateid"   readonly>${comment.com_c}</textarea></p>	
					</div>
	
					<!-- 댓글 사용자만 수정및 삭제 가능 -->
					<c:if test = '${member.m_number == comment.m_number}'>
					<button type="button" class="btn btn-outline-info" id="updateComment" >댓글 수정</button>
					<button type="button" class="btn btn-outline-info" id="deleteComments"  data-com_id="${comment.com_id }">댓글 삭제</button>
					</c:if>
					
				
			</c:forEach>
			</div>
			 </div>
		</div>
		
		
	</div>	

<jsp:include page="../common/footer.jsp"></jsp:include>

</body>

<script type="text/javascript">

document.addEventListener('DOMContentLoaded', function() {
    var goBackButton = document.getElementById('goBack');
    
    if (goBackButton) {
        goBackButton.addEventListener('click', function() {
            // 세션 스토리지에서 이전 URL 가져오기
            var previousURL = sessionStorage.getItem('previousURL');
            
            if (previousURL) {
                // 이전 URL로 이동
                window.location.href = previousURL;
            } else {
                // 이전 URL이 없는 경우 기본 경로로 이동
                window.location.href = "/";
            }
        });
    }
});




//글삭제

$("#deleteCommunity").on('click',function(){
	var del= confirm("삭제하시겠습니까?");
	if (del) {
		$.ajax({
			url: "/community/deleteCommunity",
			method:"GET",
			data:{"mu_id":${communityDetail.mu_id}},
			success:function(response){
				 alert("글삭제완료");
				 location.href="/community/main";
				 
			}
		
		});
	}
  });
	




//댓글 수정 버특 클릭시 
$("#updateComment").on('click',function(){
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
$("#deleteComments").on('click',function(){
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
	var heartval = '${heartview}';
	if(heartval>0){
		$("#heart").prop("src","/resources/img/blog/icon/HeartS.png");
		$(".heart").prop("name",heartval)
	}
	else {
		$("#heart").prop("src","/resources/img/blog/icon/HeartF.png");
		$(".heart").prop("name",heartval)
	}
	 $(".heart").on("click", function () {
		 var that = $(".heart");
        $.ajax({
	    	url :'/heart',
	        type :'POST',
	        dataType:'json',
	        data : {
	        	'mu_id':${communityDetail.mu_id},
	        	'm_number': ${member.m_number}
	        },
	    	success : function(data){
	    		that.prop('name',data);
	    		console.log(data);
	    		if(data==1) {
	        		$("#heart").prop("src","/resources/img/blog/icon/HeartS.png");
	        		
	        	} else {
	        		$("#heart").prop("src","/resources/img/blog/icon/HeartF.png");	
	        	 
	        	}
	    		}
	        });
     }); 
     
 });

</script>

</html>