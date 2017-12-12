package enumerations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Bicolor 
{
	Vert,Rouge;
	private static final List<Bicolor> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	public static Bicolor randomColor()  
	{
	    return (VALUES.get(RANDOM.nextInt(SIZE)));
	}
}
