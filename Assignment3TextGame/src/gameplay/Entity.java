package gameplay;
/**
 * Entity class contain the two instance variable which is description and id.
 * It is the hierarchy class. It have constructor that set the value of each instance variable.
 */

import java.util.Random;

public abstract class Entity 
{
	private String description;
	private String id;
	/**
	 * 
	 * @param description
	 */
	public Entity (String description)
	{
		this.id= this.getClass().getSimpleName();
	}
	/**
	 * get method for description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * set method for description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * get method for id
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * set method for id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	} 
	
	/**
	 * This random method allow to generate the random number between the max and min number
	 * @param max
	 * @param min
	 * @return
	 */
	protected int random(int max , int min)
	{
		return new Random().nextInt(max -min)+min;
	}
	/**
	 * this compareID method allow to compare the entity id equality given string but ingoring the case.
	 * @param id
	 * @return
	 */
	public boolean compareID(String id)
	{
		boolean temp;
		temp = id.equalsIgnoreCase(this.id);
		return temp;
	}
}



