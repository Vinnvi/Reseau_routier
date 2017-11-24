package ElementControle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Tricolor 
{
	Vert, Rouge, Orange;
	private static final List<Tricolor> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	public static Tricolor randomColor()  
	{
	    return (VALUES.get(RANDOM.nextInt(SIZE)));
	}
	
}
