package ElementReseau;

import java.util.ArrayList;
import java.util.Iterator;
import ElementSimulation.Voiture;

/**
 * Jonction abstraite
 * Classe m�re de Carrefour, Barri�re, PassagePi�ton...
 */
public abstract class Jonction {
	protected final int longueur = 1;
	private String name;
	private int idJonction;
	protected ArrayList <SegmentRoute>  segmentsLies = new ArrayList<>();
	
	//utile de mettre distance restante?
	public abstract void avancer(Voiture v);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
