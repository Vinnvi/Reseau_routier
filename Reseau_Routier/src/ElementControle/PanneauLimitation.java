package ElementControle;

import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public class PanneauLimitation implements Semaphore{
	int vitesseMax;
	
	public PanneauLimitation(SegmentRoute s,boolean sens, int vMax){
		vitesseMax = vMax;
		s.addSemaphore(this, sens);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Voiture v) {
		v.setVitesseActuelle(vitesseMax);
		System.out.println("la voiture "+v.getId()+" passe devant le panneau de limitation qui limite à "+vitesseMax+" la route "+v.getSegmentActuel().getName());
	}
}
