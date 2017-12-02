package ElementControle;
import ElementReseau.Jonction;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public abstract class Capteur<J extends Jonction> implements Semaphore
{
	protected SegmentRoute segment;
	protected int posSegment;
	protected J jonction;
	private ElementRegulation e;
	public abstract void update();
	public abstract void update(Voiture v);
	public int getPosSegment()
	{
		return posSegment;
	}
	public ElementRegulation getE() {
		return e;
	}
	public void setE(ElementRegulation e) {
		this.e = e;
	}
	
}
