
public class Voiture 
{
	int id;
	int longueur;
	int vitMax;
	SegmentRoute segmentActuel;
	int positionSegment;
	boolean sensActuel;
	int vitesseActuelle;
	private static int identifiant = 0;
	
	public void voiture(int taille,int vitesseMax){
		this.longueur = taille;
		this.vitMax = vitesseMax;
		this.id = identifiant;
		identifiant++;
	}
	
	public void setEtat(SegmentRoute s,boolean sens,int vitesse,int positionSegment) throws ExceptionVoiture{
		if(vitesse > vitMax){
			throw new ExceptionVoiture();
		}
	}
	
	public void avancer() throws ExceptionVoiture{
		if(sensActuel){
			positionSegment += vitesseActuelle;
			segmentActuel.getJonctionDroite().avancer();
			
		}
		else{
			positionSegment -= vitesseActuelle;
			segmentActuel.getJonctionGauche().avancer();
		}
		
	}

	public SegmentRoute getSegmentActuel() {
		return segmentActuel;
	}

	public void setSegmentActuel(SegmentRoute segmentActuel) {
		this.segmentActuel = segmentActuel;
	}
	
}
