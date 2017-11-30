package ElementControle;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public class CapteurVitesse extends Capteur
{
	public CapteurVitesse(SegmentRoute chSegment, int chPos, boolean chSens)
	{
		this.segment = chSegment;
		posSegment = chPos;
		segment.addCapteur(this, chSens);
		if(chSens)
			jonction = segment.getJonctionDroite();
		else
			jonction = segment.getJonctionGauche();
		
	}
	@Override
	public void update() {
		System.out.println("La voiture roule a " + (segment.getState().getVitesse()));
	}
	@Override
	public void update(Voiture v) {
		System.out.println("La voiture roule a " + (v.getVitesse()));
		
	}
}
