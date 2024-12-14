package game.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.service.GameException;
import game.service.GameService;
import game.dao.GameDao;
import game.domain.Game;

/**
 * Servlet implementation class UserServlet
 */

public class CreateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String, String> form = new HashMap<String,String>();
				GameService gameservice = new GameService();
				Map<String,String[]> paramMap = request.getParameterMap();
				Game form = new Game();
				List<String> info = new ArrayList<String>();
				
				for(String name : paramMap.keySet()) {
					
					String[] values = paramMap.get(name);
					info.add(values[0]);
					System.out.println(name + ": " + Arrays.toString(values));
				}
				form.setName(info.get(1));
				form.setThumbnail(info.get(2));
				form.setPrice(info.get(3));
				
				try {
					gameservice.add(form);
					request.setAttribute("message", "Game "+ form.getName()+" created successfully!!" );
					request.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(request, response);
					//response.sendRedirect( request.getContextPath() + "/jsps/user/login.jsp");
				} catch (ClassNotFoundException | GameException e) {
					request.setAttribute("message", "Error creating Game "+ form.getName() );
					request.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(request, response);
					e.printStackTrace();
				} catch (InstantiationException e) {
					request.setAttribute("message", "Error creating Game "+ form.getName() );
					request.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(request, response);
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					request.setAttribute("message", "Error creating Game "+ form.getName() );
					request.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(request, response);
					e.printStackTrace();
				} 
		
	}

}
