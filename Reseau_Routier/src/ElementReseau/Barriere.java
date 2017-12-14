package ElementReseau;

import ElementSimulation.Voiture;

/**
 * Barriere indiquant la fin d'une route
 * La voiture s'arrete face a une barriere
 */
public class Barriere extends Jonction{
	public Barriere(String name)
	{
		this.setName(name);
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
