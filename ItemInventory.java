package q4;

import java.util.ArrayList;

/**
 * Inventory for all items 
 * @author tammi
 *
 */
public class ItemInventory {
	private ArrayList<Item> itemInventory = new ArrayList<Item>();
	
	/**
	 * Constructor that builds the inventory
	 */
	public ItemInventory()
	{
		// constructor to create fake hard coded list of items
		Item item = new Item();
		item.name = "Toilet Paper";
		item.price = 2.99;
		item.upc = "123-456-1111";
		
		itemInventory.add(item);
		
		
		item = new Item();
		item.name = "Sugar";
		item.price = .99;
		item.upc = "123-456-2222";
		
		itemInventory.add(item);
		
		item = new Item();
		item.name = "Bottled Water";
		item.price = 4.99;
		item.upc = "123-456-3333";
		
		itemInventory.add(item);
		
		item = new Item();
		item.name = "Cereal";
		item.price = 2.29;
		item.upc = "123-456-4444";
		
		itemInventory.add(item);
		
		item = new Item();
		item.name = "Bread";
		item.price = 3.95;
		item.upc = "123-456-5555";
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
