package ElementReseau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ElementControle.Capteur;
import ElementControle.Semaphore;
import ElementSimulation.Voiture;

/**
 * Segment de route entre deux jonctions
 * Caractéristiques d'une route, des capteurs et est relié a 2 jonctions
 * @param <T>
 * @param <C>
 * @param <S>
 */
public class SegmentRoute<T extends Jonction,C extends Capteur,S extends Semaphore> {
	String name;
	private int longueur;
	private int limitVitesse;
	private List<C> capteursSensT = new ArrayList<C>();
	private List<C> capteursSensF = new ArrayList<C>();
	private T jonctionGauche;
	private T jonctionDroite;
	private Voiture state;
	private S semaphoreTrue;
	private S semaphoreFalse;
	
	public SegmentRoute(int maLongeur,T g,T d,int chLimit,String nom){
		longueur = maLongeur;
		name = nom;
		setJonctionGauche(g);
		setJonctionDroite(d);
		limitVitesse = chLimit;
	}
	public void setJonctionGauche(T j){
		jonctionGauche = j;
		j.addSegmentRoute(this);
	}
	public void setJonctionDroite(T j){
		jonctionDroite = j;
		j.addSegmentRoute(this);
	}
	public Jonction getJonctionGauche() {
		return jonctionGauche;
	}
	public T getJonctionDroite() {
		return jonctionDroite;
	}
	public int getLongueur(){
		return longueur;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Voiture getState(){
		return state;
	}
	public void setState(Voiture chState){
		state = chState;
		notifyAllCapteurs();
	}
	public int getLimit()
	{
		return limitVitesse;
	}
	public void notifyAllCapteurs()
	{
		for(C capteurT : capteursSensT){
			capteurT.update();
		}
		for(C capteurF : capteursSensF){
			capteurF.update();
		}
	}
	public void useCapteur(Voiture v,int posDepart, int posFinal)
	{
		
		if(v.getSens())
		{
			for(C capteurT : capteursSensT){
				if (posDepart < capteurT.getPosSegment() && capteurT.getPosSegment() <= posFinal)
				{
					capteurT.update(v);
				}
			}
		}
		else
		{
			for(C capteurF : capteursSensF){
				if (posDepart < capteurF.getPosSegment() && capteurF.getPosSegment() <= posFinal)
				{
					capteurF.update(v);
				}
			}
		}
	}
	public void addCapteur(C chCapteur, boolean chSens)
	{
		if(chSens = true)
			capteursSensT.add(chCapteur);
		else
			capteursSensF.add(chCapteur);
	}
	
	public void addSemaphore(S semaphore, boolean chSens)
	{
		if(chSens == true)
			semaphoreTrue = semaphore;
		else
			semaphoreFalse = semaphore;
	}	
	
	public void useSemaphore(Voiture v){
		
		if(v.getSens()){
			if(semaphoreTrue != null){
				semaphoreTrue.update(v);
			}
		}
		else{
			if(semaphoreFalse != null){
				semaphoreFalse.update(v);
			}
				
		}
	}
}
