package gameplay;
/**
 * Valuable is abstract class that extends from Consumable class.
 * it have one instance variable.
 * @author Bonita Ryda 16957717
 *
 */


public abstract class Valuable extends Consumable
{
	int objValue;
	/**
	 * initialize the  description and objValue
	 * it set the objectConsumed to false
	 * @param description
	 * @param objValue
	 */
	Valuable(String description, int objValue)
	{
		super(description);
		this.objValue = objValue;
		this.setObjectConsumed(false);
	}
}
