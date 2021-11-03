package gameplay;
/**
 * Food is abstract class that extends Consumable class it contain one instanc variable that represent the number of health point.
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Food extends Consumable
{
	private int healthPoints;
	/**
	 * initialize the description and healthPoints
	 * set objectConsumed to false
	 * @param description
	 * @param healthPoints
	 */
	Food(String description, int healthPoints)
	{
		super(description);
		this.setHealthPoints(healthPoints);
		setObjectConsumed(false);
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
}
