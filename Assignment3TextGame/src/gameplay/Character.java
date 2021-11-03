package gameplay;
/**
 * Character is the abstract class that extend from Entity class. 
 * It contain healthPoint 
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Character extends Entity
{
	private int healthPoints;
	/**
	 * initialize description and healthPoints
	 * @param description
	 * @param healthPoints
	 */
	public Character(String description, int healthPoints)
	{
		super(description);
		this.setHealthPoints(healthPoints);
	}
	/**
	 * initialize the description
	 * @param description
	 */
	public Character (String description)
	{
		super(description);
	}
	
	protected abstract int dealAttackDamage();
	public abstract int defendAttack(Character enemy);
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	} 
}
