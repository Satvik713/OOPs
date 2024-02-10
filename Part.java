/**
 * This is the class Part
 * @author Yogesh, Pareekshith
 *
 */
public class Part {
	/**
	 * String which stores name of the part.
	 */
	String name;
	/**
	 * int to store the type of the part.
	 */
	private int type;
	/**
	 * Time taken to process the part
	 */
	private int time;
	
	/**
	 * Constructor to initialise Part
	 * @param name
	 * @param type
	 * @param time
	 */
	public Part(String name,int type,int time)
	{
		this.name=name;
		this.type=type;
		this.time=time;
	}

	/**
	 * getter function to get time.
	 * @return remaining processing time (time).
	 */
	public int getTime() {
		return this.time;
	}
	
	/**
	 * getter function to get the type
	 * @return type of the part
	 */
	public int getType() {
		return this.type;
	}
	
	/**
	 * A function to update remaining processing time of the part
	 * This is used in isPartBasicFixable to update remaining time when part cannot be completed using only basic analysis (Refer to isPartBasicFixable for example)
	 * @param t
	 */
	public void updateTime(int t) {
		this.time -= t;
	}
	
	/**
	 * getter for name of Part
	 * @return name of part
	 */
	public String getName() {
		return this.name;
	}
	
	

}
