<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제</title>
</head>
<body>
	<form method="post" action="/gusetbook/Gb?a=delete">
	<input type='hidden' name="no" value=<%=request.getParameter("no")%>>
	<input type='hidden' name="password" value=<%=request.getParameter("password")%>> 

	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw_input"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/gusetbook/Gb">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>