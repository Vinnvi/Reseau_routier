package ElementControle;
import java.util.Observable;
import java.util.Observer;

import ElementReseau.Jonction;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;


/**
 * Implémentation abstraite d'un capteur
 *
 * @param <J>
 * @param <E>
 */
public abstract class Capteur<J extends Jonction,E extends ElementRegulation> implements Semaphore
{
	protected SegmentRoute segment;
	protected boolean nbPassages=false;
	protected int posSegment;
	protected J jonction;
	private E e;
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
		this.e = (E) e;
	}
	/**
	 * Comptabilise les passages pour s'assurer du risque de collision
	 */
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
