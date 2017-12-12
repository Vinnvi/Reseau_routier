package ElementControle;

import enumerations.Tricolor;

public abstract class Feu extends Semaphore{
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
