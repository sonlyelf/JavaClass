package sport.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sport.service.BookingCourseService;


@WebServlet("/bookingcourse")
public class BookingCourseController extends HttpServlet {
	
		private BookingCourseService bookingCourseService = new BookingCourseService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String deleteID = req.getParameter("deleteID");
			if (deleteID != null) {
				bookingCourseService.deleteBookingCourse(Integer.valueOf(deleteID));
				resp.sendRedirect(req.getContextPath() + "/bookingcourse");
				return;
			}

			
		
		}		

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
		}

}
