package q4;

import java.util.Scanner;
/**
 * The scan gun the cashier will use to get UPC
 * @author tammi
 *
 */
public class ScanGun {
	private Scanner gun;
	/**
	 * Upc scanned
	 */
	public String upc;
	/**
	 * Constructor to turn on gun
	 */
	public ScanGun()
	{
		gun = new Scanner(System.in);
		
	}
	/**
	 * Scan
	 */
	public void getScan()
	{
		upc = gun.nextLine();
	}
	
}
