package dao;

import entity.Impression;

public class ImpressionDAO extends CommonDAO<Impression, Integer> {
	
	public ImpressionDAO(){
		super(Impression.class);
	}	
}