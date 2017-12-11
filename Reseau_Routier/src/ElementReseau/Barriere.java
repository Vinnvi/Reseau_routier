package ElementReseau;

import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

/**
 * Barri�re indiquant la fin d'une route
 * La voiture s'arr�te face � une barri�re
 */
public class Barriere extends Jonction{
	private SegmentRoute seg1;
	
	public Barriere()
	{
	}
	public void avancer(Voiture v) throws ExceptionVoiture{
		System.out.println("La voiture "+v.getId()+" a rencontre une barriere");
		v.setEtat(v.getSegmentActuel(),v.getSens(),longueur);
		v.arretVoiture();
	}
	@Override
	public void notifPresence(boolean chSens,Voiture v) {
		// TODO Auto-generated method stub
		
	}
}
