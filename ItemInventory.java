package q4;

import java.util.ArrayList;

/**
 * Inventory for all items 
 * @author tammi
 *
 */
public class ItemInventory {
	private ArrayList<Item> itemInventory = new ArrayList<Item>();
	private ArrayList<Category> categoryArrayList = new ArrayList<Category>();

	/**
	 * Constructor that builds the inventory
	 */
	public ItemInventory()
	{
		Category category = new Category();
		category.name = "Pharmacy";
		categoryArrayList.add(category);

		category = new Category();
		category.name = "Household Supplies";
		categoryArrayList.add(category);

		category = new Category();
		category.name = "Food";
		categoryArrayList.add(category);


		// constructor to create fake hard coded list of items
		Item item = new Item();
		item.name = "Toilet Paper";
		item.price = 2.99;
		item.upc = "123-456-1111";
		item.categoryName = "Household Supplies";
		
		itemInventory.add(item);
		
		
		item = new Item();
		item.name = "Sugar";
		item.price = .99;
		item.upc = "123-456-2222";
		item.categoryName = "Food";
		
		itemInventory.add(item);
		
		item = new Item();
		item.name = "Bottled Water";
		item.price = 4.99;
		item.upc = "123-456-3333";
		item.categoryName = "Food";
		
		itemInventory.add(item);
		
		item = new Item();
		item.name = "Cereal";
		item.price = 2.29;
		item.upc = "123-456-4444";
		item.categoryName = "Food";
		
		itemInventory.add(item);
		
		item = new Item();
		item.name = "Bread";
		item.price = 3.95;
		item.upc = "123-456-5555";
		item.categoryName = "Food";
		
		itemInventory.add(item);

		item = new Item();
		item.name = "Tylenol";
		item.price = 3.95;
		item.upc = "123-456-6666";
		item.categoryName = "Pharmacy";
		
		itemInventory.add(item);
	}
	/**
	 * Get item from inventory
	 * @param upc
	 * @return the item by upc. If item not found returns null
	 */
	public Item GetItem(String upc)
	{
		for (int i=0;i<itemInventory.size();i++)
		{
			if (upc.equals(itemInventory.get(i).upc))
			{
				return itemInventory.get(i);
			}
		}
		return null;
	}
	
}
