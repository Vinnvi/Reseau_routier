package ElementControle;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

/**
 * Capteur de Presence qui s'occupe uniquement de referencer les passages et d'envoyer cette information
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CapteurPresence extends Capteur
{
	public CapteurPresence(SegmentRoute chSegment, int chPos, boolean chSens,ElementRegulation e)
	{
		this.segment = chSegment;
		posSegment = chPos;
		segment.addCapteur(this, chSens);
		if(chSens)
			jonction = segment.getJonctionDroite();
		else
			jonction = segment.getJonctionGauche();
		this.setE(e);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	public void update(Voiture v) {
		System.out.println("Capteur : La voiture "+v.getId()+" est passe sur le segment "+segment.getName()+" position "+posSegment);
		addPassage();
		if(this.getE()!=null) //a gerer
			this.getE().update(v);
	}
	
	
	

}
