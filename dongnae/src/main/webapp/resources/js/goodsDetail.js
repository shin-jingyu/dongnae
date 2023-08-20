/**
 * 
 */
 
  function orderLimit() {
	 alert("고객 전용 서비스입니다.");
	 return false;
 }
 
 
var path = window.location.pathname;

//경로에서 변수 부분 추출
var parts = path.split('/');
var g_id = parts[parts.length - 1];

  

 function refreshTotalLikeCount() {
 		
     const xhr = new XMLHttpRequest();
     
     xhr.onreadystatechange = function () {
         if(xhr.readyState == 4 && xhr.status == 200){
             const response = JSON.parse(xhr.responseText);
             

             const totalLikeCountBox = document.getElementById("totalLikeCount");
             totalLikeCountBox.innerHTML = response.count;
             
         }
     }	
     xhr.open("get", "/restgoods/getTotalLikeProductId?g_id=" + g_id);
     xhr.send();

     
 }

 function toggleLike() {

     const xhr = new XMLHttpRequest();

     xhr.onreadystatechange = function(){
         if(xhr.readyState == 4 && xhr.status == 200){
             const response = JSON.parse(xhr.responseText);
      
             refreshTotalLikeCount();
             refreshMyHeart();
         }
     }

     xhr.open("get", "/shop/product/toggleLike?g_id=" + g_id);
     xhr.send();
 }


 function refreshMyHeart(){
 		
     
     const xhr = new XMLHttpRequest();
     
     xhr.onreadystatechange = function(){
         if(xhr.readyState == 4 && xhr.status == 200){
             const response = JSON.parse(xhr.responseText);
             // js 렌더링... 작업..
             const heartBox = document.getElementById("heartBox");
             
             if(response.checkLikeProductByCustomer){
                 heartBox.classList.remove("bi-heart");
                 heartBox.classList.add("bi-heart-fill");
             }else{
                 heartBox.classList.remove("bi-heart-fill");
                 heartBox.classList.add("bi-heart");
             }
         }
     }

     //get
     xhr.open("get", "/shop/product/checkLikeProductByCustomer?g_id=" + g_id);
     xhr.send();
     
 }


 window.addEventListener("DOMContentLoaded", function(){
     //사실상 시작 시점...
     refreshTotalLikeCount();
     refreshMyHeart();
 });