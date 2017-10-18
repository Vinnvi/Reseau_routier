
import javax.swing.text.Segment;
import java.util.Timer;
import java.util.TimerTask;

public class Main 
{
	Timer t;
	class Intervalle extends TimerTask 
	{
		int nbRepetitions = 1;
		public Intervalle()
		{	
		}
        @Override
		public void run() 
		{
			while(nbRepetitions > 0)
			{	
			}
			System.out.println("Termin�!");
			t.cancel();
		}
    }
	
	public static void main(){
		SegmentRoute s1 = new SegmentRoute(20);
		SegmentRoute s2 = new SegmentRoute(10);
		
		JonctionSimple j = new JonctionSimple(s1,s2);
	}
}
