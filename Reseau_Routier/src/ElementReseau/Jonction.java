package ElementReseau;

import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public abstract class Jonction {
	protected final int longueur = 1;
	
	public void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture{};
}
