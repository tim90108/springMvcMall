<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<c:url value='/js/jQuery 3.7.0.js' />"></script>
		<title>MemInfo</title>
	</head>
	
	<body>
	  <h1>Hello World!! MemInfo</h1>
	  <button type="button" id= "getAll">列出全部會員</button>
	</body>
	
	<script type= "text/javascript">
	$(document).ready(function() {
		if ('${message}' != '') {
			alert('${message}')
		}

		$("#getAll").click(function() {
			window.location.href = "<c:url value='/list' />"
		});
	})
	</script>

</html>