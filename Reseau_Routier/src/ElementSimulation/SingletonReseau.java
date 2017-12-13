package ElementSimulation;

public class SingletonReseau 
{
	public static void main(String[] args)
	{
		Reseau object = Reseau.getInstance();
		object.lancerSimulation();
	}
}
