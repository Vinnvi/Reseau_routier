package ElementSimulation;
import ElementReseau.SegmentRoute;

/**
 * Implémentation d'une voiture avec ses attributs ainsi que les méthode pour avancer dans le parcours
 */
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
	
	/**
	 * @param taille
	 * @param vitesseMax
	 * @param chSegment
	 * @param chPosSeg
	 * @param chSens
	 */
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

	/**
	 * Place la voiture sur un segmentRoute selon un sens et une position 
	 * @param s
	 * @param sens
	 * @param chPos
	 * @throws ExceptionVoiture
	 */
	public void setEtat(SegmentRoute s,boolean sens,int chPos){
		segmentActuel = s;
		sensActuel = sens;
		vitesseActuelle = getVitLegale();;
		positionSegment = chPos;
	}
	

	/**
	 * Fonction principale de la voiture pour avancer
	 * Comportement de la voiture sur la route, peut appeler les fonctions avancer des jonctions si nécessaire
	 * @throws ExceptionVoiture
	 */
	public void avancer(){
		distanceRestante = vitesseActuelle;
		do{
				if(positionSegment + distanceRestante <= segmentActuel.getLongueur()+1)//on ne traverse pas la jonction
				{
					System.out.println("b");
					segmentActuel.useCapteur(this, positionSegment, positionSegment + distanceRestante );
					positionSegment += distanceRestante;
					distanceRestante = 0;
				}
				else //On a possibilité de traverser jonction
				{
					//Fin du parcours restant du segment	
					segmentActuel.useCapteur(this, positionSegment,segmentActuel.getLongueur());
					distanceRestante = positionSegment + distanceRestante - segmentActuel.getLongueur();
					positionSegment = segmentActuel.getLongueur();
					//On arrive à la Jonction
					if(sensActuel)
						segmentActuel.getJonctionDroite().avancer(this);
					else
						segmentActuel.getJonctionGauche().avancer(this);
					if(vitesseActuelle != 0 && distanceRestante != 0) // On traverse jonction de longueur 1 et on roule encore
						distanceRestante -= 1;
					vitesseActuelle = getVitLegale(); //On respecte nouvelle limitation
					if(distanceRestante > vitesseActuelle) //On ne veut pas aller plus vite que limitation
						distanceRestante = vitesseActuelle;
					
					/*
					if(segmentActuel.getJonctionDroite().getSegmentsLies().size() <= 1){ // La jonction n'est liée à aucun autre segment
						vitesseActuelle = 0;
						System.out.println("Fin de route : la voiture a atteint le bout de la route");
					}*/
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
	public int getPositionSegment() {
		return positionSegment;
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
