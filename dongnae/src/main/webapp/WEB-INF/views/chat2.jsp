<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sec:authentication property="principal" var="pr"/>
	<jsp:include page="common/Category.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script type="text/javascript">

	$(document).ready(function(){
		//전송 버튼 누르는 이벤트
		$("#button-send").click(function(e) {
			sendMessage();
			$('#msg').val('')
		});
	})
	
	var buyer_M_Number = ${roomVO.buyer_M_Number};
    var seller_M_Number = ${roomVO.seller_M_Number};
    var g_id = ${roomVO.g_id};
    
	var sock = new SockJS('http://localhost:8080/chatting?g_id='+g_id);
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	sock.onopen = onOpen;
	
	function sendMessage() {
		console.log("Send Message");
	   
		var msg = $("#msg").val();
		
	    
	    console.log("buyer_M_Number: " + buyer_M_Number);
	    console.log("seller_M_Number: " + seller_M_Number);
	    console.log("g_id: " + g_id);
	    
		if(msg != ""){
			 var message = {
			            chat_message: $("#msg").val(),
			            buyer_M_Number: buyer_M_Number,
			            seller_M_Number: seller_M_Number,
			            g_id: g_id
			        };
		}
		console.log(message);
		sock.send(JSON.stringify(message));
		$("#msg").val("");
	}
	//서버에서 메시지를 받았을 때
	function onMessage(msg) {
		
		var data = msg.data;
		var sessionId = null; //데이터를 보낸 사람
		var message = null;
		
		var arr = data.split(":");
		
		for(var i=0; i<arr.length; i++){
			console.log('arr[' + i + ']: ' + arr[i]);
		}
		
		var cur_session = '${userid}'; //현재 세션에 로그인 한 사람
		console.log("cur_session : " + cur_session);
		
		sessionId = arr[0];
		message = arr[1];
		
	    //로그인 한 클라이언트와 타 클라이언트를 분류하기 위함
		if(sessionId == cur_session){
			
			var str = "<div class='col-6'>";
			str += "<div class='alert alert-secondary'>";
			str += "<b>" + sessionId + " : " + message + "</b>";
			str += "</div></div>";
			
			$("#msgArea").append(str);
		}
		else{
			
			var str = "<div class='col-6'>";
			str += "<div class='alert alert-warning'>";
			str += "<b>" + sessionId + " : " + message + "</b>";
			str += "</div></div>";
			
			$("#msgArea").append(str);
		}
		
	}
	//채팅창에서 나갔을 때
	function onClose(evt) {
		
		var user = '${pr.username}';
		var str = user + " 님이 퇴장하셨습니다.";
		
		$("#msgArea").append(str);
	}
	//채팅창에 들어왔을 때
	function onOpen(evt) {
		
		var user = '${pr.username}';
		var str = user + "님이 입장하셨습니다.";
		
		$("#msgArea").append(str);
	}

</script>
	
	<div class="container">
		<div class="col-6">
			<label><b>채팅방 </b></label>
		</div>
		<div>
			<div id="msgArea" class="col">
			</div>
			<div class="col-6">
			<div class="input-group mb-3">
				<input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="button" id="button-send" class="button-send">전송</button>
				</div>
			</div>
			</div>
		</div>
		<div class="col-6">
		</div>
	</div>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>