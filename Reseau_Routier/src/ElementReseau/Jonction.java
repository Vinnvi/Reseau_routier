package ElementReseau;

import java.util.ArrayList;

import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public abstract class Jonction {
	protected final int longueur = 1;
	private int idJonction;
	private ArrayList <SegmentRoute>  segmentsLies = new ArrayList<>();
	public abstract void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture;
	
	public void addSegmentRoute(SegmentRoute s){
		segmentsLies.add(s);
	}

	public ArrayList<SegmentRoute> getSegmentsLies() {
		return segmentsLies;
	}

	
	
}
