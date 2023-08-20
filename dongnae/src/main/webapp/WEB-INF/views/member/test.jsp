<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

</head>


<body>
<form id="myForm">
    <input type="text" required>
    <input type="email" required>
    <input type="submit" value="Submit" onclick="validateForm()">
</form>

<script>
function validateForm() {
    var form = document.getElementById("myForm");
    if (form.checkValidity()) {
        alert("Form is valid. Submitting...");
    } else {
        alert("Form is not valid. Please check your inputs.");
    }
}
</script>


</body>
</html>