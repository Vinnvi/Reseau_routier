package ElementSimulation;

import java.util.ArrayList;

import ElementControle.CapteurPresence;
import ElementControle.CapteurVitesse;
import ElementControle.ElementRegulationFeux1;
import ElementControle.FeuBicolore;
import ElementControle.FeuTricolore;
import ElementControle.PanneauLimitation;
import ElementReseau.Barriere;
import ElementReseau.Carrefour;
import ElementReseau.PassagePieton;
import ElementReseau.SegmentRoute;

public class Reseau 
{
	public static void main(String[] args)
	{
		Main object = Main.getInstance();
		object.lancerSimulation();
	}
}
