package ElementControle;

import ElementReseau.Jonction;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public class ElementRegulationCapteurVitesse <J extends Jonction> implements ElementRegulation{

	@Override
	public void algo(Voiture v) { //But : si la voiture va trop vite :mettre le feu au rouge
		// TODO Auto-generated method stub
		SegmentRoute segmentVoiture = v.getSegmentActuel();
		if(v.getVitesse()>segmentVoiture.getLimit()){//La voiture va trop vite
			System.out.println("La voiture "+v.getId()+" roule trop vite!");
			
			//Changement des feux
			if(v.getSens()){
				Jonction jonction = segmentVoiture.getJonctionDroite();//completer
				
			}
			else{
				Jonction jonction = segmentVoiture.getJonctionGauche();
			}
		}
		else{
			System.out.println("Limitation de vitesse respectée par la voiture "+v.getId());
		}
	}
	
}
