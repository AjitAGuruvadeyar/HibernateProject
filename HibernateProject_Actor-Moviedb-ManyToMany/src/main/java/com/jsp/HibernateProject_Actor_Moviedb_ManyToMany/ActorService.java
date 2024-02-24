package com.jsp.HibernateProject_Actor_Moviedb_ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ActorService {
	static EntityManager getEntityManager(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ajit");
		EntityManager em = entityManagerFactory.createEntityManager();
		return em;
	}


	public void save(int nextInt, String next, int nextInt2, String next2, String next3, String next4) {
		Actor a=new Actor();
		a.setActorId(nextInt);
		a.setActorName(next);
		a.setActorAge(nextInt2);
		a.setActorAddress(next2);
		a.setIndustry(next3);
		a.setNationality(next4);

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(a); //save

		et.commit();
		em.close();
	}


	public void findActorByName(String actorName) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);

		Root<Actor> actorRoot = cq.from(Actor.class);

		// Use a predicate to filter by actorId
		cq.where(cb.equal(actorRoot.get("actorName"), actorName));

		// Single result, or throw an exception if not found
		Actor actor = em.createQuery(cq).getSingleResult();
		System.out.println(actor);

		et.commit();
		em.close();
	}


	public void findActorAllActorsByIndustry(String industry) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);

		Root<Actor> actorRoot = cq.from(Actor.class);

		cq.where(cb.equal(actorRoot.get("industry"), industry));

		List<Actor> resultList = em.createQuery(cq).getResultList();
		for(Actor l:resultList) {
			System.out.println(l);
		}

		et.commit();
		em.close();

	}


	public void findAllActorsByMovieTital(String movieTital) {
		// TODO Auto-generated method stub

	}


	public void findActorsBetweenAge() {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);

		Root<Actor> actorRoot = cq.from(Actor.class);

		// Create two predicates for age range
		Predicate between = cb.between(actorRoot.get("age"), 35, 65);

		// Combine predicates using logical AND
		cq.where(between);

		// Execute query and return results
		List<Actor> resultList = em.createQuery(cq).getResultList();

		for(Actor l:resultList) {
			System.out.println(l);
		}

		et.commit();
		em.close();
	}
//not working
	public void updateActorAgeByActorId(int actorId,int newAge) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Actor> cu = cb.createCriteriaUpdate(Actor.class);

		Root<Actor> actorRoot = cu.from(Actor.class);

		// Set the update expression to change the "age" attribute
		cu.set(actorRoot.get("actorAge"), newAge);

		// Create a predicate to filter by actorId
		cu.where(cb.equal(actorRoot.get("actorId"), actorId));

		// Execute the update query
		em.createQuery(cu).executeUpdate();
		System.out.println("Actor age updated successfully,,,");

		et.commit();
		em.close();
	}

	// its not all
	public void updateActorIndustryByActorAddress(String actorAddress, String newIndustry) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Actor> cu = cb.createCriteriaUpdate(Actor.class);

		Root<Actor> actorRoot = cu.from(Actor.class);

		cu.set(actorRoot.get("industry"), newIndustry);

		cu.where(cb.equal(actorRoot.get("actorAddress"), actorAddress));

		em.createQuery(cu).executeUpdate();
		System.out.println("Actor industry updated successfully,,,");

		et.commit();
		em.close();

	}


	public void deleteByName(String actorName) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Actor> cd = cb.createCriteriaDelete(Actor.class);

		Root<Actor> root = cd.from(Actor.class);
		cd.where(cb.equal(root.get("actorName"), actorName));
		em.createQuery(cd).executeUpdate();


		System.out.println("Actor deleted successfully,,,");

		et.commit();
		em.close();

	}


	public void deleteAllActorByMovie(String movieName) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Actor> cd = cb.createCriteriaDelete(Actor.class);

        Root<Actor> actorRoot = cd.from(Actor.class);

        // Join with the Movie entity based on your relationship definition
//        Join<Actor, Movie> movieJoin = actorRoot.join("Movie"); // Replace "movies" with actual join name

        // Create a predicate to filter by movie name
//        cd.where(cb.equal(movieJoin.get("movieName"), movieName));

        // Execute the delete query (with caution!)
        em.createQuery(cd).executeUpdate();
		
	}



}
