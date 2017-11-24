package ElementControle;
import ElementReseau.SegmentRoute;

public class CapteurPresence extends Capteur
{
	public CapteurPresence(SegmentRoute chSegment)
	{
		this.segment = chSegment;
	}
	@Override
	public void update() {
		System.out.println("La voiture "+segment.getState().getId()+"est passé");
	}

}
