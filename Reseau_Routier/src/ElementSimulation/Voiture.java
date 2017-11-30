package ElementSimulation;
import ElementReseau.SegmentRoute;

public class Voiture 
{
	private int id;
	private int longueur;
	private int vitMax;
	private SegmentRoute segmentActuel;
	private int positionSegment;
	private boolean sensActuel;
	private int vitesseActuelle;
	private int distanceRestante = 0;
	private static int identifiant = 0;
	
	public Voiture(int taille,int vitesseMax,SegmentRoute chSegment,int chPosSeg,boolean chSens){
		longueur = taille;
		vitMax = vitesseMax;
		segmentActuel = chSegment;
		vitesseActuelle = getVitLegale();
		sensActuel = chSens;
		id = identifiant;
		positionSegment = chPosSeg;
		identifiant++;
	}
	public void setEtat(SegmentRoute s,boolean sens,int chPos) throws ExceptionVoiture{
		segmentActuel = s;
		sensActuel = sens;
		vitesseActuelle = getVitLegale();;
		positionSegment = chPos;
	}
	
	public void avancer() throws ExceptionVoiture{
		distanceRestante = vitesseActuelle;
		do{
				if(positionSegment + distanceRestante <= segmentActuel.getLongueur())
				{
					segmentActuel.useCapteur(this, positionSegment, positionSegment + distanceRestante );
					positionSegment += distanceRestante;
					distanceRestante = 0;
				}
				else
				{
					//Fin du parcours restant du segment	
					segmentActuel.useCapteur(this, positionSegment,segmentActuel.getLongueur());
					distanceRestante = positionSegment + distanceRestante - segmentActuel.getLongueur();
					positionSegment = segmentActuel.getLongueur();
					if(sensActuel)
						segmentActuel.getJonctionDroite().avancer(this);
					else
						segmentActuel.getJonctionGauche().avancer(this);
					if(vitesseActuelle != 0 && distanceRestante != 0)
					{
						distanceRestante -= 1;
						/*
						if(segmentActuel.getJonctionDroite().getSegmentsLies().size() <= 1){ // La jonction n'est liée à aucun autre segment
							vitesseActuelle = 0;
							System.out.println("Fin de route : la voiture a atteint le bout de la route");
						}
						}*/
					}
				}
		}while(distanceRestante > 0);
		System.out.println(this.toString());
		
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
	public void setPositionSegment(int positionSegment) {
		this.positionSegment = positionSegment;
	}
	public int getVitesse()
	{
		return vitesseActuelle;
	}
	public void setVitesseActuelle(int chVit)
	{
		vitesseActuelle = chVit;
	}
	public int getDistRestante()
	{
		return distanceRestante;
	}
	public void setDistRestante(int chDistRestante)
	{
		distanceRestante = chDistRestante;
	}
	public void arretVoiture()
	{
		vitesseActuelle = 0;
		distanceRestante = 0;
	}
	public int getVitLegale()
	{
		return segmentActuel.getLimit() > vitMax ? vitMax : segmentActuel.getLimit();
	}
	
	
	public String toString(){
		return "La voiture "+id+"("+vitesseActuelle+")"+" est a la position "+positionSegment+" du segment "+segmentActuel.getName()+"("+segmentActuel.getLimit()+")";
	}
}
