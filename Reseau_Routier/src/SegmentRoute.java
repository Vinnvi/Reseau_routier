import java.util.ArrayList;
import java.util.List;

public class SegmentRoute {
	private int longueur;
	private List<Capteur> capteurs = new ArrayList<Capteur>();
	private Jonction jonctionGauche;
	private Jonction jonctionDroite;
	
	public void setJonctionGauche(Jonction j){
		this.jonctionGauche = j;
		
	}
	
	public void setJonctionDroite(Jonction j){
		this.jonctionDroite = j;
	}

	public SegmentRoute(int maLongeur,Jonction g,Jonction d){
		longueur = maLongeur;
		jonctionGauche = g;
		jonctionDroite = d;
	}
	
	public int getLongueur(){
		return longueur;
	}

	public Jonction getJonctionGauche() {
		return jonctionGauche;
	}

	public Jonction getJonctionDroite() {
		return jonctionDroite;
	}
	
	
}
