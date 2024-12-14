package publisher.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publisher.domain.Publisher;
import publisher.service.PublisherException;
import publisher.service.PublisherService;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

public class CreateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PublisherService service = new PublisherService();
		Map<String,String[]> paramMap = req.getParameterMap();
		Publisher form = new Publisher();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		form.setPublisherName(info.get(1));

		
		try {
			service.add(form);
			req.setAttribute("message", "publisher "+ form.getPublisherName()+" created successfully!!" );
			req.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(req, resp);
			//response.sendRedirect( request.getContextPath() + "/jsps/user/login.jsp");
		} catch (ClassNotFoundException | PublisherException e) {
			req.setAttribute("message", "Eoor creating publisher" );
			req.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(req, resp);
			e.printStackTrace();
		} catch (InstantiationException e) {
			req.setAttribute("message", "Error creating user "+ form.getPublisherName() );
			req.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(req, resp);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			req.setAttribute("message", "Error creating user "+ form.getPublisherName() );
			req.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(req, resp);
			e.printStackTrace();
		} 
	}
}
