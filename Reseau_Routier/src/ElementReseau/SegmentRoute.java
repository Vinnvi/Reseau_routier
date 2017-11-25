package ElementReseau;

import java.util.ArrayList;
import java.util.List;

import ElementControle.Capteur;
import ElementSimulation.Voiture;

public class SegmentRoute<T extends Jonction,C extends Capteur> {
	String name;
	private int longueur;
	private List<C> capteursSensT = new ArrayList<C>();
	private List<C> capteursSensF = new ArrayList<C>();
	private T jonctionGauche;
	private T jonctionDroite;
	private Voiture state;
	
	public SegmentRoute(int maLongeur,T g,T d, String nom){
		longueur = maLongeur;
		name = nom;
		setJonctionGauche(g);
		setJonctionDroite(d);
	}
	public void setJonctionGauche(T j){
		jonctionGauche = j;
		j.addSegmentRoute(this);
	}
	public void setJonctionDroite(T j){
		jonctionDroite = j;
		j.addSegmentRoute(this);
	}
	public Jonction getJonctionGauche() {
		return jonctionGauche;
	}
	public T getJonctionDroite() {
		return jonctionDroite;
	}
	public int getLongueur(){
		return longueur;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Voiture getState(){
		return state;
	}
	public void setState(Voiture chState){
		state = chState;
		notifyAllCapteurs();
	}
	public void notifyAllCapteurs()
	{
		for(C capteurT : capteursSensT){
			capteurT.update();
		}
		for(C capteurF : capteursSensF){
			capteurF.update();
		}
	}
	public void useCapteur(Voiture v,int posDepart, int posFinal)
	{
		if(v.getSens())
		{
			for(C capteurT : capteursSensT){
				if (posDepart < capteurT.getPosSegment() && capteurT.getPosSegment() <= posFinal)
				{
					capteurT.update(v);
				}
			}
		}
		else
		{
			for(C capteurT : capteursSensT){
				if (posDepart < capteurT.getPosSegment() && capteurT.getPosSegment() <= posFinal)
				{
					capteurT.update(v);
				}
			}
		}
	}
	public void addCapteur(C chCapteur, boolean chSens)
	{
		if(chSens = true)
			capteursSensT.add(chCapteur);
		else
			capteursSensF.add(chCapteur);
	}
	
}
