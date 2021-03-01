/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 8, 2021
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="STORE")
	private String store;
	
	@Column(name="ITEM")
	private String item;
	
	public ListItem() {
		
		super();
		
	}
	
	public ListItem(String store, String item) {
		
		super();
		this.store = store;
		this.item = item;
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the store
	 */
	public String getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(String store) {
		this.store = store;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	public String returnItemDetails() {
		
		return store + ": " + item;
		
	}

}
