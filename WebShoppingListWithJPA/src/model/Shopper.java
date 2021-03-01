/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 26, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopper")
public class Shopper {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SHOPPER_ID")
	private int id;
	@Column(name="SHOPPER_NAME")
	private String shopperName;
	
	public Shopper() {
		
		super();
		
	}

	public Shopper(int id, String shopperName) {
		super();
		this.id = id;
		this.shopperName = shopperName;
	}
	
	public Shopper(String shopperName) {
		
		super();
		this.shopperName = shopperName;
		
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
	 * @return the shopperName
	 */
	public String getShopperName() {
		return shopperName;
	}

	/**
	 * @param shopperName the shopperName to set
	 */
	public void setShopperName(String shopperName) {
		this.shopperName = shopperName;
	}

	@Override
	public String toString() {
		return "Shopper [id=" + id + ", shopperName=" + shopperName + "]";
	}

}
