package ElementReseau;
import ElementControle.Feu;
import ElementControle.FeuBicolore;
import ElementControle.FeuTricolore;
import ElementSimulation.Voiture;
import enumerations.Tricolor;

/**
 * Passage piéton entre deux segments avec deux feux Tricolor ou Bicolor
 * Seul la couleur des feux importe au trajet de la voiture
 * @param <F>
 */
public class PassagePieton<F extends Feu> extends JonctionSimple{
	F feuT;
	F feuF;
	
	/**
	 * Constructeur automatique en ne prenant en compte que le type de feu
	 * @param typeFeu
	 */
	@SuppressWarnings("unchecked")
	public PassagePieton(int typeFeu)
	{
		if(typeFeu == 0) // Feux bicolors
		{
			FeuBicolore f1 = new FeuBicolore();
			FeuBicolore f2 = new FeuBicolore();
			feuT = (F) f1;
			feuF = (F) f2;
			feuT.setCouleur(Tricolor.Vert);
			feuF.setCouleur(Tricolor.Rouge);
		}
		else //Feux tricolors
		{
			FeuTricolore f1 = new FeuTricolore();
			FeuTricolore f2 = new FeuTricolore();
			feuT = (F) f1;
			feuF = (F) f2;
			feuT.setCouleur(Tricolor.Vert);
			feuF.setCouleur(Tricolor.Rouge);
		}
	}
	/**
	 * Constructeur personnalisé avec arguments
	 * @param T1
	 * @param T2
	 * @param typeFeu
	 */
	public PassagePieton(SegmentRoute T1, SegmentRoute T2, int typeFeu)
	{
		segmentsLies.add(T1);segmentsLies.add(T2);
		if(typeFeu == 0)
		{
			FeuBicolore f1 = new FeuBicolore();
			FeuBicolore f2 = new FeuBicolore();
			feuT = (F) f1;
			feuF = (F) f2;
			feuT.setCouleur(Tricolor.Vert);
			feuF.setCouleur(Tricolor.Rouge);
		}
		else 
		{
			FeuTricolore f1 = new FeuTricolore();
			FeuTricolore f2 = new FeuTricolore();
			feuT = (F) f1;
			feuF = (F) f2;
			feuT.setCouleur(Tricolor.Vert);
			feuF.setCouleur(Tricolor.Rouge);
		}
	}
	@Override
	public void avancer(Voiture v){
		if(v.getSens())
			checkColor(feuT,v,segmentsLies.get(0));
		else
			checkColor(feuF,v,segmentsLies.get(1));	
	}
	/**
	 * On check feu pour voir si l'on peut passer, s'arreter ou que l'on doit diviser vitesse par 2
	 * @param chFeu
	 * @param v
	 * @param s
	 * @throws ExceptionVoiture
	 */
	public void checkColor(F chFeu,Voiture v, SegmentRoute s)
	{
		if(chFeu.getCouleur().equals(Tricolor.Vert))
		{
			System.out.println("La voiture "+v.getId()+" traverse le passage");
			if(v.getSens())
				v.setEtat(segmentsLies.get(1), v.getSens(), 0);
			else
				v.setEtat(segmentsLies.get(0), v.getSens(),0);
			v.getSegmentActuel().useSemaphore(v);
		}
		else if(chFeu.getCouleur() == Tricolor.Rouge){	
			System.out.println("La voiture "+v.getId()+" s'arrete au passage");
			v.setDistRestante(0);
		}
		else if(chFeu.getCouleur() == Tricolor.Orange){	
			System.out.println("La voiture "+v.getId()+" traverse le passage au feu orange");
			if(v.getSens())
				v.setEtat(segmentsLies.get(1), v.getSens(), 0);
			else
				v.setEtat(segmentsLies.get(0), v.getSens(),0);
			v.getSegmentActuel().useSemaphore(v);
			v.setDistRestante(v.getDistRestante()/2); //On divise vitesse par 2 pour le reste de l'intervalle
		}
	}
	@Override
	public void notifPresence(boolean chSens,Voiture v) 
	{
		if(chSens)
			feuVertT();
		else
			feuVertF();
	}
	public void changerFeux()
	{
		if (feuT.getCouleur().equals(Tricolor.Vert)) 
			feuVertF();
		else
			feuVertT();
	}
	public void feuVertT()
	{
		feuT.setCouleur(Tricolor.Vert);
		feuF.setCouleur(Tricolor.Rouge);
	}
	public void feuVertF()
	{
		feuT.setCouleur(Tricolor.Rouge);
		feuF.setCouleur(Tricolor.Vert);
	}
	public void addSeg(SegmentRoute seg)
	{
		segmentsLies.add(seg);
	}
	
	
	
}
