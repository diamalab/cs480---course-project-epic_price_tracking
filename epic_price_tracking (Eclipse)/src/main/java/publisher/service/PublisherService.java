package publisher.service;

import java.util.List;

import publisher.dao.PublisherDao;
import publisher.domain.Publisher;
import user.domain.User;
import user.service.UserException;

public class PublisherService {
	
	private PublisherDao publisherdao = new PublisherDao();
	
	public void add(Publisher form) throws ClassNotFoundException, InstantiationException, IllegalAccessException, PublisherException{
		
		// check the user name
		Publisher publisher = publisherdao.findById(form.getId());
		if(publisher.getPublisherName()!=null) throw new PublisherException("This publisher name has been registered!");
		publisherdao.add(form);
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return publisherdao.findall();
		
	}
	
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, InstantiationException, IllegalAccessException, PublisherException {
		Publisher existingPublisher = publisherdao.findById(publisher.getId());
		if(existingPublisher.getPublisherName()==null) throw new PublisherException("The Publisher  is not in the database");
		publisherdao.updatePublisher(publisher);
	}
	
	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, InstantiationException, IllegalAccessException, PublisherException {
		Publisher exisPublisher = publisherdao.findById(publisher.getId());
		if(exisPublisher.getPublisherName() == null) throw new PublisherException("The publisher is not in the database");
		publisherdao.deletePublisher(publisher);
	}
}
