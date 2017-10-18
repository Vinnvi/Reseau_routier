
public class Voiture 
{
	int id;
	int longueur;
	int vitMax;
	SegmentRoute segmentActuel;
	boolean sensActuel;
	int vitesseActuelle;
	private static int identifiant = 0;
	
	public void voiture(int taille,int vitesseMax){
		this.longueur = taille;
		this.vitMax = vitesseMax;
		this.id = identifiant;
		identifiant++;
	}
	
	public void setEtat(SegmentRoute s,boolean sens,int vitesse) throws ExceptionVoiture{
		if(vitesse > vitMax){
			throw new ExceptionVoiture();
		}
	}
}
