<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.demo.entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>

<style type="text/css">
table {
	border: 2px solid black;
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
}

tr, th, td {
	border: 2px solid black;
	padding: 7px;
	text-align: center;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<%@ include file="header.html"%>
	<h1 style="text-align: center">${title}</h1>
	<table>
		<tr>

			<th>Name</th>
			<th>Email</th>


		</tr>
		<%
		Map<String, String> map = (Map<String, String>) request.getAttribute("map");
		for (Map.Entry<String, String> entry : map.entrySet()) {
		%>
		<tr>
			<td><%=entry.getKey()%></td>
			<td><%=entry.getValue()%></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>
