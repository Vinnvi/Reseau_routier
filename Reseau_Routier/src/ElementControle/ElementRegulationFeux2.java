package ElementControle;

import ElementReseau.Jonction;
import ElementReseau.PassagePieton;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public class ElementRegulationFeux2 <J extends Jonction> implements ElementRegulation {

	@Override
	public void algo(Voiture v) {
		//First step : recup data
		System.out.println("hello");
		SegmentRoute s = v.getSegmentActuel();
		
		J j;
		if(v.getSens()){
			j = (J) s.getJonctionDroite();
		}
		
		else{
			j = (J) s.getJonctionGauche();
		}
		if(j instanceof PassagePieton){
			
		}
		
	} // Changer les feux en fonction du traffic

}
