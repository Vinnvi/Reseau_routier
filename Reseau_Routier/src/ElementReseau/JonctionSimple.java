package ElementReseau;

/**
 * Classe abstraite des jonctions simples comme Passage Piéton
 * Un seul modèle donc utilisation minimale mais possible de les dévelloper par la suite
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
