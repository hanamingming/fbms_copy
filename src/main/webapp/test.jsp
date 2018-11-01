<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test.jsp</title>
</head>
<body>
	<h1>测试页面  - 显示课程列表</h1>
	<!-- 显示课程列表   el  jstl -->
	<c:forEach items="${list}" var="item">
		<h4>id: ${item.id}  --- title:${item.title} --- description:${item.description }</h4>
	</c:forEach>
	
</body>
</html>