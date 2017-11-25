package ElementReseau;
import ElementControle.Feu;
import ElementControle.FeuBicolore;
import ElementControle.FeuTricolore;
import ElementControle.Tricolor;
import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class PassagePieton<F extends Feu> extends JonctionSimple{
	F feuT;
	F feuF;
	
	@SuppressWarnings("unchecked")
	public PassagePieton(int typeFeu)
	{
		if(typeFeu == 0)
		{
			FeuBicolore f1 = new FeuBicolore();
			FeuBicolore f2 = new FeuBicolore();
			feuT = (F) f1;
			feuF = (F) f1;
			feuT.setCouleur(Tricolor.Vert);
			feuF.setCouleur(Tricolor.Rouge);
		}
		else 
		{
			FeuTricolore f1 = new FeuTricolore();
			FeuTricolore f2 = new FeuTricolore();
			feuT = (F) f1;
			feuF = (F) f1;
			feuT.setCouleur(Tricolor.Vert);
			feuF.setCouleur(Tricolor.Rouge);
		}
	}
	public PassagePieton(F f1, F f2)
	{
		feuT = f1;
		feuT.setCouleur(Tricolor.Vert);
		feuF = f2;
		feuF.setCouleur(Tricolor.Rouge);
	}
	@Override
	public void avancer(Voiture v, int distanceRestante) throws ExceptionVoiture{
		if(v.getSens())
			checkColor(feuT,v);
		else
			checkColor(feuF,v);	
	}
	public void checkColor(F chFeu,Voiture v) throws ExceptionVoiture
	{
		if(chFeu.getCouleur() == Tricolor.Vert)//(feu.getCouleur() == Tricolor.Vert)
		{
			System.out.println("La voiture "+v.getId()+" traverse le passage");
			v.setEtat(segmentsLies.get(1), v.getSens(), v.getVitesse(), 0);
		}
		else if(chFeu.getCouleur() == Tricolor.Rouge){	
		}
		
		else if(chFeu.getCouleur() == Tricolor.Orange){	
		}
	}
	@Override
	public void notifPresence(boolean chSens) 
	{
		
	}
	
	
	
}
