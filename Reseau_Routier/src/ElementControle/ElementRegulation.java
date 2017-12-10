package ElementControle;

import ElementReseau.Carrefour;
import ElementSimulation.Voiture;

public abstract class ElementRegulation <S extends Semaphore>{
	Carrefour c;
	S s;
	public abstract void algo();
	public abstract void update(Voiture v);
}
