/**
 * THE MECHANIC CLASS
 * 
 * @author Yogesh, Pareekshith 
 *
 */
public class Mechanic {

	/**
	 *  An array of Part class which stores all the parts that the mechanic has to repair
	 */
	private Part[] Part;
	/**
	 *  An array of Part class which stores all the parts that the mechanic has to buy
	 */
	private Part[] cart;
	/**
	 * OBject Shop, which is the store/shop of the mechanic 
	 */
	private Shop shop;
	/**
	 * Cost of performing basic analysis is set to 100 units
	 */
	private int costOfBasicAnalysis = 100;
	/**
	 * Cost of advance analysis is set to 400 units
	 */
	private int costOfAdvanceAnalysis = 400;
	/**
	 * Time for which basic analysis runs set to 10 units
	 */
	private int basicAnalysisTime = 10;
	/**
	 * Time for which advance analysis runs set to 10 units
	 */
	private int advanceAnalysisTime = 20;
	/**
	 * Total Fixing Cost the mechanic will charge for his labor
	 */
	private int totalFixingCost=0;
	/**
	 * Total Buy Cost the mechanic will charge for buying new parts
	 */
	int totalShopCost=0;
	/**
	 * Count of parts the mechanic has to buy
	 */
	int numbPartsToBuy=0;
	/**
	 * Shop is open or close
	 */
	boolean shopStatus ;
	
	
	

	
	/**
	 * The constructor for Mechanic Class 
	 * @param p Parts array
	 * @param s Shop Status
	 * @param cost Cost of Parts
	 */
	public Mechanic(Part[] p,boolean s,int[] cost) {
		
		this.Part = p;
		this.cart = new Part[p.length];
		this.shopStatus = s;
		this.shop = new Shop(s,cost);
		
	}
	
	/**
	 * A method to check whether a part can be fixed by just doing a basic analysis of it.
	 * Note that only parts of type 2 can be fixed by basic analysis.
	 * Keep track of the cost to complete basic analysis and add it to the total cost
	 * Hint :
	 * If a part undergoes both basic and advance analysis, after finishing the basic analysis it will directly start the advance process,
	 * so try keeping  a track of time here, that the part undergoes in basic analysis
	 * 
	 * 
	 * Example: 
	 * 	If a part of type 2 has time of 23 units.Considering a basicAnalysisTime of 10 units the remaining 13 units (23-10) will be processed by the advancedAnalysis
	 * 	So remember to add costOfBasicAnalysis to totalFixingCost.
	 * @param p Part
	 * @return It returns a boolean, answering whether a part can be fixed by just basic analysis
	 */
	
	public boolean isPartBasicFixable(Part p) {
		
		if (p.getType()==2) {
			
			if(p.getTime()<= this.basicAnalysisTime) {
				totalFixingCost += costOfBasicAnalysis;
				return true;
			}
			else {
				p.updateTime(this.basicAnalysisTime);
				totalFixingCost += costOfBasicAnalysis;
				return false;
			}
		
		}
		
		return false;
	}
	
	/**
	 * A method to check whether a part can be fixed by just doing a advance analysis of it
	 * add costOfAdvancedAnalysis to totalFixingCost.
	 * @param p Part
	 * @return It returns a boolean, answering whether a part can be fixed by advance analysis
	 */
	public boolean isPartAdvanceFixable(Part p) {
		totalFixingCost += costOfAdvanceAnalysis;
		return (p.getTime() <= advanceAnalysisTime);
		
	}
	
	/**
	 * A method to check whether all the parts can be repaired by just fixing everything and not buying replacements from the shop.
	 * Iterate over the whole Part array and store the parts which needs replacement in the cart array as well.
	 * 
	 * 
	 * Note that a part is not fix-able when both advanced and basic testing fails.
	 * Use the variable numbPartsToBuy if a part cannot be fixed by basic or advance analysis 
	 * Use the cart array to store the defective part (Use numbPartsToBuy as an index)
	 * @return It returns a boolean, answering whether all the parts can be fixed without going to the shop.
	 */
	public boolean isFixable() {
		
		Part currp;
		for(int i =0;i<Part.length;i++) {
			
			currp = Part[i];
			if (!(isPartBasicFixable(currp) || isPartAdvanceFixable(currp))) {
				cart[numbPartsToBuy] = currp;
				numbPartsToBuy += 1;
				
			}
			
	}
	if (numbPartsToBuy == 0) {
		return true;
	}

		return false;
	}
	
	/**
	 * A method to check if spare parts are available in the shop
	 * 
	 * Invokes the checkcountPartsNeeded method of Shop Class.
	 * 
	 * @return It returns a boolean, answering if parts are available in the shop
	 */
	public boolean sparePartsAvail() {
		
		return this.shop.checkcountPartsNeeded(this.cart);
		
	}
	/**
	 * A method to calculate the total money spent on buying new parts
	 * Invokes the bill method of Shop Class.
	 * 	
	 * @return Returns an integer, total money spent on new parts
	 */
	public int totalResourceCost() {

		
		return this.shop.bill(cart);

		
	}
	/**
	 * A method to get the total Labor Cost
	 * 
	 * @return totalFixingCost
	 */
	public int getTotalFixingCost() {
		return totalFixingCost;
	}
	/**
	 * Method to calculate the total expenditure for fixing/buying from shop.
	 * @return Total Expenditure
	 */
	public int totalExpenditure() { 
		return (this.getTotalFixingCost() + this.totalResourceCost());
	}
	
}
