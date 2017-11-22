package ElementReseau;

import java.util.ArrayList;
import java.util.List;

import ElementControle.Capteur;

public class SegmentRoute {
	String name;
	private int longueur;
	private List<Capteur> capteurs = new ArrayList<Capteur>();
	private Jonction jonctionGauche;
	private Jonction jonctionDroite;
	
	public SegmentRoute(int maLongeur,Jonction g,Jonction d, String nom){
		longueur = maLongeur;
		name = nom;
		jonctionGauche = g;
//		g.set
		jonctionDroite = d;
	}
	
	public void setJonctionGauche(Jonction j){
		this.jonctionGauche = j;
		j.addSegmentRoute(this);
	}
	public void setJonctionDroite(Jonction j){
		this.jonctionDroite = j;
		j.addSegmentRoute(this);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
