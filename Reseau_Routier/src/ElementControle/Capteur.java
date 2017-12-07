package ElementControle;
import java.util.Observable;
import java.util.Observer;

import ElementReseau.Jonction;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public abstract class Capteur<J extends Jonction> implements Semaphore
{
	protected SegmentRoute segment;
	protected boolean nbPassages=false;
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
	
	public void addPassage(){
		if(nbPassages == false){
			nbPassages = true;
		}
		else{
			System.out.println("Attention! Risque de collision : plusieurs voitures sont passees sur le capteur");
		}
	}
	public boolean isNbPassages() {
		return nbPassages;
	}
	public void setNbPassages(boolean nbPassages) {
		this.nbPassages = nbPassages;
	}
	
	
	
	
}
