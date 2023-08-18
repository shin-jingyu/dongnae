<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet"> 
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>

</head>
<script>

$(document).ready(function() {

	var toolbar = [
		    // 글꼴 설정
		    ['fontname', ['fontname']],
		    // 글자 크기 설정
		    ['fontsize', ['fontsize']],
		    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		    // 글자색
		    ['color', ['forecolor','color']],
		    // 표만들기
		    ['table', ['table']],
		    // 글머리 기호, 번호매기기, 문단정렬
		    ['para', ['ul', 'ol', 'paragraph']],
		    // 줄간격
		    ['height', ['height']],
		    // 그림첨부, 링크만들기, 동영상첨부
		    ['insert',['picture','link','video']],
		    // 코드보기, 확대해서보기, 도움말
		    ['view', ['codeview','fullscreen', 'help']]
		  ];

	var setting = {
            height : 300,
            minHeight : null,
            maxHeight : null,
            focus : true,
            lang : 'ko-KR',
            toolbar : toolbar,
            //콜백 함수
            callbacks : { 
            	onImageUpload : function(files, editor, welEditable) {
            // 파일 업로드(다중업로드를 위해 반복문 사용)
            	for (var i = files.length - 1; i >= 0; i--) {
            		uploadSummernoteImageFile(files[i],this);
            
            		}
            	}
            }
         };

        $('#mu_detail').summernote(setting);
        });


function uploadSummernoteImageFile(file, el) {
	data = new FormData();
	data.append("file", file);
	$.ajax({
		data : data,
		type : "POST",
		url : "/upload",
		contentType : false,
		enctype : 'multipart/form-data',
		dataType:"json",
		processData : false,
		success : function(data) {
		
			$(el).summernote('editor.insertImage', data.url);
			
			

		}
	});
}	
	
	

</script>
<body>

	<div class="container">
		<h2>글쓰기</h2>
		<P> 반갑습니다. ${member.m_id}님! </P>
		<div>
			<form method="post" action="/insertCommunity" enctype="multipart/form-data">
			<input type="hidden" name="m_number" value="${member.m_number }">
				<table class="table table-borderd table table-hover">
				
					<tr>
						<label class="form-label">카테고리</label>
						<select name="ca_id"  >
							<option value="1" ${ (ca_id == "1")? "selected" : "" }>사건사고</option>
							<option value="2" ${ (ca_id == "2")? "selected" : "" }>분실/실종</option>
							<option value="3" ${ (ca_id == "3")? "selected" : "" }>일상</option>
							<option value="4" ${ (ca_id == "4")? "selected" : "" }>맛집</option>
							<option value="5" ${ (ca_id == "4")? "selected" : "" }>취미</option>
							<option value="6" ${ (ca_id == "4")? "selected" : "" }>동네질문</option>
						</select>
					</tr>
					<tr>
						<td>글제목<input type="text" name="mu_name">
						</td>
					</tr>
					<tr>
						<td>글내용</td>
					</tr>
					<tr>
						<td colspan="2"><textarea  class="summernote"  name="mu_detail" id="mu_detail"></textarea></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="등록" ></td>
					</tr>
					
				</table>
			</form>
			<button onclick="location.href='community'">목록으로</button>
		</div>
	</div>
	
</body>

</html>