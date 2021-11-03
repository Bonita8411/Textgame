package gameplay;
/**
 * This class store the boolean of locked and the instance variable of Pickups.
 * It is extended from Pickup class, all the constructor is setting the value to each variable.
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Openable extends Pickup
{
	boolean locked;
	Pickup contents;
	
	/**
	 * initialize the description
	 * it set the value to contents and locked.
	 * @param description
	 * @param contents
	 * @param locked
	 */
	Openable (String description, Pickup contents,boolean locked)
	{
		super(description);
		this.contents = contents;
		this.locked = locked;
	}
	
	/**
	 * initialize the description
	 * set locked to true
	 * @param description
	 */
	public Openable (String description)
	{
		super(description);
		this.locked = true;
	}
	
	
}
