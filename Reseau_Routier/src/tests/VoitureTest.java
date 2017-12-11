package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ElementReseau.Barriere;
import ElementReseau.Carrefour;
import ElementReseau.SegmentRoute;
import ElementSimulation.ExceptionVoiture;
import ElementSimulation.Voiture;

public class VoitureTest 
{
	SegmentRoute R1;
	Carrefour C1;
	Barriere B1;
	Voiture v1;
	@Before
	public void setUp()
	{
		C1 = new Carrefour(3, 0);
		B1 = new Barriere();
		R1 = new SegmentRoute(60,B1,C1,70,"R1");
		v1 = new Voiture(2,65,R1,0,true);
	}
	@Test
	public void test() throws ExceptionVoiture 
	{
		v1.avancer();
		assertTrue(v1.getVitesse() == 60);
		fail("Not yet implemented");
	}

}
