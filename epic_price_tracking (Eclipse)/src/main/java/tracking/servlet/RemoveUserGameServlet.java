package tracking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tracking.TrackingService;
import tracking.UserGame;

public class RemoveUserGameServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TrackingService service = new TrackingService();
			Map<String,String[]> paramMap = req.getParameterMap();
			UserGame form = new UserGame();
			List<String> info = new ArrayList<String>();
			
			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}
			form.setGame_id(info.get(0));
			form.setUser_id(info.get(1));		
			service.removeUserTracking(form);
			resp.setStatus(HttpServletResponse.SC_OK);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
	}
}
