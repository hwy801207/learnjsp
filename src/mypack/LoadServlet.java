package mypack;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadServlet extends HttpServlet {
	
	public void init() throws ServletException {
		Properties ps = new Properties();
		Properties ps_ch = new Properties();
		
		try {
			ServletContext context = getServletContext();
			InputStream in = context.getResourceAsStream("/WEB-INF/messageresource.properties");
			ps.load(in);
			InputStream in_ch = context.getResourceAsStream("/WEB-INF/messageresource_ch.properties");
			ps_ch.load(in_ch);
			
			in.close();
			in_ch.close();
			
			context.setAttribute("ps", ps);
			context.setAttribute("ps_ch", ps_ch);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		init();
		PrintWriter out = resp.getWriter();
		out.println("resource file is loaded");
	}

}
