package ElementReseau;

import java.util.ArrayList;
import java.util.List;

import ElementControle.Capteur;

public class SegmentRoute {
	private int longueur;
	private List<Capteur> capteurs = new ArrayList<Capteur>();
	private Jonction jonctionGauche;
	private Jonction jonctionDroite;
	
	public SegmentRoute(int maLongeur,Jonction g,Jonction d){
		longueur = maLongeur;
		jonctionGauche = g;
		jonctionDroite = d;
	}
	
	public void setJonctionGauche(Jonction j){
		this.jonctionGauche = j;
	}
	public void setJonctionDroite(Jonction j){
		this.jonctionDroite = j;
	}
	public Jonction getJonctionGauche() {
		return jonctionGauche;
	}
	public Jonction getJonctionDroite() {
		return jonctionDroite;
	}
	public int getLongueur(){
		return longueur;
	}

	
	
	
}
