package work;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    response.setContentType("text/html");
	        PrintWriter writer = response.getWriter();
//	        String id = request.getParameter("id");
//	        String name = request.getParameter("name");
//	        try {
	        	System.out.print("print");
	            writer.println("Scooter's servlet");
//	        } finally {
//	            writer.close();
//	        }
	}

}
