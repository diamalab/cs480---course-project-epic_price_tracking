package game.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import genre.service.GenreService;
import publisher.service.PublisherService;

public class FindGenrePublisherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GenreService genreservice = new GenreService();
		PublisherService publisherservice= new PublisherService();
		
		try {
			req.setAttribute("GenreList", genreservice.findall());
			req.setAttribute("publisherList", publisherservice.findall());
			
			
			req.getRequestDispatcher("/jsps/pubGenreSelector.jsp").forward(req, resp);
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
