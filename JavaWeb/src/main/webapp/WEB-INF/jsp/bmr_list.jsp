<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%	
	//接收來自bmrServlet資料
	List<Map<String,Object>> bmrList =(List)request.getAttribute("bmrList");
%>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
	<meta charset="UTF-8">
	<title>BMR List</title>
	</head>
	
	<body style ="padding:15px">
		
		
		<h2>BMR List</h2>
		<table class="pure-table pure-table border ">
			<thead>
				<tr>
				<th>ID</th><th>Name</th><th>Gender</th>	<th>Age</th><th>Height</th><th>Weight</th><th>BMR</th><th>Delete</th>
				</tr>
			</thead>
			<tbody>
			<%for(int i=0;i<bmrList.size();i++){ %>
		
				<tr>
					<% Map<String, Object> map =bmrList.get(i);%>
					<td><%=i %></td>
					<td><%=map.get("name") %></td>
					<td><%=map.get("Gender") %></td>
					<td><%=map.get("age") %></td>
					<td><%=map.get("height") %></td>
					<td><%=map.get("weight") %></td>
					<td><%=map.get("bmr") %></td>
					<td><a href="/JavaWeb/servlet/BMR?deleteID=<%=i %>" class=" button-error pure-button">Delete</a>
					</tr>
					<% } %>
			</tbody>
		</table>
		<p>
		<a href="/JavaWeb/BMR.html" class="pure-button button-warning">回上一頁</a>
		
	
	</body>
</html>