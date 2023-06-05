<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="<c:url value='/js/jQuery 3.7.0.js' />"></script>
	<title>View Detail</title>
</head>

<body>
	<h1>詳細資料</h1>
	<form:form id="viewDetail" action="view" method="post" modelAttribute="memInfo">
		<form:input path="id" type="hidden" />
		<input name="type" type="hidden" />
		
		<table>
			<tr>
				<td>id</td>
				<td>帳號</td>
				<td>名字</td>
				<td>性別</td>
				<td>Email</td>
			</tr>

			<tr>
				<td>${memInfo.id}</td>
				<td>${memInfo.account}</td>
				<c:choose>
					<c:when test="${type eq 'view'}">
						<td>${memInfo.name}</td>
						<td>${memInfo.sex}</td>
						<td align="center">${memInfo.email}</td>
					</c:when>
					<c:otherwise>
							<td><form:input path="name" /> </td>
							<td><form:input path="sex" /> </td>
							<td align="center"><form:input path="email" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
		
	</form:form>
	<input type="button" value="回上ㄧ頁" onclick="history.back()" />
	<c:choose>
		<c:when test="${type eq 'view'}">
			<input type="button" value="修改" onclick="modifyDetail(${memInfo.id}),'modify'" />
		</c:when>
		<c:otherwise>
			<input type="button" value="確認修改" onclick="update()" />
		</c:otherwise>
	</c:choose>
</body>

<script type="text/javascript">
	$(document).ready(function() {
	
	})
	function modifyDetail(id,type){
		$('input[name="id"]').val(id);
		$('input[name="type"]').val(type);
		$("#viewDetail").submit();
	}
	function update(){
		$("#viewDetail").attr("action","update").submit();
	}
</script>
</html>