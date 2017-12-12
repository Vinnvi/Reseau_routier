package ElementReseau;

/**
 * Classe abstraite des jonctions simples comme Passage Pi�ton
 * Un seul mod�le donc utilisation minimale mais possible de les d�velloper par la suite
 */
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
