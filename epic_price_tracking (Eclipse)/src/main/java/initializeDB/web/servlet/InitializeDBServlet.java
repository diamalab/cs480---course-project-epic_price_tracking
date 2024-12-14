package initializeDB.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import initializeDB.service.InitializeDBService;

public class InitializeDBServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			InitializeDBService service = new InitializeDBService();
			service.InitializeDB();
			req.setAttribute("message", "Database initialized successfully" );
			req.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(req, resp);
		}catch(Exception e) {
			req.setAttribute("message", "Error while initializing database" );
			req.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(req, resp);
		}

		
	}
	
	

}
