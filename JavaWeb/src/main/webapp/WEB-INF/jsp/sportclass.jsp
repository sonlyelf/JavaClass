<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>SportClass</title>
		</head>
		<body style="padding: 15px">
		<!-- 新增SportClass -->
		<form class="pure-form" action="/JavaWeb/sportclass" method="post">
		<fieldset>
	
	
				SportClass Id: <input type="number" id="sportclass_Id" name="sportclass_Id" placeholder="請輸入sportClassId" required /><p>
				SportClass Name: <input type="text" id="sportclass_name" name="sportclass_name" placeholder="請輸入SportclassName" required /><p>
		  	Start Date: <input type="date" id="start_date" name="start_date" placeholder="請輸入start-date" required /><p>
		  	End Date: <input type="date" id="end_date" name="end_date" placeholder="請輸入end-date" required /><p>
				<button type="submit" class="pure-button pure-button-primary">新增課程</button>
			</fieldset>
		</form>
		<!-- Room列表 -->
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>SportClass Id</th>
					<th>SportClass Name</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>修改</th>
					<th>刪除</th>
						
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sportClass}" var="sportClass">
					<tr>
						<td>${sportClass.sportclassId}</td>
						<td>${sportClass.sportclassName}</td>
						<td>${sportClass.startDate}</td>
						<td>${sportClass.endDate}</td>
						<td>
							<a href="/JavaWeb/sportclass/update?sportclass_Id=${sportClass.sportclassId}" class="pure-button button-secondary">編輯</a>
						</td>
						<td>
							<a href="/JavaWeb/sportclass?deleteId=${sportClass.sportclassId}" class="pure-button button-error">刪除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
</body>
</html>