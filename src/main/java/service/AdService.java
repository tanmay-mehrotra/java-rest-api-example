package service;

import javax.inject.Inject;

import dao.AdDAO;
import entity.Ad;

public class AdService {
	
	@Inject AdDAO AdsDAO;
	
	public Ad createAd(Ad ad){
		return AdsDAO.create(ad);
	}
	
	public Ad removeAd(int id){
		return AdsDAO.remove(id);
	}
	
	public Ad getAdAlgorithmically(){
		return AdsDAO.getAdAlgorithmically();
	}
}
