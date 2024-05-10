package room.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.eclipse.tags.shaded.org.apache.bcel.verifier.GraphicalVerifier;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//可以自動生成 Pass Code
@WebServlet("/passcode")
public class PassCodeController extends HttpServlet {

	 @Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得驗證碼
		 String passCode =String.format("%04d", new Random().nextInt(10000)); //0000-9999的隨機數
		 System.out.println("驗證碼"+passCode);
		 //將驗證碼放到session中,便於給PassCodeFilter.java使用
		 HttpSession session = req.getSession();
		 session.setAttribute("passCode", passCode);
		
	 try {
		 //取得圖片資訊
		 BufferedImage img = getPassCodeImage(passCode);
		 //輸出圖檔
		ImageIO.write(img, "JPEG", resp.getOutputStream());
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	}
	
    
	//產生4個數字的圖檔（BufferedImage）
	 private BufferedImage getPassCodeImage(String passCode) {

    	 
    	 int w =80; //圖寬
    	 int h = 30;  //圖高
    	 //建立圖像暫存區
    	 BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    	 //建立畫布
    	 Graphics g= img.getGraphics();
		  //設定畫布顏色
		 g.setColor(Color.YELLOW);
		 
		 //塗滿背景
		 g.fillRect(0, 0, w, h);
		
		 //設定畫布文字顏色
		 g.setColor(Color.RED);
		
		 //設定文字字型
		 g.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		 //繪製文字
		 g.drawString(passCode, 10, 25);
		 
		 //加入干擾線
		 g.setColor(Color.GRAY);
		 Random random = new Random();
		 for (int i = 0; i < 10; i++) {
			 int x1 = random.nextInt(w);
			 int y1 = random.nextInt(h);
			 int x2 = random.nextInt(w);
			 int y2 = random.nextInt(h);
			 g.drawLine(x1, y1, x2, y2);
     }
     return img;
     }


}
