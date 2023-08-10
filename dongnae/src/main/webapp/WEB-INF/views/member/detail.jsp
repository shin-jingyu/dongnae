<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<meta charset="UTF-8">
<title>내 프로필</title>


<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:"/member/detail/do_area", 
			type: 'POST',
			dataType: "json",
			success: function(data){
				var options = "";
				for(var i= 0 ; i< data.length; i++){
					options+= "<option value='" + data[i].do_id + "' ${ (member.do_id == '" + data[i].do_id + "')? 'selected' : '' }>" + data[i].do_area + " </option>"
					// <option value="1" ${ (member.do_id == '" + data[i].do_id + "')? "selected" : "" }>수원</option>
				}
				$("#do_id").html(options);
			},
			error: function(){
				alert("error load do area");
			}
		});
		
	});
		
	function do_select(){
		let doData = $("#do_id option:selected").val();
		$.ajax({
			url: '/member/detail/si_area',
			type:'POST',
			data: doData, 
			contentType: 'application/json',  /* 이거 넣으니까 오류 해결: 여기는 보내는 do_id */ 
			dataType: "json",	 	/* 여기는 받는 si_area List */ 
			success:function(data){		
				var options = "";
				for(var i= 0 ; i< data.length; i++){
					options+= "<option value='" + data[i].si_id + "' ${ (member.si_id == '" + data[i].si_id + "')? 'selected' : '' }>" + data[i].si_area + " </option>"
				}
				$("#si_id").html(options);
				$("#do_default").remove();  // 여기서 도.광역시 애를 삭제하면 될 듯
			},
			error:function(){
				alert("error load si area");
			}
		})
	}
	
	function do_click(){
		let doData = $("#do_id option:selected").val();
		$.ajax({
			url: '/member/detail/si_area',
			type:'POST',
			data: doData, 
			contentType: 'application/json',  /* 이거 넣으니까 오류 해결: 여기는 보내는 do_id */ 
			dataType: "json",	 	/* 여기는 받는 si_area List */ 
			success:function(data){		
				var options = "";
				for(var i= 0 ; i< data.length; i++){
					options+= "<option value='" + data[i].si_id + "' ${ (member.si_id == '" + data[i].si_id + "')? 'selected' : '' }>" + data[i].si_area + " </option>"
				}
				$("#si_id").html(options);
				$("#do_default").remove();  // 여기서 도.광역시 애를 삭제하면 될 듯
			},
			error:function(){
				alert("error load si area");
			}
		})
	}
/* 	
	// 여기
	function si_click(){
		let doData = $("#do_id option:selected").val();
		$.ajax({
			url: '/member/detail/si_area',
			type:'POST',
			data: doData, 
			contentType: 'application/json',   
			dataType: "json",	 	 
			success:function(data){		
				var options = "";
				for(var i= 0 ; i< data.length; i++){
					options+= "<option value='" + data[i].si_id + "' ${ (member.si_id == '" + data[i].si_id + "')? 'selected' : '' }>" + data[i].si_area + " </option>"
				}
				$("#si_id").html(options);
			},
			error:function(){
				alert("error load si area");
			}
		})
	}
	 */
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
                <div class="col-lg-9 col-md-7">
	                <div class="container border my-3 rounded-5 text-center">
	                <div class="container mx-auto" style="width: 80%;">
	                            <div class="row my-5" >
	                           		<h2>내 프로필</h2>
	                           	</div>
	                        	<div class="row  my-3">
	                            	<form name="updateForm" action=update method="post" class="form-horizontal">
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		아이디
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input readonly name="m_id"  type="text" value="${member.m_id}" class="form-control">
											</div>	
										</div>
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		이름
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input   name="m_name"  type="text" value="${member.m_name}" class="form-control">
											</div>		
										</div>
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											  이메일            		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input readonly name="m_email"  type="text" value="${member.m_email}" class="form-control">
											</div>		
										</div>
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											    핸드폰          		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input   name="m_phone"  type="text" value="${member.m_phone}" class="form-control">
											</div>	

										</div>
										<div class="form-group row">
											<label class="col-sm-4">내 동네</label>
											<div class="col-12 col-sm-3 align-self-center">
												 <select onchange="do_select()" onclick="do_click()" id="do_id" name="do_id" class="form-select">
										    	</select>
											</div>	
											<div class="col-12 col-sm-5 align-self-center">
										  		 <select  id="si_id"  name = "si_id" class="form-select">
											   		<option selected>시/군/구</option>
												</select> 
											</div>
										</div>	
										
										<div class="form-group  row">
										<div class="col-12  mt-3">
						                    <input type="submit" class="btn btn-primary" value="수정 ">
					                	</div> 
					                	</div>
									</form>
	                            </div>
	                        </div>
	                    </div>
	                    </div>
                </div>
                </div>
    </section>
    <!-- Product Section End -->
	
	<jsp:include page="../footer.jsp"></jsp:include>


</body>
</html>