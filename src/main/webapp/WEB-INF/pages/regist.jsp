<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<c:url value='/js/jQuery 3.7.0.js' />"></script>
		<title>Regist</title>
	</head>
	
	<body>
		<h1>會員列表</h1>
		<form:form id="registDetail" method="POST"  action="regist">
			<table>
				<tr><td>姓名:</td>
				<td><form:input path="name" value="test"/> </td></tr>
				
				<tr><td>性別:</td>
				<td><form:input path="sex" value="M"/> </td></tr>
				
				<tr><td>帳號:</td>
				<td><form:input path="account" value="test"/> </td></tr>
				
				<tr><td>密碼:</td>
				<td><form:input path="password" value="test"/> </td></tr>
				
				<tr><td>信箱:</td>
				<td><form:input path="email" value="test@gmail.com"/> </td></tr>
				<tr><td><input type="button" value="送出" onclick="regist()"></td>
			</table>
		</form:form>
	</body>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
		})
		function regist(){
			$("#registDetail").attr("action","insert").submit();
		}
	</script>
	
</html>