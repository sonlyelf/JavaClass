package sport.controller;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import sport.service.SportClassService;

@WebServlet("/sportclass/update")
public class SportClassUpdateController extends HttpServlet {
		private SportClassService service = new SportClassService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
			Integer SportClassId = Integer.valueOf(req.getParameter("sportclass_Id"));
			
		   req.setAttribute("sportclass_id", SportClassId);
		   req.setAttribute("sportClass", service.getSportClass(SportClassId));
		   req.getRequestDispatcher("/WEB-INF/jsp/sportclass_update.jsp").forward(req, resp);
		   
		}
		

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			Integer SportClassId = Integer.valueOf(req.getParameter("sportclass_Id"));
			String SportClassName = req.getParameter("sportclass_Name");
			Date startDate = Date.valueOf(req.getParameter("start_date"));
			Date endDate = Date.valueOf(req.getParameter("end_date"));
			
			
			service.updateSportClass(SportClassId, SportClassName, startDate ,endDate ); 
			resp.sendRedirect(req.getContextPath() + "/sportclass");
		}
		
		

}
