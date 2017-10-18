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
			System.out.println("Terminé!");
			t.cancel();
		}
    }
}
