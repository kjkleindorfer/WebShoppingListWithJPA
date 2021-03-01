import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShopperHelper;
import model.ListDetails;
import model.ListItem;
import model.Shopper;

/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Feb 26, 2021
 */

public class ShoppingTester {

	public static void main(String[] args) {
		
		Shopper susan = new Shopper("Susan");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListItem shampoo = new ListItem("Target", "Shampoo");
		ListItem brush = new ListItem("Target", "Brush");
		
		List<ListItem> susansItems = new ArrayList<ListItem>();
		susansItems.add(shampoo);
		susansItems.add(brush);
		
		ListDetails susansList = new ListDetails("Susan's ShoppingList", LocalDate.now(), susan);
		
		ldh.insertNewListDetails(susansList);
		
		List<ListDetails>  allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}

	}

}
