package ElementControle;

import ElementSimulation.Voiture;

public abstract class Semaphore <E extends ElementRegulation> {
	protected E elem;
	public abstract void update();
	public abstract void update(Voiture v);
	public E getElem() {
		return elem;
	}
	public void setElem(E elem) {
		this.elem = elem;
	}
	
}
