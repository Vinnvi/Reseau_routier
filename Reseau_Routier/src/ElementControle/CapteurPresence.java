package ElementControle;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public class CapteurPresence extends Capteur
{
	public CapteurPresence(SegmentRoute chSegment, int chPos, boolean chSens)
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
		// TODO Auto-generated method stub
		
	}
	public void update(Voiture v) {
		System.out.println("La voiture "+v.getId()+" est passé sur le segment "+segment.getName()+" position "+posSegment);
	}
	
	
	

}
