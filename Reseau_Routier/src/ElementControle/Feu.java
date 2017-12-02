package ElementControle;

public abstract class Feu implements Semaphore{
	Tricolor couleur;
	public Tricolor getCouleur() {
		return couleur;
	}
	public void setCouleur(Tricolor couleur) {
		this.couleur = couleur;
	}
	public void switchColor()
	{
		couleur = (couleur.equals(Tricolor.Vert) ? Tricolor.Rouge : Tricolor.Vert);
	}
	
	
}
