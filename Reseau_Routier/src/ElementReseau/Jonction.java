package ElementReseau;

import java.util.ArrayList;
import java.util.Iterator;

import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public abstract class Jonction {
	protected final int longueur = 1;
	private int idJonction;
	protected ArrayList <SegmentRoute>  segmentsLies = new ArrayList<>();
	
	//utile de mettre distance restante?
	public abstract void avancer(Voiture v) throws ExceptionVoiture;
	public abstract void notifPresence(boolean chSens, Voiture v);
	public void addSegmentRoute(SegmentRoute s){
		segmentsLies.add(s);
	}
	public ArrayList<SegmentRoute> getSegmentsLies() {
		return segmentsLies;
	}
	
	public String toString(){
		String str="";
		Iterator<SegmentRoute> it = segmentsLies.iterator();
		while(it.hasNext()){
			str += it.next().getName();
			str += "\n";
		}
		return str;
		
	}
}
