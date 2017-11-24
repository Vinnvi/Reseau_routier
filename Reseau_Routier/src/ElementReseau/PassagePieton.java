package ElementReseau;
import ElementControle.Feu;
import ElementControle.Tricolor;
import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class PassagePieton<T extends Feu> extends JonctionSimple{
	T feu;
	public PassagePieton(T chFeu)
	{
		feu = chFeu;
		feu.setCouleur(Tricolor.Vert);
	}
	@Override
	public void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture{
		//Check color feu
		System.out.println("aaa");
		if(feu.getCouleur() == Tricolor.Vert)//(feu.getCouleur() == Tricolor.Vert)
		{
			System.out.println("La voiture traverse le passage");
			v.setEtat(segmentsLies.get(1), v.getSens(), v.getVitesse(), 0);
		}
		else if(feu.getCouleur() == Tricolor.Rouge){	
		}
		
		else if(feu.getCouleur() == Tricolor.Orange){	
		}
	}
	
	
	
}
