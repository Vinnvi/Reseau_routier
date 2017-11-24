package ElementControle;
import ElementReseau.SegmentRoute;

public class CapteurVitesse extends Capteur
{
	public CapteurVitesse(SegmentRoute chSegment)
	{
		this.segment = chSegment;
	}
	@Override
	public void update() {
		System.out.println("La voiture roule a " + (segment.getState().getVitesse()));
	}
}
