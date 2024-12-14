package game.service;

import java.util.List;

import game.dao.GameDao;
import game.domain.Game;


/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class GameService {
	private GameDao gameDao = new GameDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Game form) throws GameException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Game game =gameDao.findById(form.getId());
		if(game.getName()!=null) throw new GameException("This game id has been registered!");
		gameDao.add(form);
	}
	
	
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws GameException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return gameDao.findall();
		
	}
	
	public void updateGame(Game game) throws ClassNotFoundException, InstantiationException, IllegalAccessException, GameException {
		Game existinguser = gameDao.findById(game.getId());
		if(existinguser.getName()==null) throw new GameException("The game is not in the database");
		gameDao.updateGame(game);
	}
	
	public void deleteGame(Game game) throws ClassNotFoundException, InstantiationException, IllegalAccessException, GameException {
		Game existinguser = gameDao.findById(game.getId());
		if(existinguser.getName() == null) throw new GameException("The game is not in the database");
		gameDao.deleteGame(game);
	}
	
	public List<Object> query(String genreId, String publisherID, String sortVariable) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return gameDao.queryGames(genreId, publisherID, sortVariable);
	}
	
	public List<Object> queryReturnDiscountedPriceGames(String userID) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return gameDao.queryReturnDiscountedPriceGames(userID);
	}
}
