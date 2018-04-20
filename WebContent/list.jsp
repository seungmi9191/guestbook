<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.javaex.vo.GuestVO" %>
    <!-- attribute에 담겨있는 list값 꺼내오기 -> 꺼낸 값을 list에 넣음 -->
    <%
    	List<GuestVO> list = (List<GuestVO>)request.getAttribute("list"); 
    
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/gusetbook/Gb" method="get">
	<br>
	<table border=1 width=500>
		<tr><input type="hidden" name="a" value="add"><br></tr>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" value="확인 "></td>
		</tr>
	</table>
	</form>
	<br/>
	 <%
	 	for(GuestVO vo : list) {
	 %>
	<table width=510 border=1>
		<tr>
			<td><%=vo.getNo()%></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getRegDate() %></td>
			<td><button type="button" onclick="location.href='/gusetbook/Gb?a=deleteform&no=<%=vo.getNo()%>&password=<%=vo.getPassword()%>'">삭제</button></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getContent() %></td>
		</tr>
	</table>
        <br/>
        <%
	 	}
        %>
        <br/>
</body>
</html>