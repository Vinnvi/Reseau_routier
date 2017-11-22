package ElementReseau;

public abstract class JonctionSimple extends Jonction{
	private SegmentRoute segmentGauche;
	private SegmentRoute segmentDroite;
	
	public void setSegmentGauche(SegmentRoute s)
	{
		segmentGauche = s;
	}
	public void setSegmentDroite(SegmentRoute s)
	{
		segmentDroite = s;
	}
}
