
package gameplay;
/**
 * Pickup class is the extends of entity class. It contain on constructor that take in String description.
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Pickup extends Entity 
{
	/**
	 * Initialize the description
	 * @param description
	 */
	public Pickup(String description)
	{
		super(description);
	}

}
