package ElementReseau;

import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class Barriere extends Jonction{
	private SegmentRoute seg1;
	
	public Barriere()
	{
	}
	public void avancer(Voiture v) throws ExceptionVoiture{
		System.out.println("La voiture "+v.getId()+" a rencontré une barrière");
		v.setEtat(v.getSegmentActuel(),v.getSens(),0,longueur);
	}
	@Override
	public void notifPresence(boolean chSens) {
		// TODO Auto-generated method stub
		
	}
}
