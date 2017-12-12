package ElementControle;

import java.util.ArrayList;

import ElementReseau.Carrefour;
import ElementSimulation.Voiture;

public abstract class ElementRegulation <S extends Semaphore>{
	Carrefour c;
	ArrayList<S>  s = new ArrayList<>();
	public abstract void algo();
	public void update(Voiture v){};
}
