package ElementReseau;

import java.util.ArrayList;

import ElementControle.Feu;
import ElementControle.FeuBicolore;
import ElementControle.FeuTricolore;
import ElementControle.Tricolor;
import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class Carrefour<T extends Feu> extends Jonction{
	
	ArrayList <T> feux = new ArrayList<T>(); 
	
	public Carrefour(int nbRoutesConnectes,int typeFeu){
		for(int i=0;i<nbRoutesConnectes;i++){
			if(typeFeu == 1){
				feux.add((T) new FeuBicolore());
				feux.get(i).setCouleur(Tricolor.Rouge);
			}
			else{
				feux.add((T) new FeuTricolore());
				feux.get(i).setCouleur(Tricolor.Rouge);
			}
		}
		int nbAlea = (int) (Math.random() * (nbRoutesConnectes));
		feux.get(nbAlea).setCouleur(Tricolor.Rouge);
	}

	@Override
	public void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture {
		//Check color feu
		System.out.println("aaa");
		int i=0;
		for(i=0;i<this.getSegmentsLies().size();i++){
			if(this.getSegmentsLies().get(i)==v.getSegmentActuel()){
				break;
			}
		}
		
		if(feux.get(i).getCouleur() == Tricolor.Vert)
		{
			System.out.println("La voiture traverse le passage");
			v.setEtat(segmentsLies.get(1), v.getSens(), v.getVitesse(), 0);
		}
		else if(feux.get(i).getCouleur() == Tricolor.Rouge){	
		}
		
		else if(feux.get(i).getCouleur() == Tricolor.Orange){	
		}
		
	}
}
