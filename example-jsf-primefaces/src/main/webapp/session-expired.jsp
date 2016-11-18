<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session expired</title>
</head>
<body>
	<table style="font-size: 14pt;">
		<tr>
			<td>Your session has expired. Please <a
				href="<%=request.getContextPath()%>">reload</a>.
			</td>
		</tr>
	</table>
</body>
</html>