package ElementReseau;

import java.util.ArrayList;
import java.util.List;

import ElementControle.Capteur;

public class SegmentRoute<T extends Jonction> {
	String name;
	private int longueur;
	private List<Capteur> capteurs = new ArrayList<Capteur>();
	private T jonctionGauche;
	private T jonctionDroite;
	
	public SegmentRoute(int maLongeur,T g,T d, String nom){
		longueur = maLongeur;
		name = nom;
		setJonctionGauche(g);
		setJonctionGauche(d);
	}
	
	public void setJonctionGauche(T j){
		this.jonctionGauche = j;
		j.addSegmentRoute(this);
	}
	public void setJonctionDroite(T j){
		this.jonctionDroite = j;
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

	
	
}
