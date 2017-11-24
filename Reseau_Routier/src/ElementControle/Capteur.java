package ElementControle;
import ElementReseau.SegmentRoute;

public abstract class Capteur 
{
	protected SegmentRoute segment;
	public abstract void update();
}
