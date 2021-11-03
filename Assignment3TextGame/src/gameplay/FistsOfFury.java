package gameplay;
/**
 * FistofFury is the class that extend from Wieldable class. It store description, high and low.
 * @author Bonita Ryda 16957717
 *
 */

public class FistsOfFury extends Wieldable
{

	FistsOfFury(String description, int high, int low) 
	{
		super(description, high, low);
	}
	
	FistsOfFury()
	{
		super("FistsOfFury", 20, 5);
	}

}