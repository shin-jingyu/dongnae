<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  
</head>


<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
 
<jsp:include page="../common/Category.jsp"></jsp:include>
<div style="display: flex;">		
	
	<div style=" width: 15%; float: left; box-sizing: border-box;">
		<div >
			<table class="table table-borderless">	
			<thead>
			 <tr><th><a href="/community/main" class="fs-3">Community</a></th></tr>
			</thead>
			<tbody>		
			<c:forEach var="categorys" items="${categorys}"  >
			<tr><td><a  href="/community/pageCategory?ca_l=${categorys.ca_l}"> ${categorys.ca_l}</a></td></tr>
			</c:forEach>
			</tbody>
			</table>
		</div>	
	</div>  
	
	<div  style="max-height: calc(100vh - 200px); overflow-x: hidden; overflow-y: auto;  width: 75%; float: right; box-sizing: border-box;">
	
	
		<div>
			<form method="post" action="/community/insertCommunity" enctype="multipart/form-data">
				<input type="hidden" name="m_number" value="${member.m_number }">
				<table class="table table-borderd table table-hover">
				
					<tr><td>
						<label class="form-label">카테고리</label>
						<select class="form-select" name="ca_id"  >
							<option value="1" ${ (ca_id == "1")? "selected" : "" }>사건사고</option>
							<option value="2" ${ (ca_id == "2")? "selected" : "" }>분실/실종</option>
							<option value="3" ${ (ca_id == "3")? "selected" : "" }>일상</option>
							<option value="4" ${ (ca_id == "4")? "selected" : "" }>맛집</option>
							<option value="5" ${ (ca_id == "4")? "selected" : "" }>취미</option>
							<option value="6" ${ (ca_id == "4")? "selected" : "" }>동네질문</option>
						</select></td>
					</tr>
					<tr>
						<td>제목: <input class="form-control" type="text" id="mu_name" name="mu_name"> </td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td colspan="2"><textarea  class="summernote"  name="mu_detail" id="mu_detail"></textarea></td>
					</tr>
					
					<tr>
					
						<td><input class="btn btn-outline-info" id="submits" type="submit" value="등록" ></td>
					</tr>
					
				</table>
			</form>
			<button class="btn btn-outline-info" id="back" >목록으로</button>
		</div>
	
	</div>  
 </div>  
<jsp:include page="../common/footer.jsp"></jsp:include>	
</body>
<script type="text/javascript">
$(document).ready(function() {

	
	var setting = {
		
					 height : 500,
			            minHeight : null,
			            maxHeight : null,
			            focus : true,
			            lang : 'ko-KR',
			            toolbar: [
			                ['style', ['style']],
			                ['font', ['bold', 'underline', 'clear']],
			                ['color', ['color']],
			                ['para', ['ul', 'ol', 'paragraph']],
			                ['table', ['table']],
			                ['insert', ['link', 'picture', 'video']],
			                ['view', ['fullscreen', 'codeview', 'help']]
			              ],
            //콜백 함수
            callbacks : { 
            	onImageUpload : function(files, editor, welEditable) {
            // 파일 업로드(다중업로드를 위해 반복문 사용)
            	for (var i = files.length - 1; i >= 0; i--) {
            		uploadSummernoteImageFile(files[i],this);
            		}
            	},
            	onMediaDelete: function ($target, editor, $editable) {
                    if (confirm('이미지를 삭제 하시겠습니까?')) {
                        var deletedImageUrl = $target
                            .attr('src')
                            .split('/')
                            .pop()
						
                            
                        // ajax 함수 호출
                        deleteSummernoteImageFile(deletedImageUrl)
                       
                    }
                }
			   }
            };
        
	
    $('#mu_detail').summernote(setting);
    
    function deleteSummernoteImageFile(imageName) {
    	
        let data = new FormData();
        
       
        data.append('file', imageName.toString()); 
      
        console.log(imageName);
        $.ajax({
            data: data,
            type: 'POST',
            url: '/deleteSummernoteImageFile',
            contentType: false,
            enctype: 'multipart/form-data',
            processData: false,
            success : function(data) {
            	
                console.log(data);
            }
        });	
        
    };

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
    	
    };	
    
   

   

    $("#back").on('click',function(){	
    	 window.history.back();
    	 
    });
    
    var shouldDeleteImages = true;
   
    
    $(window).on('beforeunload', function() {
    	if (shouldDeleteImages) {
            var imageName = [
                <c:forEach var="imageName" items="${sessionScope.uploadedImageNames}">
                    '${imageName}',
                </c:forEach>
            ];
         deleteSummernoteImageFile(imageName);
         
        }
    	
    });
	function deleteSession() {
        $.ajax({
            type: 'POST',
            url: '/deleteSession'
        });	
    };

    // 글 등록 버튼 클릭 시 이미지 삭제를 방지하기 위해 shouldDeleteImages를 false로 설정
    $('#submits').on('click', function() {
    	var muNameValue = $('#mu_name').val();
    	
    	if(muNameValue.trim() === ''){
    		event.preventDefault(); // 폼 제출 기본 동작을 막음
            alert("글 제목을 입력해주세요.");
    	}else if (confirm("글을 등록하시겠습니까?")) {
    		deleteSession()
        	shouldDeleteImages = false;
            $('form').submit(); // 폼 제출을 수행
        }
    	
    });

   
    
    
});






</script>
</html>