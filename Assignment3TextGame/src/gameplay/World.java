package gameplay;
/**
 * 
 * @author Bonita Ryda 16957717
 */

import java.util.Scanner;

public class World 
{
	public enum PlayMode {battle,explore;}
	private Player player;
	private boolean gameInProgress;
	private PlayMode mode;
	private Room room;
	//Wieldable weapon;
	
	/**
	 * get method for player
	 * @return player
	 */
	public Player getPlayer()
	{
		return player;
	}
	/**
	 * set method for player
	 * @param player
	 */
	public void setPlayer(Player player) 
	{
		this.player = player;
	}
	/**
	 * get method for mode
	 * @return mode
	 */
	public PlayMode getMode()
	{
		return mode;
	}
	/**
	 * set method for mode
	 * @param mode
	 */
	public void setMode(PlayMode mode) 
	{
		this.mode = mode;
	}
	/**
	 * get method for room
	 * @return room
	 */
	public Room getRoom() 
	{
		return room;
	}
	/**
	 * set method for room
	 * @param room
	 */
	public void setRoom(Room room) 
	{
		this.room = room;
	}
	
	/**
	 * it set Room to start room
	 * @param startRoom
	 */
	public World(Room startRoom)
	{
		this.setRoom(startRoom);
	}
	/**
	 * set the mode to explore mode
	 */
	private void onEnterRoom() 
	{
		describe();
		this.mode = PlayMode.explore;
	}
	
	//--------------------------------------------------------	
	private void play(Player player)
	{
		this.setPlayer(player);
		System.out.println("Welcome player "+player.getName());

		System.out.println("Health: " + player.getHealthPoints() + " Confidence: " + player.getConfidenceValue() + " Wielding: " + player.getWeapon().getId());
		setGameInProgress(true);
		this.onEnterRoom();
		
		while(isGameInProgress())
		{
			switch(this.mode)
			{
			case explore:
				processExploreUserInput();
				break;
			case battle:
				processBattleUserInput();             
				break;
			}
		}
	}
	/**
	 * contain one instance variable for user input command.
	 * 
	 */
	private void processExploreUserInput() 
	{
		String inputCmd;
		System.out.print(">>");
		Scanner keyboard = new Scanner (System.in);
		inputCmd = keyboard.nextLine();
		String[] tokens = inputCmd.toLowerCase().split(" "); 
		
		switch (tokens[0]) 
		{
		case "help" :
			help ();
			break;
		case "pickup":
			pickup (tokens);
			break;
		case "exit" :
			exit (tokens);
			break;
		case "describe" :
			describe ();
			break;
		case "admire" :
			admire (tokens);
			break; 
		case "eat" :
			eat (tokens);
			break;
		case "mobile" :
			mobile (tokens);
			break;
		case "stats" :
			stats (tokens);
			break;
		case "weild" :
			weild (tokens);
			break;
		case "open" :
			open (tokens);
			break;
		
		}
	}
	
	private void mobile(String[] tokens)
	{
		for (int i=0; i <= this.getRoom().getPickupInRoom().getItems().length; i++)
		{
			if (room.getPickupInRoom().getItems()[i].getId().equalsIgnoreCase(tokens[i]))
			{
				System.out.println("You can used the mobile phone.");
			}
		}
	}

	private void admire(String[] tokens) 
	{
		for (int i=0; i <= this.getRoom().getPickupInRoom().getItems().length; i++)
		{
			Pickup pickup = player.getInventory().select(tokens[i]);
			if (pickup instanceof Valuable)
			{
				Valuable valuable = (Valuable) pickup; 
				this.player.admire(valuable);
			}
		}
	}

	private void stats(String[] tokens) 
	{
		System.out.println("Health Points: "+player.getHealthPoints());
		System.out.println("Confidence Points:" + player.getConfidenceValue());
		System.out.println("Weapon: " + player.getWeapon());
		
	}

