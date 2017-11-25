package ElementControle;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public abstract class Capteur 
{
	protected SegmentRoute segment;
	protected int posSegment;
	public abstract void update();
	public abstract void update(Voiture v);
	public int getPosSegment()
	{
		return posSegment;
	}
}
