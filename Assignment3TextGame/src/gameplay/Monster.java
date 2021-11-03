package gameplay;
import java.util.Random;
/**
 * Monster is an abstract class than extends from Character class it have three instance variables 
 * which represent probability of monster appear, the damage rate and the player health point. 
 * @author Bonita Ryda 16957717
 *
 */

public abstract class Monster extends Character
{
	int probMonsterAppear;
	int damageRate;
	Character healthPoints;
	/**
	 * initialize description, health point, probability of monster appear and damage rate
	 * @param description
	 * @param healthPoints
	 * @param probMonsterAppear
	 * @param damageRate
	 */
	public Monster(String description, int healthPoints,
			int probMonsterAppear, int damageRate)
	{
		super(description, healthPoints);
		this.probMonsterAppear = probMonsterAppear;
		this.damageRate = damageRate;
	}
	/**
	 * initialize description
	 * @param description
	 */
	public Monster (String description)
	{
		super(description);
	}
	
	/**
	 * check if monster health point is not equal to 0 it will generate the probability of monster appear
	 * @return
	 */
	public boolean appear()
	{
		int randNum = new Random().nextInt(101 - 0) + 0;
		
		if (healthPoints.getHealthPoints() == 0)
		{
			return false;
		}
		else
		{
			return randNum <= this.probMonsterAppear;
		}
		
	}
	
	@Override
	/**
	 * damage rate for monster
	 * randNum will generate the random number between 1 and 10 and it will return to the random number plus the damage rate.
	 */
	public int dealAttackDamage()
	{
		int randNum = new Random().nextInt(10 - 1) + 1;
		return damageRate + randNum;
	}
	
	/**
	 * this method will decrease the health point by d when the Player attack them
	 */
	public int defendAttack (Character enemy)
	{
		int d = enemy.dealAttackDamage();
		super.setHealthPoints(super.getHealthPoints() - d);
		return d;
	}
	
	
}
