package controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import model.Profile;

/**
 * Session Bean implementation class GallerySB
 */
@Stateless
@LocalBean
public class GallerySB {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public GallerySB(){
		entityManagerFactory = Persistence.createEntityManagerFactory("photo_booth_v_0.0.2");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public List<Profile> getTopTen(){
		Query query = entityManager.createQuery("SELECT g FROM Gallery g");
		return query.getResultList();
	}

	@Override
	protected void finalize() throws Throwable {
		entityManagerFactory.close();
		entityManager.close();
		super.finalize();
	}
	
}
