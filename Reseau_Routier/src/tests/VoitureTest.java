/**
 * 
 */
package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ElementControle.FeuTricolore;
import ElementReseau.Barriere;
import ElementReseau.PassagePieton;
import ElementReseau.SegmentRoute;
import ElementSimulation.Voiture;

public class VoitureTest {
	SegmentRoute R1,R2;
	PassagePieton P1;
	Barriere B1;
	Voiture v1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		P1 = new PassagePieton<FeuTricolore>(1,"P1");
		B1 = new Barriere("B1");
		R1 = new SegmentRoute(80,B1,P1,60,"R1");
		R2 = new SegmentRoute(60,P1,B1,30,"R2");
		v1 = new Voiture(2,65,R1,0,true);
	}

	/**
	 * On teste les comportements de la voiture sur la route et avec les jonctions
	 * @throws ExceptionVoiture
	 */
	@Test
	public void behaviourCarTest() {
		v1.avancer();
		assertTrue(v1.getVitLegale() == v1.getVitesse()); //Limitation respect�e
		assertTrue(v1.getVitesse() == 60); //r�sultat corresponds a la limite
		assertTrue(v1.getSegmentActuel() == R1); //On a pas chang� de segment
		
		v1.avancer();
		assertTrue(v1.getSegmentActuel() == R2); //On est d�sormais sur R2
		assertTrue(v1.getVitLegale() == v1.getVitesse()); //Limitation respect�e
		assertTrue(v1.getVitesse() == 30); //r�sultat corresponds a la limite
		assertTrue(v1.getPositionSegment() == 30);
		
		v1.setEtat(R2, false, 10);
		v1.avancer();
		assertTrue(v1.getSegmentActuel() == R2); //On est toujours sur R2
		assertTrue(v1.getVitLegale() == v1.getVitesse()); //Limitation respect�e
		assertTrue(v1.getVitesse() == 30); //r�sultat corresponds a la limite
		assertTrue(v1.getPositionSegment() == 40);
		
		P1.changerFeux(); //feu rouge, on veut qu'il soit vert
		v1.avancer();
		assertTrue(v1.getSegmentActuel() == R1); //On est sur R1
		assertTrue(v1.getVitLegale() == v1.getVitesse()); //Limitation respect�e
		assertTrue(v1.getVitesse() == 60); //r�sultat corresponds a la limite
		assertTrue(v1.getPositionSegment() == 9);
		
		v1.avancer();
		assertTrue(v1.getSegmentActuel() == R1); //On est toujours sur R1
		assertTrue(v1.getVitLegale() == v1.getVitesse()); //Limitation respect�e
		assertTrue(v1.getVitesse() == 60); //r�sultat corresponds a la limite
		assertTrue(v1.getPositionSegment() == 69);
		
		v1.avancer();
		assertTrue(v1.getSegmentActuel() == R1); //On est toujours sur R1
		assertTrue(v1.getVitesse() == 60); //On a rencontr� une barri�re mais on garde quand m�me vitesse car changement instantan� � chaque intervalle
		assertTrue(v1.getPositionSegment() == 80); //On est a la fin du segment, devant la barri�re
		
		fail("Not yet implemented");
	}

}

