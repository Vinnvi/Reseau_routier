package ElementReseau;

import java.util.ArrayList;
import java.util.Iterator;

import ElementControle.Feu;
import ElementControle.FeuBicolore;
import ElementControle.FeuTricolore;
import ElementControle.Tricolor;
import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Main;
import ElementSimulation.Voiture;

public class Carrefour<T extends Feu> extends Jonction{
	
	ArrayList <T> feux = new ArrayList<T>(); // L'indice du feu correspond � l'indice du segment dans segements liees
	
	public Carrefour(int nbRoutesConnectes,int typeFeu){
		for(int i=0;i<nbRoutesConnectes;i++){
			if(typeFeu == 1){
				T f = (T)new FeuBicolore();
				feux.add(f);
				f.setCouleur(Tricolor.Rouge);
				Main.addFeu(feux.get(i));
			}
			else{
				T f = (T)new FeuTricolore();
				feux.add(f);
				f.setCouleur(Tricolor.Rouge);
				Main.addFeu(feux.get(i));
			}
		}
		int nbAlea = (int) (Math.random() * (nbRoutesConnectes));
		feux.get(nbAlea).setCouleur(Tricolor.Rouge);
	}
	public Carrefour(int typeFeu,SegmentRoute... routes){
		for(int i=0;i<routes.length;i++){
			if(typeFeu == 1){
				T f = (T)new FeuBicolore();
				feux.add(f);
				f.setCouleur(Tricolor.Rouge);
				Main.addFeu(feux.get(i));
			}
			else{
				T f = (T)new FeuTricolore();
				feux.add(f);
				f.setCouleur(Tricolor.Rouge);
				Main.addFeu(feux.get(i));
			}
		}
		int nbAlea = (int) (Math.random() * (routes.length));
		feux.get(nbAlea).setCouleur(Tricolor.Rouge);
		for(int i=0;i<routes.length;i++){
			segmentsLies.add(routes[i]);
		}
	}
	
	@Override
	public void avancer(Voiture v) throws ExceptionVoiture {
		SegmentRoute segmentActuel = v.getSegmentActuel();
		//choix aleatoire prochain segment
		SegmentRoute nextSegment=null;
		do{ 
			int indiceSeg = (int) (Math.random() * (segmentActuel.getJonctionDroite().getSegmentsLies().size()-1) );
			nextSegment = segmentActuel.getJonctionDroite().getSegmentsLies().get(indiceSeg);
		}while(nextSegment == segmentActuel);
		//Check color feu
		int i=0;
		for(i=0;i<this.getSegmentsLies().size();i++){
			if(this.getSegmentsLies().get(i)==v.getSegmentActuel()){
				break;
			}
		}
		if(feux.get(i).getCouleur() == Tricolor.Vert)
		{
			System.out.println("La voiture traverse le passage du carrefour");
			v.setEtat(nextSegment, v.getSens(),v.getSens() ? 0 : nextSegment.getLongueur());
			v.getSegmentActuel().useSemaphore(v);
		}
		else if(feux.get(i).getCouleur() == Tricolor.Rouge){	
			System.out.println("La voiture "+v.getId()+" s'arrete devant le carrefour");
			v.setDistRestante(0);
		}
		else if(feux.get(i).getCouleur() == Tricolor.Orange)
		{	
			System.out.println("La voiture traverse le passage du carrefour au feu orange");
			v.setDistRestante(v.getDistRestante() > 1 ? (int)v.getDistRestante()/2 : 1);
			v.setEtat(nextSegment, v.getSens(),v.getSens() ? 0 : nextSegment.getLongueur());
			v.getSegmentActuel().useSemaphore(v);
			v.setVitesseActuelle(v.getVitesse()/2);
		}

	}
	public void addSeg(SegmentRoute... routes){
		for(int i=0;i<routes.length;i++){
			segmentsLies.add(routes[i]);
		}
	}
	@Override
	public void notifPresence(boolean chSens,Voiture v) 
	{
		Iterator <T> it = feux.iterator();
		SegmentRoute sVoiture = v.getSegmentActuel(); // On recupere l'indice du segment sur lequel se situe la voiture
		int indice = 0;
		for(indice=0;indice<this.getSegmentsLies().size();indice++){
			if(this.getSegmentsLies().get(indice)==sVoiture){
				break;
			}
			else{
				indice++;
			}
		}
		while(it.hasNext()) { //On remet tous les feux au rouge...
			it.next().setCouleur(Tricolor.Rouge);
		}
		feux.get(indice).setCouleur(Tricolor.Vert); //...pour remettre celui de la voiture au vert
	}
}
