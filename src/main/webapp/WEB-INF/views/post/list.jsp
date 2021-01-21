<%@page import="com.cos.springboot.domain.post.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>list.jsp페이지</h1>
<hr />
<table>
	<tr>
		<th>id</th>
		<th>제목</th>
		<th>내용</th>
		<th>조회수</th>
	</tr>
<%
	List<Post> posts = (List<Post>)request.getAttribute("posts");
	System.out.println(request.getAttribute("posts"));
%>

	<c:forEach var="post" items="${posts}">
	<tr>
		<td>${post.id }</td>
		<td>${post.title}</td>
		<td>${post.content}</td>
		<td>${post.readCount}</td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>