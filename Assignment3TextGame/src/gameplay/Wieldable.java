package gameplay;
/**
 * Wieldable class is abstract class that extend from Pickup class. 
 * it have two instance variable high , low. 
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Wieldable extends Pickup
{
	int high , low;
	/**
	 * Initialize to each variable
	 * @param description
	 * @param high
	 * @param low
	 */
	Wieldable (String description, int high, int low)
	{
		super(description);
		this.high = high;
		this.low = low;
	}
	
	/**
	 * Hit method allow to generate random number between high and low
	 * @return
	 */
	public int hit()
	{
		return super.random(high,low);
	}
}
