<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String loginSuccessInfo = (String) session.getAttribute("loginSuccessInfo");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<c:url value='/js/jQuery 3.7.0.js' />"></script>
		<title>Index</title>
	</head>
	
	<body>
		<c:if test="${empty loginSuccessInfo}">
			<button type="button" id= "regist">註冊會員</button><br>
			<button type="button" id= "login">登入會員</button>
			<button type="button" id= "testListener">測試監聽器</button>
		</c:if>
		
		<c:if test="${not empty loginSuccessInfo}">
			<button type="button" id= "logout">登出</button>
		</c:if>
		
		
		
		<c:if test="${memInfo!=null}">
			<br>
			<tr>
				<td>id</td>
				<td>帳號</td>
				<td>名字</td>
				<td>Email</td>
			</tr>
			<br>
			<tr>
				<td>${memInfo.id}</td>
				<td>${memInfo.account}</td>
				<td>${memInfo.name}</td>
				<td>${memInfo.email}</td>
			</tr>
			<br>
		</c:if>
		
		<c:if test="${not empty loginSuccessInfo}">
			<tr>
				<td>帳號2</td>
			</tr>
			<br>
			<tr>
				<td>${loginSuccessInfo}</td>
			</tr>
			<br>
		</c:if>
	</body>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
		})
		
		$("#regist").click(function() {
			window.location.href = "<c:url value='/goRegist' />"
		});
		
		$("#login").click(function() {
			window.location.href = "<c:url value='/goLogin' />"
		});
		
		$("#logout").click(function() {
			window.location.href = "<c:url value='/goLogout' />"
		});
		
		$("#testListener").click(function() {
			window.location.href = "<c:url value='/testListener' />"
		});
		
	</script>
	
</html>