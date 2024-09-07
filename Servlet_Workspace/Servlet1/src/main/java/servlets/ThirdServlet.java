package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get from third servlet");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = req.getParameter("message");
		System.out.println("Got the post request : "+message);
		
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.print("<h1>Form Submitted Successfully</h1>");
		writer.print("""
				<h1>The String is : %s</h1>
				""".formatted(message));
		
		resp.setStatus(404);

		
	}

}
