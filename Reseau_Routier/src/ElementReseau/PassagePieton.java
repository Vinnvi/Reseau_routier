package ElementReseau;
import ElementControle.Feu;
import ElementControle.Tricolor;
import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class PassagePieton extends JonctionSimple{
	Feu feu;
	public PassagePieton(Feu chFeu)
	{
		feu = chFeu;
		feu.setCouleur(Tricolor.Vert);
	}
	@Override
	public void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture{
		//Check color feu
		System.out.println("aaa");
		if(true)//(feu.getCouleur() == Tricolor.Vert)
		{
			System.out.println("La voiture traverse le passage");
			
		}
		else if(feu.getCouleur() == Tricolor.Rouge){
			
		}
		
		else if(feu.getCouleur() == Tricolor.Orange){
			
		}
	}
	
}
