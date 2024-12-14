package game.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.domain.Game;
import game.service.GameException;
import game.service.GameService;

public class QueriedGameServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GameService gameservice = new GameService();
		Map<String,String[]> paramMap = req.getParameterMap();
		
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		
		String genreId = info.get(0);
		String publisherId = info.get(1);
		String sortVariable = info.get(2);
		
		try {
			if(sortVariable == null || sortVariable.isEmpty())
			{
				req.setAttribute("GameList", gameservice.query(genreId,publisherId,null));

			}
			
			else
			{
				req.setAttribute("GameList", gameservice.query(null,null,sortVariable));

			}
			
			req.getRequestDispatcher("/Queryresult/gamelist.jsp").forward(req, resp);
			//response.sendRedirect( request.getContextPath() + "/jsps/user/login.jsp");
		}  catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
