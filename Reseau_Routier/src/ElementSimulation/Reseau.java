package ElementSimulation;
import ElementControle.Capteur;
// On met 1 semaphore max par extremite
import ElementControle.CapteurPresence;
import ElementControle.CapteurVitesse;
import ElementControle.ElementRegulation;
import ElementControle.ElementRegulationFeux1;
import ElementControle.Feu;
import ElementControle.FeuBicolore;
import ElementControle.FeuTricolore;
import ElementControle.PanneauLimitation;
import ElementReseau.Barriere;
import ElementReseau.Carrefour;
import ElementReseau.PassagePieton;
import ElementReseau.SegmentRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Reseau <T extends Capteur>
{
	private static Reseau instance = new Reseau();
	private Timer t;
	private static ArrayList<Feu> listFeux;
	private static ArrayList <Capteur> capteurs;
	static ArrayList<Voiture> listVoitures;
	private static ArrayList<ElementRegulation> elements;
	
	private Reseau()
	{
		listFeux = new ArrayList<Feu>();
		capteurs = new ArrayList<>();
		listVoitures = new ArrayList<Voiture>();
		elements = new ArrayList<>();
		
		Barriere B1 = new Barriere("B1");
		Barriere B2 = new Barriere("B2");
		Barriere B3 = new Barriere("B3");
		
		PassagePieton<FeuBicolore> P1 = new PassagePieton(0,"P1");
		PassagePieton<FeuTricolore> P2 = new PassagePieton(1,"P2");
		Carrefour C1 = new Carrefour(3,0,"C1");
		Carrefour C2 = new Carrefour(4, 0,"C2");
		
		SegmentRoute R1 = new SegmentRoute(60,B1,C1,70,"R1");
		SegmentRoute R2 = new SegmentRoute(100,C1,P1,50,"R2");
		SegmentRoute R3 = new SegmentRoute(100,P1,C2,60,"R3");
		SegmentRoute R4 = new SegmentRoute(45,C2,B3,30,"R4");
		SegmentRoute R5 = new SegmentRoute(60,C2,B2,40,"R5");
		SegmentRoute R6 = new SegmentRoute(45,P2,C2,30,"R6");
		SegmentRoute R7 = new SegmentRoute(35,C1,P2,30,"R7");
		P1.addSegmentRoute(R2);
		P1.addSegmentRoute(R3);
		P2.addSegmentRoute(R7);
		P2.addSegmentRoute(R6);
		C1.addSeg(R1,R2,R3);
		C2.addSeg(R3,R4,R5,R6);
		
		ElementRegulationFeux1 e1 = new ElementRegulationFeux1(C1);
		ElementRegulationFeux1 e2 = new ElementRegulationFeux1(C2);	
		
		CapteurPresence captP1 = new CapteurPresence(R1, 42, true,e1);
		CapteurPresence captP2 = new CapteurPresence(R6, 30, true,e2);
		CapteurPresence captP3 = new CapteurPresence(R6, 20, false,e2);
		CapteurVitesse captV1 = new CapteurVitesse(R1, 52, true,e1);
		CapteurVitesse captV2 = new CapteurVitesse(R2, 74, false,e1);
		CapteurVitesse captV3 = new CapteurVitesse(R3, 78, false,e1);
		
		capteurs.add(captP1);
		capteurs.add(captP2);
		capteurs.add(captP3);
		capteurs.add(captV1);
		capteurs.add(captV2);
		capteurs.add(captV3);
		
		@SuppressWarnings("unused")
		PanneauLimitation panneau1 = new PanneauLimitation(R2,true,30);
		
		Voiture v1 = new Voiture(2,65,R1,0,true);
		listVoitures.add(v1);
		
		elements.add(e1);
		elements.add(e2);
	}
	/**
	 * Lancement algorithme avec intervalles de temps
	 * @param list
	 */
	public void lancerSimulation() 
	{
		t = new Timer();
		t.schedule(new Intervalle(listVoitures), 0, 10000);//action / delai / periode
    }
	public static void addFeu(Feu f)
	{
		listFeux.add(f);
	}
	/**
	 * On change la couleur de tous les feux
	 */
	public static void updateFeux()
	{
		for(Feu f : listFeux)
		{
			f.switchColor();
		}
	}
	/**
	 * Lancement des intervalles de temps
	 */
	class Intervalle extends TimerTask 
	{
		int nbRepetitions = 1;
		ArrayList<Voiture> listVoitures;
		public Intervalle(ArrayList<Voiture> list)
		{	
			listVoitures = list;
		}
        @Override
		public void run() 
		{
        	Scanner scan = new Scanner(System.in);
        	String reponse = "y";
			do
			{
				System.out.println("Intervalle numero "+nbRepetitions+" ------------");
				for(Voiture v : listVoitures)
				{
						v.avancer();
				}
				checkElements();
				nbRepetitions++;
				refreshCapteurs();
				System.out.println("Intervalle suivant? tapez 'y' pour oui ou autre pour non");
				reponse = scan.next();
				updateFeux();	
				
		    }while (reponse.equals("y"));
			System.out.println("Termine!" + reponse);
			t.cancel();
			scan.close();
		}
    }
	public static Reseau getInstance(){
	      return instance;
	   }
	/**
	 * La detection de presence est remise a 0
	 */
	public void refreshCapteurs(){
		Iterator<Capteur> i = capteurs.iterator();
		while(i.hasNext()){
			i.next().setNbPassages(false);
		}
	}
	public void checkElements(){
		Iterator<ElementRegulation> it = elements.iterator();
		while(it.hasNext()){
			it.next().algo();
		}
		
 	}
}