	private void weild(String[] tokens) 
	{
		// for loop check inventory
		// if loop
		//print player.wielddescription.
		for (int i=0; i <= this.getRoom().getPickupInRoom().getItems().length; i++)
		{
			if (this.getRoom().getPickupInRoom().select(tokens[i]) != null)
			{
				System.out.println("The player is holding " + player.getWeapon());
			}
		}
	}

	private void open(String[] tokens) 
	{
		     
	}
	
	private void eat(String[] tokens) 
	{
		//confirm if token is in inventory
		boolean confirm = false;
		for(int i = 0 ; i<this.player.getInventory().getItems().length; ++i)
		{
			if(this.player.getInventory().getItems()[i].compareID(tokens[i]))
			{
				confirm = true;
			}
		}
		
		if(confirm)
		{
			//simplify pickup
			Pickup pickup = this.player.getInventory().select(tokens[1]);
			//check if pickup is a food class
			if(pickup instanceof Food)
			{
				//cast pickup to food
				Food food = (Food) pickup;
				//set food to become consumed
				food.setObjectConsumed(true);
				//increase player health points by food health points
				this.player.setHealthPoints(this.player.getHealthPoints()+food.getHealthPoints());
				//remove consumable from my inventory
				this.player.getInventory().remove(tokens[1]);
			}
		}
	}

	private void help( )
	{
		if (this.mode == PlayMode.explore)
		{
		System.out.println("Explore Command: pickup, exit, describe, admire, eat, stats, wield, open, help");
		}
		else if (this.mode == PlayMode.battle)
		{
			System.out.println("Explore Command: attack, wield, fistoffurry, help");
		}
	}

	private void describe() 
	{
		System.out.println(this.getRoom().getDescription());
		
		for (int i=0; i < this.getRoom().getPickupInRoom().getItems().length; i++)
		{
			System.out.println("There is a " + room.getPickupInRoom().getItems()[i].getId()+ " in the room.");
		}
		System.out.println("Number of Doors:  " + room.getConnecting().length);
	}

	private void exit(String[] tokens)
	{
		if (room.isFinalRoom() == true)
		{
			this.setGameInProgress(false);
		}
		else if (room.isFinalRoom() == false)
		{
			this.setGameInProgress(true);
		}
	}
	
	private void pickup(String[] tokens) 
	{
		//for loop to check every item in the room
		for (int i=0; i <= this.getRoom().getPickupInRoom().getItems().length; i++)
		{
			if (room.getPickupInRoom().select(tokens[i]) != null)
			{	
				this.room.getPickupInRoom().remove(tokens[i]) ;
				this.player.getInventory().add(this.room.getPickupInRoom().remove(tokens[i]));
				System.out.println(this.player.getName() + "pick up" + tokens[i]);
			}
		}
		//if statement to check if the item asked for is in the room
		//statments to add it into inventory and remove from room
	}

	private void processBattleUserInput() 
	{
		String inputCmd;
		Scanner keyboard = new Scanner (System.in);
		inputCmd = keyboard.nextLine();
		String[] tokens = inputCmd.toLowerCase().split(""); 
		
		switch (tokens[0]) 
		{
		case "attack" :
			attack(tokens);
			break;
		case "wieldweapon" :
			wieldweapon (tokens);
			break;
		}
	} 

	

	private void wieldweapon(String[] tokens) {
		// TODO Auto-generated method stub
		
	}

	private void attack(String[] tokens) {
		// TODO Auto-generated method stub
		
	}

	//--------------------------------------------------------
	public static void main(String[] args) 
	{
		World world = ReadWorldDataFile.simpleWorld();
		Player playerOne = new Player("Sir Kendric","Shiny Armour",100,50);
		world.play(playerOne);	
		
		//System.out.println("You are alone in a cold room. It is very silent...");
	}
	//--------------------------------------------------------

	public boolean isGameInProgress() {
		return gameInProgress;
	}

	public void setGameInProgress(boolean gameInProgress) {
		this.gameInProgress = gameInProgress;
	}

	



}
