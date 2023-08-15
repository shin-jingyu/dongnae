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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
<h1>welcome 커뮤니티 사이트</h1>
<P> 반갑습니다. ${m_id} 님! </P>
<button onclick="location.href='/member/login'" >로그인</button>
	<div class="container">
	
	<table class="table table-boardered table table-hover">
		<thead>
			<tr>
				
				<th>지역</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>댓글수</th>
				
			</tr>
		</thead>
	</table>
	
	<table class="table table-boardered table table-hover">
		<thead>
			<tr>
				<th>지역</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>댓글수</th>
				
			</tr>
		</thead>
		<tbody>
			
				
			<c:forEach var="list" items="${list}"  >
				<tr>				
					<td>${list.si_area}</td>
					<td>
						<a href="/communityDetail?mu_id=${list.mu_id}&&m_number=<sec:authentication property="principal.m_number"/>&&num=${page.num}" >${list.mu_name}</a>
					</td>
					<td>${list.m_id}</td>
					<td>
						<fmt:formatDate value="${list.mu_data}" pattern="yyyy-MM-dd HH:mm" />
					</td>
					<td>${list.mu_c}</td>
					<td>${list.heart}</td>
					<td>${list.comment}</td>
				</tr>
			</c:forEach>
			
				
			
		</tbody>
		<c:if test="${page.prev}">
					<span>[ <a href="/communitySearch?num=${page.startPageNum - 1}${page.searchTypeKeyword}">이전</a> ]</span>
				</c:if>
			
				<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
			 	 <span>
			 			<c:if test="${select != num}">
			 			<a href="/communitySearch?num=${num}${page.searchTypeKeyword}">${num}</a>
					</c:if>    
			  
					<c:if test="${select == num}">
						<b>${num}</b>
					</c:if>
			    
				 </span>
				</c:forEach>
				<c:if test="${page.next}">
				 <span>[ <a href="/communitySearch?num=${page.endPageNum + 1}${page.searchTypeKeyword}">다음</a> ]</span>
				</c:if>
	</table>
	<button  onclick="location.href='insertCommunity?m_id=${m_id}'">글쓰기</button>
</div>
 <div>
	<select name="searchType"  >
	<option value="mu_name" <c:if test="${page.searchType eq 'mu_name'}">selected</c:if> >제목</option>
	<option value="mu_detail" <c:if test="${page.searchType eq 'mu_detail'}">selected</c:if> >내용</option>
	<option value="mu_name_mu_detail" <c:if test="${page.searchType eq 'mu_name_mu_detail'}">selected</c:if> >제목+내용</option>
	<option value="m_id" <c:if test="${page.searchType eq 'm_id'}">selected</c:if> >작성자</option>
	</select>
	<input type="text" name="keyword" value="${page.keyword}">
	<button type="button">검색</button>
 </div>					
</body>
<script type="text/javascript">
$("#search").on('click',function(){
	var keyword = $("#keyword").val();
	var searchType = $("#searchType").val();
	 console.log(searchType);
	 console.log(keyword);
	if (keyword == null) {
		confirm("검색할 키워드를 입력하세요");
		location.reload(); 
	}else{
	
		$.ajax({
			url: "/communitySearch",
			method:"GET",
			data:{
				"keyword":keyword,
				"searchType":searchType
			},
			success:function(){
				 console.log(searchType);
				 location.href='communitySearch?num=1'+ "&searchType=" + searchType + "&keyword=" + keyword;
			
			}
		});
	}	
	
  });
	
</script>
</html>