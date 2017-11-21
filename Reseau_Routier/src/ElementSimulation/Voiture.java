package ElementSimulation;
import ElementReseau.SegmentRoute;

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
	
	public Voiture(int taille,int vitesseMax,SegmentRoute chSegment,boolean chSens){
		longueur = taille;
		vitMax = vitesseMax;
		vitesseActuelle = vitMax;
		segmentActuel = chSegment;
		sensActuel = chSens;
		id = identifiant;
		identifiant++;
	}
	
	public void setEtat(SegmentRoute s,boolean sens,int vitesse,int positionSegment) throws ExceptionVoiture{
		if(vitesse > vitMax){
			throw new ExceptionVoiture();
		}
	}
	
	public void avancer() throws ExceptionVoiture{
		int distanceRestante = vitesseActuelle;
		if(sensActuel){
			if(positionSegment + vitesseActuelle < segmentActuel.getLongueur())
			{
				positionSegment += vitesseActuelle;
				System.out.println("La voiture "+id+" est a la position "+positionSegment);
			}
			else
			{
				distanceRestante = positionSegment + vitesseActuelle - segmentActuel.getLongueur();
				segmentActuel.getJonctionDroite().avancer(this,distanceRestante);
			}
		}
		else{
			if(positionSegment - vitesseActuelle > 0)
			{
				positionSegment -= vitesseActuelle;
				System.out.println("La voiture "+id+" est a la position "+positionSegment);
			}
			else
			{
				distanceRestante = vitesseActuelle - positionSegment;
				segmentActuel.getJonctionGauche().avancer(this,distanceRestante);
			}
		}
		
	}

	public SegmentRoute getSegmentActuel() {
		return segmentActuel;
	}
	public void setSegmentActuel(SegmentRoute segmentActuel) {
		this.segmentActuel = segmentActuel;
	}
	public boolean getSens()
	{
		return sensActuel;
	}
	public int getId()
	{
		return id;
	}
}
