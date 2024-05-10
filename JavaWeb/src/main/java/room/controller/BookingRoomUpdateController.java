package room.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.service.BookingRoomService;
import room.service.RoomService;

// 進行 BookingRoom 修改
@WebServlet("/bookingroom/update")
public class BookingRoomUpdateController extends HttpServlet {
	
	private BookingRoomService bookingservice = new BookingRoomService();
	private RoomService roomservice = new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 取得 BookingRoom ID
		Integer bookingId = Integer.parseInt(req.getParameter("roomId"));
		
		// 取得 BookingRoom 資料
		String checkinDateStr =String.valueOf( req.getParameter(" checkinDate"));
		// 取得 BookingRoom 資料
		req.setAttribute("bookingroom", bookingservice.getBookingRoom(bookingId));
		req.setAttribute("rooms", roomservice.getRooms());
		req.setAttribute("bookingId", bookingId);
		req.setAttribute("checkinDate", checkinDateStr);
		// 轉發至 BookingRoom 修改頁面
		req.getRequestDispatcher("/WEB-INF/jsp/bookingroom_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 BookingRoom ID
		Integer bookingId = Integer.parseInt(req.getParameter("bookingId"));
		
		// 取得 BookingRoom 名稱
		Integer roomId= Integer.parseInt(req.getParameter("room_id"));
	
		Integer userId = 1;
		String checkinDateString = req.getParameter("checkin_date");
		
	
		// 取得 BookingRoom 資料
		bookingservice.updateBookingRoom( bookingId, roomId,userId, checkinDateString);
		// 重新導向至 bookingRoom 主頁面
		resp.sendRedirect(req.getContextPath() + "/bookingroom");
	}
	
}