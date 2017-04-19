package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CommonDAO<E,PK> {

	@PersistenceContext(unitName = "ad-app")
	EntityManager entityManager;
	
	private Class<E> entityClass;
	
	public EntityManager getEntityManager(){
		return entityManager;
	}

	protected CommonDAO(Class<E> entityClass){
		this.entityClass = entityClass;
	}
	
	public E create(E entity){
		getEntityManager().persist(entity);
		return entity;
	}
	
	public E remove(PK id){
		E entity = get(id);
		getEntityManager().remove(entity);
		return entity;
	}
	
	public E get(PK id){
		return getEntityManager().find(entityClass, id);
	}
}
