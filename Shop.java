
import java.util.Arrays;
/**
 * This is the Shop class
 * @author Yogesh, Pareekshith
 *
 */
public class Shop {
	/**
	 * Stores cost of different parts 
	 */
	int[] cost;
	/**
	 * Use this array to keep a track of count of each part needed to be bought from shop
	 * Lets say you need three type 1 "IC"s then your countPartsNeeded[0] should be equal to 3.
	 */
	int[] countPartsNeeded;

	/**
	 * Stores whether shop is open or closed.
	 */
	boolean shopStatus;
	
	
	/**
	 * Constructor to initalise cost array, shopStatus.
	 * @param shopStatus
	 * @param cost
	 */
	public Shop(boolean shopStatus,int[] cost) {
		
		this.cost = cost;
		this.shopStatus = shopStatus;
		this.countPartsNeeded = new int[6];
	}
	
	/**
	 * This function checks if all the parts in the cart are valid.
	 *  
	 * Iterate over the cart array and keep updating countPartsNeeded based on the following conditions
	 * 1)if cart[i] is "IC" and type 1, increment countPartsNeeded[0].
	 * 2)if cart[i] is "IC" and type 2, increment countPartsNeeded[1].
	 * 3)if cart[i] is "MOTOR" and type 1, increment countPartsNeeded[2].
	 * 4)if cart[i] is "MOTOR" and type 2, increment countPartsNeeded[3].
	 * 5)if cart[i] is "PCB" and type 1, increment countPartsNeeded[4].
	 * 6)if cart[i] is "PCB" and type 2, increment countPartsNeeded[5].
	 * 
	 * Note that no element in countPartsNeeded can be greater than 2.
	 * To compare String values use equals() method
	 * Example : to check if str variable is "MOTOR", do str.equals("MOTOR"), this will return a boolean.
	 * @param cart
	 * @return false if shop is closed or if more than two quantities of a part exists in countPartsNeeded
	 */
	public boolean checkcountPartsNeeded(Part[] cart) {
		
		if (this.shopStatus == false) {
			return false;
		}
		
		for(int i=0;i<cart.length;i++){
			Part p = cart[i];
			
			if(p == null)
				break;
			if (p.getName().equals("IC")) {
				
				if (p.getType() == 1) 
					this.countPartsNeeded[0]+= 1;
				else
					this.countPartsNeeded[1]+= 1;
			}
			else if (p.getName()=="MOTOR") {
				if (p.getType() == 1)
					this.countPartsNeeded[2]+= 1;
				else
					this.countPartsNeeded[3]+= 1;
			}
			else if (p.getName().equals("PCB")) {
				if (p.getType() == 1)
					this.countPartsNeeded[4]+= 1;
				else
					this.countPartsNeeded[5]+= 1;
			}
			
		}
		//This piece of code checks if any parts exceeds more than 2.
		if(Arrays.stream(this.countPartsNeeded).max().getAsInt()>2) {
			return false;
		}
		else {
			return true;
		}
		
	}
	/**
	 * This function is used to calculate bill from the shop.
	 * Create a local variable Bill
	 * Iterate over the cart array and keep updating Bill based on the following conditions
	 * 1)if cart[i] is "IC" and type 1, add cost[0] to Bill.
	 * 2)if cart[i] is "IC" and type 2, add cost[1] to Bill.
	 * 3)if cart[i] is "MOTOR" and type 1, add cost[2] to Bill.
	 * 4)if cart[i] is "MOTOR" and type 2, add cost[3] to Bill.
	 * 5)if cart[i] is "PCB" and type 1, add cost[4] to Bill.
	 * 6)if cart[i] is "PCB" and type 2, add cost[5] to Bill.
	 * To compare String values use equals() method
	 * Example : to check if str variable is "MOTOR", do str.equals("MOTOR"), this will return a boolean.
	 * @param cart
	 * @return Bill, that is the total buying cost from shop.
	 */
	public int bill(Part[] cart) {
		
		
		int totalBill=0;
		for(int i=0;i<cart.length;i++){
			Part p = cart[i];
			if(p==null)
				break;
			if (p.getName().equals("IC")) {
				
				if (p.getType() == 1) 
					totalBill+= cost[0];
				else
					totalBill+= cost[1];
			}
			else if (p.getName().equals("MOTOR")) {
				
				if (p.getType() == 1)
					totalBill+= cost[2];
				else
					totalBill+= cost[3];
			}
			else if (p.getName().equals("PCB")) {
				if (p.getType() == 1)
					totalBill+= cost[4];
				else
					totalBill+= cost[5];
			}
			
		}
		//
		return totalBill;
	}
}
