package gameplay;
/**
 * Player class is extended class of Character class it contain the instance variables
 * name, confident point, weapon of the player and it can also access to inventory and valuable.
 * It has get and set method for all the instance variables.
 * @author Bonita Ryda 16957717
 *
 */

public class Player extends Character
{
	private int confidenceValue;
	private String name;
	private Wieldable weapon;
	private Inventory inventory;
	private Valuable valuable;
	
	/**
	 * initialize player name, description, health point and confidence value
	 * and set the weapon to FistofFury class.
	 * @param name
	 * @param description
	 * @param healthPoints
	 * @param confidenceValue
	 */
	public Player( String name,String description, int healthPoints, int confidenceValue) 
	{
		super(description, healthPoints);
		this.name = name;
		this.confidenceValue = confidenceValue;
		weapon = new FistsOfFury(); // set weapon to fistof fury class 
	}
	
	/**
	 * it calculate the damage rate for the player when they attack the monster.
	 * @return damage
	 */
	public int dealAttackDamage()
	{
		int damage;
		int strength= weapon.hit();
		damage = strength + strength * this.confidenceValue / 100;
		return damage;
	}
	/**
	 * This constructor will decrease the Player health point and confidence point when the monster attack the Player
	 * @return d
	 */
	
	public int defendAttack(Character enemy)
	{
		int d = enemy.dealAttackDamage();
		super.setHealthPoints(super.getHealthPoints() - d);
		this.confidenceValue -= (d/2);
		return d;
	}
	
	/**
	 * get method for confidenceValue
	 * @return confidenceValue
	 */
	public int getConfidenceValue()
	{
		return confidenceValue;
	}
	
	/**
	 * set method for confidenceValue
	 * @param confidenceValue
	 */
	public void setConfidenceValue(int confidenceValue)
	{
		this.confidenceValue = confidenceValue;
	}
	
	/**
	 * get method for name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * set method for name
	 * 
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * get method for weapon
	 * @return weapon
	 */
	public Wieldable getWeapon() 
	{
		return weapon;
	}

	/**
	 * set method for weapon
	 * 
	 */
	public void setWeapon (Wieldable weapon) 
	{
		this.weapon = weapon;
	}

	/**
	 * get method for inventory
	 * @return inventory
	 */
	public Inventory getInventory() 
	{
		return inventory;
	}

	/**
	 * set method for inventory
	 *
	 */
	public void setInventory(Inventory inventory) 
	{
		this.inventory = inventory;
	}

	/**
	 * initialize valuable to valuable
	 * 
	 */
	public void admire(Valuable valuable) 
	{
		this.valuable = valuable;
		
	}
	/**
	 * get method for valuable
	 * @return valuable
	 */
	public Valuable getValuable() 
	{
		return valuable;
	}
	/**
	 * set method for valuable
	 * @param valuable
	 */
	public void setValuable(Valuable valuable) 
	{
		this.valuable = valuable;
	}
			
}
