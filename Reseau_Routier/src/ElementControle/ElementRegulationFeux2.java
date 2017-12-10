package ElementControle;

import java.util.Iterator;

import ElementReseau.Jonction;
import ElementReseau.PassagePieton;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public class ElementRegulationFeux2 <J extends Jonction> extends ElementRegulation {

	@Override
	public void algo() {
		//First step : recup data
		Iterator<Feu> it = c.getFeux().iterator();
		int index = 0;
		while(it.hasNext()) {
			
		}
		
	} // Changer les feux en fonction du traffic

	@Override
	public void update(Voiture v) {
		// TODO Auto-generated method stub
		
	}

}
