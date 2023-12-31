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
			url:"/member/detail/my_area", 
			type: 'POST',
			dataType: "json",
			success: function(data){
				const m_do_id = ${member.do_id};
				const m_si_id = ${member.si_id};
				
				var do_options = "";
				var si_options = "";
				
				for(var i= 0 ; i< data.doList.length; i++){
					let list_do_id = data.doList[i].do_id;
					let list_do_area = data.doList[i].do_area ;
					if(m_do_id == list_do_id ){
						do_options += "<option value='" +  list_do_id + "' selected>"+ list_do_area +"</option>";
					} else{
						do_options += "<option value='" +  list_do_id + "'>"+ list_do_area +"</option>";
					}
				}
				$("#do_id").html(do_options);
				
				for(var i= 0 ; i< data.siList.length; i++){
					let list_si_id = data.siList[i].si_id;
					let list_si_area = data.siList[i].si_area ;
					if(m_si_id == list_si_id ){
						si_options += "<option value='" +  list_si_id + "' selected>"+ list_si_area +"</option>";
					} else{
						si_options += "<option value='" +  list_si_id + "'>"+ list_si_area +"</option>";
					}
					
				}
				$("#si_id").html(si_options);
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
					options+= "<option value='" + data[i].si_id + "' ${ (member.si_id.toString() == '" + data[i].si_id + "')? 'selected' : '' }>" + data[i].si_area + " </option>"
				}
				$("#si_id").html(options);
			},
			error:function(){
				alert("error load si area");
			}
		})
	}
</script>
</head>


<body>
<%-- <sec:authentication property="principal" var="member"/> --%>

<jsp:include page="../common/Category.jsp"></jsp:include>

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
	                            	<form name="updateForm" action="detail" method="post" class="form-horizontal" enctype="multipart/form-data">
										<input hidden name="m_number" value="${member.m_number}">
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		아이디
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input readonly name="m_id"  type="text" value="${member.m_id}" class="form-control" maxlength="20">
											</div>	
										</div>
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
						                   		이름
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input   name="m_name"  type="text" value="${member.m_name}" class="form-control"  required maxlength="20">
											</div>		
										</div>
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											  이메일            		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input name="m_email" type="email" value="${member.m_email}" class="form-control"  required  maxlength="30">
											</div>		
										</div>
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											    핸드폰          		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input   name="m_phone"  type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value="${member.m_phone}" class="form-control"  required   maxlength="20" >
											</div>	

										</div>
										<div class="form-group row">
											<label class="col-sm-4">내 동네</label>
											<div class="col-12 col-sm-3 align-self-center">
												 <select onchange="do_select()" onclick="do_click()" id="do_id" name="do_id" class="form-select"  required>
										    	</select>
											</div>	
											<div class="col-12 col-sm-5 align-self-center">
										  		 <select  id="si_id"  name = "si_id" class="form-select" required>
												</select> 
											</div>
										</div>	
										
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											   프로필 사진
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<img alt="" src="/resources/upload/member/${member.m_pic}"> 
												<!-- <img alt="" src="/resources/upload/member/${member.m_picpath}/${member.m_pic}">   -->
												<!-- <img alt="" src="/resources/upload/member/2023/08/28/e18bd4a1-89bc-47b9-9563-c0f0ad7a0a51_java.png">  -->
											</div>	
										</div>
										<div class="form-group row">
											<div class="col-12 col-sm-4 align-self-center " >
											     		
											</div>
											<div class="col-12 col-sm-5 align-self-center">
												<input type="file" name="uploadFile" multiple="multiple"">
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
	
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>