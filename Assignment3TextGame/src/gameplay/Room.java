package gameplay;
/**
 * 
 * @author Bonita Ryda 16957717
 *
 */

public class Room extends Entity
{
	private Monster monster;
	private Inventory pickupInRoom;
	private boolean finalRoom;
	private Room[] connecting;
	
	/**
	 * initialize the description and set the monster, PickupInroom, final room and connecting room to null
	 * @param description
	 */
	public Room(String description) 
	{
		super(description);
		this.setMonster(null);
		this.setPickupsInRoom(null);
		this.setFinalRoom(false);
		this.setConnectingRooms(null);
	}
	
	/**
	 * initialize description, pickupInRoom and ConnectingRooms
	 * @param description
	 * @param pickupsInRoom
	 * @param connectingRooms
	 */
	public Room(String description,Inventory pickupsInRoom, 
            Room[] connectingRooms) 
	{
		super(description);
		this.setPickupsInRoom(pickupsInRoom);
		this.setConnectingRooms(connectingRooms);
	}
	
	/**
	 * set the Monster, PickupInRoom, final room and connecting room to null.
	 */
	public Room() 
	{
		super(null);
		this.setMonster(null);
		this.setPickupsInRoom(null);
		this.setFinalRoom(false);
		this.setConnectingRooms(null);
	}
	/**
	 * get method for monster
	 * @return monster
	 */
	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster parseMonsterData)
	{
		this.monster = parseMonsterData;
	}
	/**
	 * get method for pickupInroom
	 * @return pickupInRoom
	 */
	public Inventory getPickupInRoom() 
	{
		return pickupInRoom;
	}
	
	/**
	 * set method for PickupInRoom
	 * @param pickups
	 */
	public void setPickupsInRoom(Inventory pickups) 
	{
		this.pickupInRoom = pickups;
		
	}

	/**
	 * get method for finalRoom
	 * @return finalRoom
	 */
	public boolean isFinalRoom() 
	{
		return finalRoom;
	}
	
	/**
	 * set method for finalRoom
	 * @param finalRoom
	 */
	public void setFinalRoom(boolean finalRoom)
	{
		this.finalRoom = finalRoom;
	}
	
	/**
	 * get method for Connecting 
	 * @return connecting
	 */
	public Room[] getConnecting() 
	{
		return connecting;
	}
	/**
	 * set method for connectingRoom
	 * @param connectingRooms
	 */
	public void setConnectingRooms(Room[] connectingRooms) 
	{
		this.connecting = connectingRooms;
	}

	
	
	


}
