package ElementControle;

import java.util.Iterator;

import ElementReseau.Carrefour;
import ElementSimulation.Voiture;
import enumerations.Tricolor;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ElementRegulationFeux1 extends ElementRegulation{
	int timer=0;
	
	public ElementRegulationFeux1(Carrefour c) {
		this.c = c;
		Iterator<Feu> it = c.getFeux().iterator();
		while(it.hasNext()){
			this.s.add(it.next());
		}
		
	}
	
	public ElementRegulationFeux1(int timer) {
		this.timer = timer;
	}
	
	@Override
	public void algo() {
		timer++;
		if(timer%3 == 0){ // Tous les 3 indices de temps
			System.out.println("changement des feux du croisement");
			Iterator<Feu> it = c.getFeux().iterator();
			while(it.hasNext()){
				Feu f = it.next();
				if(f.couleur== Tricolor.Vert){
					f.couleur=Tricolor.Rouge;
				}
				else{
					int random = (int) (Math.random() * (2));
					if(random == 1){ // une chance sur deux que le feu passe au vert
						f.couleur=Tricolor.Vert;
					}
				}
			}
		}
	} //Consiste a juste changer la regulation en fonction du temps

	@Override
	public void update(Voiture v) {
		// TODO Auto-generated method stub
		
	}
	
}
