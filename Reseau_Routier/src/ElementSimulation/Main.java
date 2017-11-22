package ElementSimulation;
// On met 1 semaphore max par extremite
import javax.swing.text.Segment;

import ElementControle.FeuTricolore;
import ElementReseau.Barriere;
import ElementReseau.JonctionSimple;
import ElementReseau.PassagePieton;
import ElementReseau.SegmentRoute;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main 
{
	Timer t;
	
	public void lancerSimulation(ArrayList<Voiture> list) 
	{
		t = new Timer();
		t.schedule(new Intervalle(list), 0, 10000);//action / delai / periode
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
			while(nbRepetitions > 0)
			{	
				System.out.println("a!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			}
			System.out.println("Termine!");
			t.cancel();
		}
    }
	
	public static void main(String[] args)
	{
		Barriere b1 = new Barriere();
		Barriere b2 = new Barriere();
		FeuTricolore f1 = new FeuTricolore();
		FeuTricolore f2 = new FeuTricolore();
		PassagePieton p1 = new PassagePieton(f1);
		PassagePieton p2 = new PassagePieton(f2);
		SegmentRoute s1 = new SegmentRoute(20,b1,p1,"autoroute A4");
		SegmentRoute s2 = new SegmentRoute(10,p1,p2,"N118");
		
		Voiture v1 = new Voiture(3,4,s1,true);
		ArrayList<Voiture> listVoitures = new ArrayList<Voiture>();
		listVoitures.add(v1);
		
		Main simulation = new Main();
		simulation.lancerSimulation(listVoitures);
		//JonctionSimple j = new JonctionSimple(s1,s2);
	}
}
