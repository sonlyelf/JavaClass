package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/servlet/BMR")
public class BMRServlet  extends HttpServlet {
	
	
	private  List<Map<String,Object>> bmrList =new CopyOnWriteArrayList();
	
	//查詢使用
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//是否有delete參數帶入
		String deleteID= req.getParameter("deleteID");
		if(deleteID !=null) {
			//將deleteID轉成int
			int ID =Integer.parseInt(deleteID);
			//刪除指定ＩＤ位置紀錄
			bmrList.remove(ID);
		}
		
		//處理資料
		//就可以透過setAttribute將bmrListz放到req屬性中的技術
		//將bmrList傳遞給jsp
		req.setAttribute("bmrList",bmrList);
		
		//分派到jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/bmr_list.jsp");
			rd.forward(req, resp);
	
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req ,HttpServletResponse resp) throws ServletException,IOException{
		//編碼
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//接收參數
		String userName = req.getParameter("userName");
		String Gender = req.getParameter("Gender");
		String userAge = req.getParameter("userAge");
		String userHeight = req.getParameter("userHeight");
		String userWeight = req.getParameter("userWeight");
		
		//計算BMR
		
		double height = Double.parseDouble(userHeight);
		double weight = Double.parseDouble(userWeight);
		double age = Double.parseDouble(userAge);
		double BMR =0;
		
	
		
		
	switch (Gender) {
	case "M":
		BMR= 66+(13.7* weight)+(5*height)-(6.8*age);
		break;
	case "F":
	BMR = 655+(9.6*weight)+(1.8*height)-(4.7*age);

		break;
	}
	
	
	
	//將資料儲存到bmrList的集合當中
		Map<String, Object> map = new LinkedHashMap();
			map.put("name",userName);
			map.put("Gender",Gender);
			map.put("age", userAge);
			map.put("height",userHeight);
			map.put("weight",userWeight);
			map.put("bmr",BMR);
			
			bmrList.add(map);
			
		
		resp.getWriter().print("BMR Result ="+ BMR);
	}
	
}

