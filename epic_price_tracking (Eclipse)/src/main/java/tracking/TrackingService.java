package tracking;

import java.util.List;

public class TrackingService {
		TrackingDao dao = new TrackingDao();
	public void addUserTracking(UserGame userGame) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		dao.add(userGame);
	}
	
	public void removeUserTracking(UserGame userGame) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		dao.remove(userGame);
	}
	
	public List<Object> getUserTrackingGames(String userId) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return dao.getMyList(userId);
	}
		
}
