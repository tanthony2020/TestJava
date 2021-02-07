package q4;

import java.util.ArrayList;

/**
 * Receipt to keep track of items bought
 * @author tammi
 *
 */
public class Receipt {
	private ArrayList<Item> itemList;
	private double totalPrice;

	/**
	 * Constructor that initializes the arraylist and total price to 0
	 */
	public Receipt() {
		itemList = new ArrayList<Item>();
		totalPrice = 0.0;
	}
	/**
	 * Adds item to the receipt
	 * @param item the item purchased
	 * @param price Price of item
	 */
	public void AddToReceipt (Item item, double price)
	{
		itemList.add(item);
		totalPrice += price;		
	}
	/**
	 * Returns the total for the order
	 * @return Total
	 */
	public double getTotal()
	{
		return totalPrice;
	}
	/**
	 * Prints the receipt
	 * @param change How much to return back to the customer
	 * @param total The total cost of the entire bill
	 */
	public void PrintReceipt(double change, double total)
	{
		try
		{
			for(var i=0;i<itemList.size();i++)
			{
				System.out.println(itemList.get(i).name + "\t $" + itemList.get(i).price);
			}
			System.out.println("Total: $\t" + total);
			if (change > 0)
			{
				System.out.println("Your change is: $\t" +round(change, 2));
			}
		}
		catch(IllegalArgumentException ex)
		{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Format the dollar amount to include 2 decimal places if only 1 calculated
	 * @param value number to format
	 * @param places how many decimal places
	 * @return formated decimal to 2 decimal places
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
