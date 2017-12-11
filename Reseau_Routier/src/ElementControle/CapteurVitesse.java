package ElementControle;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

/**
 * Capteur de Vitesse qui envoie comme information la présence des voitures et vitesses
 *
 */
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
		addPassage();
		
	}
	@Override
	public void update(Voiture v) { 
		System.out.println("La voiture roule a " + (v.getVitesse()));
		addPassage();
		this.getE().update(v);
	}
}
