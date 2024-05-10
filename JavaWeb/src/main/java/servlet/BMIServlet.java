package servlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;



//表單使用
@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet{
	//存放bmi歷史資料
	private  List<Map<String,Object>> bmiList =new CopyOnWriteArrayList();
	
	
	@Override
	protected void doPost(HttpServletRequest req ,HttpServletResponse resp) throws ServletException,IOException{
		//編碼
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		//接收參數
		String userName = req.getParameter("userName");
		String userHeight = req.getParameter("userHeight");
		String userWeight = req.getParameter("userWeight");
		
		
		//計算BMI
		//將user體重與身高由string轉double
		
		double height = Double.parseDouble(userHeight);
		double weight = Double.parseDouble(userWeight);
		double bmi = weight/Math.pow(height/100,2);
		
		
		//將資料儲存到bmiList的集合當中
		Map<String, Object> map = new LinkedHashMap();
		map.put("name",userName);
		map.put("height",userHeight);
		map.put("weight",userWeight);
		map.put("bmi",bmi);
		
		bmiList.add(map);
		
		//回應內容：
		resp.getWriter().print("BMI Result ="+bmi);
	}

	
	

//查詢使用
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//編碼
	req.setCharacterEncoding("utf-8");
	resp.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	
	
	
	
		//回應內容：
		//	resp.getWriter().print(bmiList);
		//含html
	resp.getWriter().print("<html>");
	resp.getWriter().print("<head>");
	resp.getWriter().print("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css\">");
	resp.getWriter().print("<link rel=\"stylesheet\" href=\"./css/buttons.css\">");
	resp.getWriter().print("</head>");
	resp.getWriter().print("<body>");
	resp.getWriter().print("<table border='1'>");
	
	resp.getWriter().print("<thead>");
	resp.getWriter().print("<tr>");
	resp.getWriter().print("<th>Name</th>");
	resp.getWriter().print("<th>Height</th>");
	resp.getWriter().print("<th>Weight</th>");
	resp.getWriter().print("<th>BMI</th>");
	resp.getWriter().print("</tr>");
	resp.getWriter().print("</thead>");
	
	resp.getWriter().print("<tbody>");
	
	bmiList.forEach(map -> {
		try {
			resp.getWriter().print("<tr>");
			resp.getWriter().print("<td>" + map.get("name") + "</td>");
			resp.getWriter().print("<td>" + map.get("height") + "</td>");
			resp.getWriter().print("<td>" + map.get("weight") + "</td>");
			resp.getWriter().print("<td>" + map.get("bmi") + "</td>");
			resp.getWriter().print("</tr>");
		} catch (Exception e) {
			
		}
	});
	
	resp.getWriter().print("</tbody>");
	
	resp.getWriter().print("</table>");
	resp.getWriter().print("<p>");
	resp.getWriter().print("<a href=\"/JavaWeb/bmi.html\" class=\"pure-button button-warning\">回上一頁</a>");
	
	resp.getWriter().print("</body>");
	resp.getWriter().print("</html>");
	
	}

}
