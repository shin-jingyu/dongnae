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
<title>categorys</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
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
	
	<div  style=" width: 15%; float: left  ; position: fixed ;box-sizing: border-box;">
	 <div class="container" >
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

	
	<div  class="container" style=" width: 85%;  margin-left:300px; box-sizing: border-box; margin-top:100px;" >
		<div class="container"  style="float: right; width: 400px;" >
		  <div class="row no-gutters" >
		    <div class="col-sm-1 " >
		      <select class="form-select" name="searchType" id="searchType" style="width: 120px; ">
				<option value="mu_name" <c:if test="${page.searchType eq 'mu_name'}">selected</c:if> >제목</option>
				<option value="mu_detail" <c:if test="${page.searchType eq 'mu_detail'}">selected</c:if> >내용</option>
				<option value="mu_name_mu_detail" <c:if test="${page.searchType eq 'mu_name_mu_detail'}">selected</c:if> >제목+내용</option>
				<option value="m_id" <c:if test="${page.searchType eq 'm_id'}">selected</c:if> >작성자</option>
			  </select>
		    </div>
		    <div class="col-sm-2 " style="margin-left:90px"  >
		    	<input class="form-control" style="width: 200px;" type="text" id="keyword" name="keyword" value="${page.keyword}">
		    </div>
		    <div class="col-sm-1" style="margin-left:140px" >
		    	<button class="btn btn-outline-dark"  style="width: 60px;" id="search" type="button">검색</button>
		    </div>
		  </div>
		</div>
	 <p class="text-dark fw-bold">${page.ca_l}</p>
	<div class="card shadow" >
		
		<table class=" table table-borderless align-middle table-hover">
			<thead class=" text-center">
				<tr>
					<th>지역</th>
					<th>사진</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>좋아요</th>
					<th>댓글수</th>
					<th>작성시간</th>
				</tr>
			</thead>
	
		<tbody class=" text-center">
				<c:forEach var="list" items="${list}" >
				<tr onclick="location.href='/community/communityDetail?mu_id=${list.mu_id}&&m_number=${member.m_number}' ">
						<td class="align-middle">${list.si_area}</td>
						<c:choose>
						    <c:when test="${not empty list.previewImageUrl}">
						        <td class="align-middle">
								  <img class="img-thumbnail" src="${list.previewImageUrl}" style="width: 100px;">
							   </td>
						    </c:when>
						    <c:otherwise>
						        <td></td>
						    </c:otherwise>
						</c:choose>
						<td class="align-middle">
							${list.mu_name}
						</td>
						<td class="align-middle">${list.m_id}</td>
						<td class="align-middle"><i class="bi bi-eye fs-5">${list.mu_c}</i></td>
						<td class="align-middle"><i class="bi bi-chat-square-heart fs-5">${list.heart}</i></td>
						<td class="align-middle"><i class="bi bi-chat-right fs-5">${list.comment}</i></td>
						<td class="align-middle" >
							<fmt:formatDate value="${list.mu_data}" pattern="yyyy-MM-dd " />
							<br>
							<fmt:formatDate value="${list.mu_data}" pattern=" HH:mm" />
						</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<button class="btn btn-outline-info"  onclick="location.href='/community/insertCommunity'">글쓰기</button>
 		</div>
 	<div  style="margin:auto;">
 		<nav class="nav justify-content-center bg-light">
		 <ul class="pagination">
			
			<c:if test="${page.prev}">
			 <li class="page-item">
	      		<a class="page-link" href="/community/categorySearch?num=${page.startPageNum - 1}&&ca_l=${page.ca_l}&&keyword=${page.keyword}&&searchType=${page.searchType}" aria-label="Previous">
	        	<span aria-hidden="true">&laquo;</span>
	      		</a>
	    	 </li>
			</c:if>
					
			<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
				 	 <span>
				 		<c:if test="${select != num}">
				 			<li class="page-item">
					  			<a class="page-link" href="/community/categorySearch?num=${num}&&ca_l=${page.ca_l}&&keyword=${page.keyword}&&searchType=${page.searchType}">${num}</a>
					  		</li>
						</c:if>    
					  		
						<c:if test="${select == num}">
							 <li class="page-item">
							 	<a class="page-link" >${num}</a>
							 </li>
						</c:if>
					 </span>
			</c:forEach>
			
			<c:if test="${page.next}">
				<li class="page-item">
			    	<a class="page-link" href="/community/categorySearch?num=${page.endPageNum + 1}&&ca_l=${page.ca_l}&&keyword=${page.keyword}&&searchType=${page.searchType}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			    	</a>
		    	</li>
			</c:if>
	  </ul>
	</nav> 
 	</div>
 	</div>
	</div>
  
	<jsp:include page="../common/footer.jsp"></jsp:include>	
		
				
</body>

<script type="text/javascript">
$("#search").on('click',function(){
	var keyword = $("#keyword").val();
	var searchType = $("#searchType").val();
	var urlParams = new URLSearchParams(window.location.search);
	var ca_l = urlParams.get('ca_l');
	console.log(ca_l);
	console.log(keyword);
	console.log(searchType);
	
	if (keyword == "") {
		confirm("검색할 키워드를 입력하세요");
		return;
	}
	
	$.ajax({
			url: "/community/categorySearch",
			method:"GET",
			data:{
				"ca_l":ca_l,
				"keyword":keyword,
				"searchType":searchType
			},
			success:function(){
				window.location.href='/community/categorySearch?num=1'+"&ca_l="+ca_l+"&keyword="+keyword+"&searchType="+searchType;
			
			}
	});
		
	
  });
	
 
 
 
</script>
</html>