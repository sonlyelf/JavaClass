
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		
		<meta charset="UTF-8">
		<title>BookingRoom Update</title>
	</head>
	<body style="padding: 15px">
		<!-- 修改Room -->
		<form class="pure-form" action="/JavaWeb/bookingroom/update" method="post">
			<fieldset>
				<legend>Room Update</legend>
				
				BookingRoom Id: <input type="text" id="bookingId" name="bookingId" value="${ bookingId }" readonly /><p>
				
				Room Name: <select id="room_id" name="room_id" >
				
							<c:forEach items="${ rooms }" var="room" >
								<option value="${room.roomId}" >${room.roomName}</option>
							</c:forEach>
							
							<option value="${bookingroom.roomId}" selected >${bookingroom.roomId}</option>
						  
						   </select><p>
						   
						   
				Check In: <input type="date" id="checkin_date" name="checkin_date" /><p>
				<button type="submit" class="pure-button pure-button-primary">修改</button>
			</fieldset>
		</form>
		
		
	</body>
</html>

