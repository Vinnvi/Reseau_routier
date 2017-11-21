package ElementReseau;

import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class Barriere extends Jonction{
	private SegmentRoute seg1;
	
	public Barriere()
	{
		
	}
	public void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture{
		System.out.println("La voiture "+v.getId()+" a rencontr� une barri�re");
		v.setEtat(v.getSegmentActuel(),v.getSens(),0,longueur);
	}
}
