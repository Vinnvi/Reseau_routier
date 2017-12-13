package ElementReseau;

import ElementSimulation.Voiture;

/**
 * Barrière indiquant la fin d'une route
 * La voiture s'arrête face à une barrière
 */
public class Barriere extends Jonction{
	private SegmentRoute seg1;
	
	public Barriere()
	{
	}
	public void avancer(Voiture v){
		System.out.println("La voiture "+v.getId()+" a rencontre une barriere");
		v.setEtat(v.getSegmentActuel(),v.getSens(),longueur);
		v.arretVoiture();
	}
	@Override
	public void notifPresence(boolean chSens,Voiture v) {
		// TODO Auto-generated method stub
		
	}
}
