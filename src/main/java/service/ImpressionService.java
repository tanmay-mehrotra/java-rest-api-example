package service;

import javax.inject.Inject;

import dao.ImpressionDAO;
import entity.Impression;

public class ImpressionService {
	
	@Inject ImpressionDAO impressionDAO;
	
	public Impression createImpression(Impression impression){
		return impressionDAO.create(impression);
	}
	
}
