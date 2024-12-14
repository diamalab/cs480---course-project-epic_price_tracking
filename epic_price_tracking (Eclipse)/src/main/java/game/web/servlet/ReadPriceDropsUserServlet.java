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

public class ReadPriceDropsUserServlet extends HttpServlet {
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPriceDropsUserServlet() {
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
		// TODO Auto-generated method stub
				GameService gameservice = new GameService();
				Map<String,String[]> paramMap = request.getParameterMap();
				List<String> info = new ArrayList<String>();
				
				for(String name : paramMap.keySet()) {
					
					String[] values = paramMap.get(name);
					info.add(values[0]);
					System.out.println(name + ": " + Arrays.toString(values));
				}
				String userId = info.get(1);
				System.out.println("argument being passed through post:" + userId);
				try {
					request.setAttribute("GameList", gameservice.queryReturnDiscountedPriceGames(userId));
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("/Queryresult/gamelist.jsp").forward(request, response);
		
	}
}
