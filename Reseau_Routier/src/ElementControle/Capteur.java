package ElementControle;
import ElementReseau.Jonction;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public abstract class Capteur<J extends Jonction>
{
	protected SegmentRoute segment;
	protected int posSegment;
	protected J jonction;
	public abstract void update();
	public abstract void update(Voiture v);
	public int getPosSegment()
	{
		return posSegment;
	}
}
