
package task4;
import java.util.Random;

public class AnyMode extends MainClass{
	int value;
	String Mode;
	// random number generator only between 1 and 2
	public void Any() {
	Random Rand = new Random();
	value = Rand.nextInt(2);
	value = value + 1;
	if (value == 1) {
		Mode = Integer.toString(value);
		Mode = "Running Curious Mode";
		System.out.println(Mode);
	}
	else 
	if (value == 2) {
		Mode = Integer.toString(value);
		Mode = "Running Scaredy Mode";
		System.out.println(Mode);
	}
		
	}

	}








