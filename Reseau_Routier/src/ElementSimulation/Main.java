package ElementSimulation;
// On met 1 semaphore max par extremite
import ElementControle.CapteurPresence;
import ElementControle.CapteurVitesse;
import ElementControle.ElementRegulationCapteurVitesse;
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
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main 
{
	private Timer t;
	private static ArrayList<Feu> listFeux;
	public void lancerSimulation(ArrayList<Voiture> list) 
	{
		t = new Timer();
		t.schedule(new Intervalle(list), 0, 10000);//action / delai / periode
    }
	public static void addFeu(Feu f)
	{
		listFeux.add(f);
	}
	public static void updateFeux()
	{
		for(Feu f : listFeux)
		{
			f.switchColor();
		}
	}
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
				for(Voiture a : listVoitures)
				{
					try {
						a.avancer();
					} catch (ExceptionVoiture e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				nbRepetitions++;
				System.out.println("Intervalle suivant? tapez 'y' pour oui ou autre pour non");
				reponse = scan.next();
				updateFeux();
						
				
		    }while (reponse.equals("y"));
			System.out.println("Termine!" + reponse);
			t.cancel();
		}
    }
	
	public static void main(String[] args)
	{
		listFeux = new ArrayList<Feu>();
		Barriere B1 = new Barriere();
		Barriere B2 = new Barriere();
		Barriere B3 = new Barriere();
		
		PassagePieton<FeuBicolore> P1 = new PassagePieton(0);
		PassagePieton<FeuTricolore> P2 = new PassagePieton(1);
		Carrefour C1 = new Carrefour(3, 0);
		Carrefour C2 = new Carrefour(4, 0);
		
		SegmentRoute R1 = new SegmentRoute(60,B1,C1,70,"R1");
		SegmentRoute R2 = new SegmentRoute(100,C1,P1,50,"R2");
		SegmentRoute R3 = new SegmentRoute(100,P1,C2,60,"R3");
		SegmentRoute R4 = new SegmentRoute(45,C2,B3,30,"R4");
		SegmentRoute R5 = new SegmentRoute(60,C2,B2,40,"R5");
		SegmentRoute R6 = new SegmentRoute(45,P2,C2,30,"R6");
		SegmentRoute R7 = new SegmentRoute(35,C1,P2,30,"R7");
		ElementRegulationCapteurVitesse elem1 = new ElementRegulationCapteurVitesse();
		P1.addSegmentRoute(R2);
		P1.addSegmentRoute(R3);
		P2.addSegmentRoute(R7);
		P2.addSegmentRoute(R6);
		C1.addSeg(R1,R2,R3);
		C2.addSeg(R3,R4,R5,R6);
		CapteurPresence captP1 = new CapteurPresence(R1, 42, true,elem1);
		CapteurPresence captP2 = new CapteurPresence(R6, 30, true,elem1);
		CapteurPresence captP3 = new CapteurPresence(R6, 20, false,elem1);
		CapteurVitesse captV1 = new CapteurVitesse(R1, 52, true);
		CapteurVitesse captV2 = new CapteurVitesse(R2, 74, false);
		CapteurVitesse captV3 = new CapteurVitesse(R3, 78, false);
		
		PanneauLimitation panneau1 = new PanneauLimitation(R2,true,30);
		
		Voiture v1 = new Voiture(2,65,R1,0,true);
		ArrayList<Voiture> listVoitures = new ArrayList<Voiture>();
		listVoitures.add(v1);
		
		Main simulation = new Main();
		simulation.lancerSimulation(listVoitures);
		//JonctionSimple j = new JonctionSimple(s1,s2);
	}
}
