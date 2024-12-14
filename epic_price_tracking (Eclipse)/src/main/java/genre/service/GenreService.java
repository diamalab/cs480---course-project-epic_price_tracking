package genre.service;

import java.util.List;

import genre.dao.GenreDao;
import genre.domain.Genre;


/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class GenreService {
	private GenreDao genreDao = new GenreDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Genre form) throws GenreException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Genre genre =genreDao.findById(form.getId());
		if(genre.getName()!=null) throw new GenreException("This genre id has been registered!");
		genreDao.add(form);
	}
	
	
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws GenreException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return genreDao.findall();
		
	}
	
	public void updateGenre(Genre genre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, GenreException {
		Genre existinguser = genreDao.findById(genre.getId());
		if(existinguser.getName()==null) throw new GenreException("The genre is not in the database");
		genreDao.updateGenre(genre);
	}
	
	public void deleteGenre(Genre genre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, GenreException {
		Genre existinguser = genreDao.findById(genre.getId());
		if(existinguser.getName() == null) throw new GenreException("The genre is not in the database");
		genreDao.deleteGenre(genre);
	}
	
	
}
