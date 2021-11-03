package gameplay;
/**
 * Opener is an abstract class that inherit the Pickup class behavior.
 * It contain one constructor that initialize the description
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Opener extends Pickup
{
	/**
	 * Initialize the description
	 * @param description
	 */
	Opener(String description)
	{
		super(description);
	}


}   
