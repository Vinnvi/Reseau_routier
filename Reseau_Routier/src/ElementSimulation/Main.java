package ElementSimulation;
// On met 1 semaphore max par extremite
import ElementControle.CapteurPresence;
import ElementControle.Feu;
import ElementControle.FeuBicolore;
import ElementControle.FeuTricolore;
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
				System.out.println("Intervalle numéro "+nbRepetitions+" ------------");
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
		Barriere b1 = new Barriere();
		Barriere b2 = new Barriere();
		Barriere b3 = new Barriere();
		Barriere b4 = new Barriere();
		
		PassagePieton<FeuBicolore> p1 = new PassagePieton(0);
		PassagePieton<FeuTricolore> p2 = new PassagePieton(1);
		Carrefour c = new Carrefour(3, 0);
		
		SegmentRoute s1 = new SegmentRoute(20,b1,p1,"autoroute A4");
		SegmentRoute s2 = new SegmentRoute(10,p1,c,"N118");
		SegmentRoute s3 = new SegmentRoute(15,c,b3,"autoroute A6");
		SegmentRoute s4 = new SegmentRoute(12,c,b4,"Route 66");
		
		CapteurPresence capt1 = new CapteurPresence(s1, 9, true);
		
		Voiture v1 = new Voiture(3,4,s1,true);
		ArrayList<Voiture> listVoitures = new ArrayList<Voiture>();
		listVoitures.add(v1);
		
		Main simulation = new Main();
		simulation.lancerSimulation(listVoitures);
		//JonctionSimple j = new JonctionSimple(s1,s2);
	}
}
