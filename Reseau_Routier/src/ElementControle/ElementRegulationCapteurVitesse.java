package ElementControle;

import java.util.ArrayList;
import java.util.Iterator;

import ElementReseau.Carrefour;
import ElementReseau.Jonction;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;
import enumerations.Tricolor;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ElementRegulationCapteurVitesse <J extends Jonction,T extends Feu> extends ElementRegulation{
	ArrayList<Voiture> voitures = new ArrayList<>();
	@Override
	public void algo() { //But : si la voiture va trop vite :mettre le feu au rouge
		// TODO Auto-generated method stub
		Iterator<Voiture> it = voitures.iterator();
		while(it.hasNext()){
			Voiture v = it.next();
			SegmentRoute segmentVoiture = v.getSegmentActuel();
			if(v.getVitesse()>segmentVoiture.getLimit()){//La voiture va trop vite
				System.out.println("La voiture "+v.getId()+" roule trop vite! Le feu passe au rouge");
				SegmentRoute s = v.getSegmentActuel();
				Iterator<SegmentRoute> it2 = this.c.getSegmentsLies().iterator();
				int index=0;
				while(it2.hasNext()){
					if(it2.next()==s){//Si c'est notre segment
						break;
					}
					else{
						index++;
					}
				}
				
				//On met un autre feu au vert
				T feu = (T) c.getFeux().get(index);
				feu.setCouleur(Tricolor.Rouge);
				do{
					index = (int)(Math.random() * ( c.getFeux().size() ));
				}while(c.getFeux().get(index) == feu);
				feu = (T) c.getFeux().get(index);
				feu.setCouleur(Tricolor.Vert);
				System.out.println("Le feu du segment "+c.getSegmentsLies().get(index).getName()+" passe au vert");
				
			}
			else{
				System.out.println("Limitation de vitesse respect�e par la voiture "+v.getId());
			}
		}
		voitures.clear();
		
	}
	public void update(Voiture v){
		voitures.add(v);
	}
	
	public ElementRegulationCapteurVitesse(Carrefour c){
		this.c = c;
		Iterator<Feu> it = c.getFeux().iterator();
		while(it.hasNext()){
			this.s.add(it.next());
		}
	}
	
}
