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
		int distanceRestante = vitesseActuelle;
		if(sensActuel){
			if(positionSegment + vitesseActuelle <= segmentActuel.getLongueur())
			{
				positionSegment += vitesseActuelle;
				System.out.println(this.toString());
			}
			else
			{
				//Fin du parcours restant du segment	
				distanceRestante = positionSegment + vitesseActuelle - segmentActuel.getLongueur();
				System.out.println(distanceRestante);
				segmentActuel.getJonctionDroite().avancer(this,distanceRestante);
				//Selection du prochain segment de route
				if(segmentActuel.getJonctionDroite().getSegmentsLies().size() <= 1){ // La jonction n'est liée à aucun autre segment
					System.out.println("Fin de route : la voiture a atteint le bout de la route");
				}
				else{
				SegmentRoute nextSegment=null;
					do{
						int indiceSeg = (int) (Math.random() * (segmentActuel.getJonctionDroite().getSegmentsLies().size()-1) );
						nextSegment = segmentActuel.getJonctionDroite().getSegmentsLies().get(indiceSeg);
					}while(nextSegment == segmentActuel);
					
					
					
					//Positionnement dans le prochain segment /!\ non prise en compte du 1 de la jonction pour le moment
					int distanceAParcourir = vitesseActuelle-(distanceRestante); // Distance a Parcourir sur le nouveau segment
					this.setSegmentActuel(nextSegment);
					this.setPositionSegment(distanceAParcourir);
				}
			}
		}
		else{
			if(positionSegment - vitesseActuelle >= 0)
			{
				positionSegment -= vitesseActuelle;
				System.out.println(this.toString());
			}
			else
			{
				//Fin du parcours restant du segment				
				distanceRestante = vitesseActuelle - positionSegment;
				segmentActuel.getJonctionGauche().avancer(this,distanceRestante);
				
				//Selection du prochain segment de route
				if(segmentActuel.getJonctionGauche().getSegmentsLies().size() <= 1){ // La jonction n'est liée à aucun autre segment
					System.out.println("Fin de route : la voiture a atteint le bout de la route");
				}
				else{
					SegmentRoute nextSegment=null;
					do{
						int indiceSeg = (int) (Math.random() * (segmentActuel.getJonctionGauche().getSegmentsLies().size()) );
						nextSegment = segmentActuel.getJonctionGauche().getSegmentsLies().get(indiceSeg);
					}while(nextSegment == segmentActuel);
					
					
					//Positionnement dans le prochain segment /!\ non prise en compte du 1 de la jonction pour le moment
					int distanceAParcourir = vitesseActuelle-distanceRestante; // Distance a Parcourir sur le nouveau segment
				}
				
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
	public void setPositionSegment(int positionSegment) {
		this.positionSegment = positionSegment;
	}
	public int getVitesse()
	{
		return vitesseActuelle;
	}
	public String toString(){
		return "La voiture "+id+" est a la position "+positionSegment+" du segment "+segmentActuel.getName();
	}
}
