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
	
	public Voiture(int taille,int vitesseMax,SegmentRoute chSegment,boolean chSens){
		longueur = taille;
		vitMax = vitesseMax;
		vitesseActuelle = vitMax;
		segmentActuel = chSegment;
		sensActuel = chSens;
		id = identifiant;
		identifiant++;
	}
	
	public void setEtat(SegmentRoute s,boolean sens,int chVitesse,int chPos) throws ExceptionVoiture{
		if(chVitesse > vitMax){
			throw new ExceptionVoiture("La vitesse de la voiture est trop rapide");
		}
		else
		{
			segmentActuel = s;
			sensActuel = sens;
			vitesseActuelle = chVitesse;
			positionSegment = chPos;
		}
	}
	
	public void avancer() throws ExceptionVoiture{
		distanceRestante = vitesseActuelle;
		do{
			if(sensActuel)
			{
				if(positionSegment + vitesseActuelle <= segmentActuel.getLongueur())
				{
					segmentActuel.useCapteur(this, positionSegment, positionSegment + vitesseActuelle );
					positionSegment += vitesseActuelle;
					distanceRestante = 0;
				}
				else
				{
					//Fin du parcours restant du segment	
					segmentActuel.useCapteur(this, positionSegment,segmentActuel.getLongueur());
					distanceRestante = positionSegment + vitesseActuelle - segmentActuel.getLongueur();
					segmentActuel.getJonctionDroite().avancer(this);
					if(vitesseActuelle != 0 && distanceRestante != 0)
					{
						distanceRestante -= 1;
						/*
						if(segmentActuel.getJonctionDroite().getSegmentsLies().size() <= 1){ // La jonction n'est li�e � aucun autre segment
							vitesseActuelle = 0;
							System.out.println("Fin de route : la voiture a atteint le bout de la route");
						}
						}*/
					}
				}
			}
			else{
				if(positionSegment - vitesseActuelle >= 0)
				{
					segmentActuel.useCapteur(this, positionSegment, positionSegment - vitesseActuelle );
					positionSegment -= vitesseActuelle;
					distanceRestante = 0;
				}
				else
				{
					//Fin du parcours restant du segment		
					segmentActuel.useCapteur(this, positionSegment,0);
					distanceRestante = vitesseActuelle - positionSegment;
					segmentActuel.getJonctionGauche().avancer(this);
					if(vitesseActuelle != 0 && distanceRestante != 0)
					{
						distanceRestante -= 1;
						/*
						if(segmentActuel.getJonctionGauche().getSegmentsLies().size() <= 1){ // La jonction n'est li�e � aucun autre segment
							System.out.println("Fin de route : la voiture a atteint le bout de la route");
						}
						}*/
					}
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
	
	
	public String toString(){
		return "La voiture "+id+" est a la position "+positionSegment+" du segment "+segmentActuel.getName();
	}
}
