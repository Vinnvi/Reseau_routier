
public class Barriere extends Jonction{
	private SegmentRoute seg1;
	
	public void avancer(Voiture v) throws ExceptionVoiture{
		v.setEtat(v.getSegmentActuel(),v.sensActuel,0,longueur);
	}
}
