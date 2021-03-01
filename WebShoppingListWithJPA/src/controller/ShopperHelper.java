/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 26, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Shopper;

public class ShopperHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
	
	public void insertShopper(Shopper s) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Shopper> showAllShoppers() {
		
		EntityManager em = emfactory.createEntityManager();
		List<Shopper> allShoppers = em.createQuery("SELECT s FROM Shopper s").getResultList();
		return allShoppers;
		
	}
	

}
