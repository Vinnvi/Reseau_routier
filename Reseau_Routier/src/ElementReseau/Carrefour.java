package ElementReseau;

import java.util.ArrayList;

import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class Carrefour extends Jonction{
	ArrayList <SegmentRoute> segments = new ArrayList<SegmentRoute>(3);

	public Carrefour(){
		
	}
	
	public SegmentRoute selectionRoute(){
		SegmentRoute selected = null;
		int size = segments.size();
		int randomNum = (int)(Math.random() * (size-1) );		
		selected = segments.get(randomNum);
		return selected;
	}

	@Override
	public void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture {
		// TODO Auto-generated method stub
		
	}
}
