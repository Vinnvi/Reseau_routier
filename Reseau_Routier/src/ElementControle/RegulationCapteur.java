package ElementControle;

import java.util.ArrayList;

import ElementReseau.Jonction;

public class RegulationCapteur<J extends Jonction, C extends Capteur>
{
	private J jonction;
	private ArrayList<C> listCapteur;
	
	public RegulationCapteur()
	{

		listCapteur = new ArrayList<C>();
	}
}
