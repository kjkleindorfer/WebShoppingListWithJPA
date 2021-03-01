/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 8, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
	
	public ListItemHelper() {
		
	}
	
	/**
	 * Insert an item.
	 * @param li item to insert
	 */
	public void insertItem(ListItem li) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Show all items.
	 * @return all items
	 */
	public List<ListItem> showAllItems() {
		
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery("SELECT i From ListItem i").getResultList();
		return allItems;
		
	}
	
	/**
	 * Deletes an item.
	 * @param toDelete item to be deleted
	 */
	public void deleteItem(ListItem toDelete) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore and li.item = :selectedItem", ListItem.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		ListItem result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * Searches for item by store.
	 * @param storeName name of store
	 * @return item
	 */
	public List<ListItem> searchForItemByStore(String storeName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore", ListItem.class);
		typedQuery.setParameter("selectedStore", storeName);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		
	}

	/**
	 * Searches for item by name of item.
	 * @param itemName name of item
	 * @return item
	 */
	public List<ListItem> searchForItemByItem(String itemName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedItem", ListItem.class);
		typedQuery.setParameter("selectedItem", itemName);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * searches for item by id.
	 * @param idToEdit id
	 * @return item
	 */
	public ListItem searchForItemById(int idToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
		
	}

	/**
	 * Updates item.
	 * @param toEdit item to update
	 */
	public void updateItem(ListItem toEdit) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Closes emfactory.
	 */
	public void cleanUp() {
		
		emfactory.close();
		
	}

}
