package sport.controller;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sport.service.SportClassService;

@WebServlet("/sportclass")
public class SportClassController extends HttpServlet {

	private SportClassService sportClassService = new SportClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 是否有 deleteId 參數帶入 ?
		String deleteId = req.getParameter("deleteId");
		// 如果有 deleteId 參數帶入
		if (deleteId != null) {
			// 刪除課程
			sportClassService.deleteSportClass(Integer.valueOf(deleteId));
			resp.sendRedirect(req.getContextPath() + "/sportclass");
			return;
		}
	
		req.setAttribute("sportClass", sportClassService.getAllSportClass());
		 RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/sportclass.jsp");
	     dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(req.getParameter("sportclass_Id"));
		String name = req.getParameter("sportclass_name");
	    Date startDate = Date.valueOf(req.getParameter("start_date"));
		Date endDate = Date.valueOf(req.getParameter("end_date"));

		sportClassService.addSportClass(id, name, startDate, endDate);
		
		resp.sendRedirect(req.getContextPath() + "/sportclass");
	}
	
	
}
