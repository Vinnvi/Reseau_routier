package ElementReseau;
import ElementControle.Feu;
import ElementControle.Tricolor;
import ElementSimulation.Voiture;

public class PassagePieton extends JonctionSimple{
	Feu feu;
	public PassagePieton(Feu chFeu)
	{
		feu = chFeu;
	}
	public void avancer(Voiture v){
		//Check color feu
		
		if(feu.getCouleur() == Tricolor.Vert){
			System.out.println("La voiture traverse le passage");
			
		}
		
		if(feu.getCouleur() == Tricolor.Rouge){
			
		}
		
		if(feu.getCouleur() == Tricolor.Orange){
			
		}
	}
	
}
