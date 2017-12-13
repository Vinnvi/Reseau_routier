package ElementControle;
import java.util.Observable;
import java.util.Observer;

import ElementReseau.Jonction;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;


/**
 * Impl�mentation abstraite d'un capteur
 *
 * @param <J>
 * @param <E>
 */
public abstract class Capteur<J extends Jonction,E extends ElementRegulation>
{
	protected SegmentRoute segment;
	protected boolean nbPassages=false;
	protected int posSegment;
	protected J jonction;
	protected E e;
	public abstract void update();
	public abstract void update(Voiture v);
	public int getPosSegment()
	{
		return posSegment;
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
	public E getE() {
		return e;
	}
	public void setE(E e) {
		this.e = e;
	}
	
	
	
	
}
