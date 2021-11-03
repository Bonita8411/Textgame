package gameplay;
/**
 * Consumable class abstact class that extends from Pickup class.
 * it has one boolean instance variable. 
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Consumable extends Pickup
{
	private boolean objectConsumed;
	/**
	 * set the boolean object that has been consumed to false and initialize the description
	 * @param description
	 */
	public Consumable (String description)
	{
		super(description);
		this.setObjectConsumed(false);
	}
	public boolean isObjectConsumed() 
	{
		return objectConsumed;
	}
	public void setObjectConsumed(boolean objectConsumed) 
	{
		this.objectConsumed = objectConsumed;
	}
	
	

	
}
