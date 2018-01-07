package controller;

import java.util.ArrayList;
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
 * Session Bean implementation class ProfileSB
 */
@Stateless
@LocalBean
public class ProfileSB {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ProfileSB() {
		entityManagerFactory = Persistence.createEntityManagerFactory("photo_booth_v_0.0.2");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public List<Profile> getAllProfiles() {
		Query query = entityManager.createQuery("SELECT p FROM Profile p");
		return query.getResultList();
	}

	public Profile getProfileById(int id) {
		Query query = entityManager.createQuery("SELECT p FROM Profile p WHERE p.Id = " + id);
		return (Profile) query.getSingleResult();
	}

	public List<Profile> getProfileByName(String name) {
		Query query = entityManager.createQuery("SELECT p FROM Profile p WHERE p.UserName = " + name);
		return query.getResultList();
	}

	public List<Profile> getTopTen(){
		Query query = entityManager.createQuery("SELECT p FROM Profile p ORDER BY p.Rating LIMIT 10");
		return query.getResultList();
	}
	
	public List<Profile> getProfileByRating(){
		Query query = entityManager.createQuery("SELECT p FROM Profile p ORDER BY p.Rating");
		return query.getResultList();
	}
	
	@Override
	protected void finalize() throws Throwable {
		entityManagerFactory.close();
		entityManager.close();
		super.finalize();
	}
	
}
