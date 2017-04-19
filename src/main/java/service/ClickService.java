package service;

import javax.inject.Inject;

import dao.ClickDAO;
import entity.Click;

public class ClickService{
	
	@Inject ClickDAO clickDAO;
	
	public Click createClick(Click click){
		return clickDAO.create(click);
	}
}
