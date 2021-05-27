package fixtures;

public class Item extends Fixture
{
	// note: cannot have duplicate items

	public Item(String name, String shortDescription) 
	{
		super(name, shortDescription);
	}

	@Override
	public void describe() 
	{
		System.out.println("1. " + name);
		System.out.println(shortDescription + "\n");
	}
	
}
