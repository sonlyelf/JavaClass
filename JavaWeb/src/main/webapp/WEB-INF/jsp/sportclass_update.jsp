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
<title>sportclass_update</title>
</head>
<body style="padding: 15px">
<!-- sportclass -->
		<form class="pure-form" action="/JavaWeb/sportclass/update" method="post">
			<fieldset>
				<legend>Sportclass Update</legend>
				Sportclass Id: <input type="number" id="sportclass_Id" name="sportclass_Id" value="${sportclass_id}" readonly /><p>
				Sportclass Name: <input type="text" id="sportclass_Name" name="sportclass_Name" value="${ Sportclass.sportclassName }" placeholder="請輸入Sportclass Name" required /><p>
				Start Date: <input type="date" id="start_date" name="start_date" value="${ Sportclass.start_date }" placeholder="請輸入start-date" required /><p>
		  	End Date: <input type="date" id="end_date" name="end_date"value="${ Sportclass.end_date}"  placeholder="請輸入end-date" required /><p>
				<button type="submit" class="pure-button pure-button-primary">修改</button>
	
			</fieldset>
		</form>

</body>
</html>