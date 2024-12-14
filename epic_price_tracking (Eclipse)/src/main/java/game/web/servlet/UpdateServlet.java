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
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
				form.setId(info.get(1));
				form.setName(info.get(2));
				form.setThumbnail(info.get(3));
				form.setPrice(info.get(4));
				
				try {
					gameservice.updateGame(form);
					request.setAttribute("message", "Game with id: "+form.getId()+" updated successfully!!" );
					request.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(request, response);
					//response.sendRedirect( request.getContextPath() + "/jsps/user/login.jsp");
				} catch (ClassNotFoundException | GameException e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", "Game with id: "+form.getId()+" not found!!" );
					request.getRequestDispatcher("/Queryresult/MessagePage.jsp").forward(request, response);
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		
	}

}
