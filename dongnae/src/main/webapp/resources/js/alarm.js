/**
 * 성노빈
 * 
 *
 */
const alarmUL = document.querySelector("#alarmUL");
const alarmI = document.querySelector("#alarmI");
const alarmDiv = document.querySelector("#alarmDiv");
 
 $(document).ready(function(){
 	connectWS();
 });
 
 function connectWS(){
 	var websocket = new SockJS("http://localhost:8080/echo");
 	sock = websocket;
 	
 	websocket.onopen = function(){
 		console.log("연결 굿");
 		websocket.send($('#socketUserId').val());
 	};
 	
 	websocket.onmessage = function(event){
	 	/* 	알람 받기 */
		console.log(event.data);
		if(event.data>0){
			let newAlarm='';
			newAlarm += '<li scope="col"' + event.data + "</li>" 
			$('#alarmUL').append(newAlarm);
			alarmDiv.style.visibility = "visible";
		}
 	};
 	websocket.onclose = function(){
 		console.log('close');
 	};
 };
 
 /* 알람창 추가 */
 alarmI.addEventListener('click', function(){
	alarmUL.classList.toggle('visible');
	$(this).stop(false, false);
});

alarmUL.addEventListener('click', function(e){
	var endIdx = e.target.textContent.indexOf(")");
	var idx = e.target.textContent.substr(1, endIdx-1);

	$.ajax({
		url : '/alarmDel',
		data : {"idx" : idx},
		type : 'post',
		success : function(data){
			console.log(data);
			alert("성공");
		}
	})
	
	$(e.target).remove();
	if(alarmUL.children.length == 0){
		alarmDiv.style.visibility = "hidden";
	}
	
})