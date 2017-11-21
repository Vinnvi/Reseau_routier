package ElementReseau;
import ElementControle.Feu;
import ElementControle.Tricolor;
import ElementSimulation.Voiture;

public class PassagePieton extends JonctionSimple{
	Feu feu;
	 
	public void avancer(Voiture v){
		//Check color feu
		
		if(feu.getCouleur() == Tricolor.Vert){
			
		}
		
		if(feu.getCouleur() == Tricolor.Rouge){
			
		}
		
		if(feu.getCouleur() == Tricolor.Orange){
			
		}
	}
	
}
