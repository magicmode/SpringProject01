<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<style>
.msg {
	color:red;
}
</style>
</head>
<body>
	<form:form commandName="member" action="../member/join" mtehod="post">
		id: <form:input path="id"/><form:errors path="id" cssClass="msg"/><br>
		name: <form:input path="name"/><form:errors path="name" cssClass="msg"/><br>
		address: <form:input path="address"/><form:errors path="address" cssClass="msg"/><br>
		<input type="submit" value="가입">&nbsp;
		<input type="reset" value="취소">
	</form:form>
</body>
</html>