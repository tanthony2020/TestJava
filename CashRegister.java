package q4;

/**
 * Cash Register  
 * @author tammi
 *
 */
public class CashRegister {
	static double total;
	static String scanValue = "done";
	
	
	/**
	 * Programs main
	 * @param args This is input arguments but not used for this application
	 */
	public static void main(String[] args) {
		try
		{
			var gun = new ScanGun();
			System.out.println("Scan UPC or (PAY)");
			gun.getScan();
			scanValue = gun.upc;
			var receipt = new Receipt();
			while(!scanValue.toUpperCase().equals("PAY"))
			{
				try
				{
					// lookup item
					var inventory = new ItemInventory();
					Item item = inventory.GetItem(scanValue);
					
					if (item==null)
					{
						// Item is not found
						System.out.println("Item UPC: " + scanValue + " Not Found. Try again");
						
						System.out.println("Scan UPC or (PAY)");
						gun.getScan();
						scanValue = gun.upc;
						continue;
					}
					// add price to total
					receipt.AddToReceipt(item, item.price);
					// display Item
					System.out.println("********************");
					System.out.println("********************");
					System.out.println("UPC: " + item.upc);
					System.out.println("Product Name: " + item.name);
					System.out.println("Unit Price: $" + item.price);			
					System.out.println("********************");
					System.out.println("********************");
					// ask for next upc
					System.out.println("Scan UPC or (PAY)");
					gun.getScan();
					scanValue = gun.upc;
				}
				catch (Exception e)
				{
					System.out.println("Exception while getting input " + e.getMessage());
					continue;
				}
			}
			double total = Math.round(receipt.getTotal()*100.0)/100.0;
			System.out.println("Your total is: $" + total);
			System.out.println("Enter payment received from customer");
			gun.getScan();
			double change = 0.0;
			try
			{
				double payment = Double.parseDouble(gun.upc);
				
				
				if (payment >= total)
				{
					change = payment - total;
				}
				else
				{
					System.out.println("You do not have enough to cover the order");
					System.out.println("Thank you for shopping with us. Come back again when you have enough funds");
					return;
				}				
			}
			catch(NumberFormatException ne)
			{
				System.out.println("You entered an invalid payment amount");
				System.out.println("Thank you for shopping with us. Come back again when you have enough funds");
				return;
			}
			receipt.PrintReceipt(change, total);
			
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println("You entered an invalid value. Program terminating");
		}
		catch(Exception e)
		{
			System.out.println("Exception " + e.getMessage());
		}
		
	}

}
