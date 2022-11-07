package task4;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class MainClass{	
	public static Finch myf = new Finch();
	public static void main(String args[]) {
		// This is all of the inheritance from other classes
		Scanner scan = new Scanner(System.in);
		CuriousMode c = new CuriousMode();
		AnyMode a = new AnyMode();
		ScaredyMode s = new ScaredyMode();
		ModeChoose mc = new ModeChoose();
		mc.modechoose();
		// This is the choose mode code below
		if (mc.usermode == 1) {		
			c.curious();								
	}
		else
		if (mc.usermode == 2) {
			s.scaredy();
		}
		else
		if (mc.usermode == 3) {
			a.Any();
			if (a.value == 1) {
				c.curious();
			}
			else
			if (a.value == 2) {
				s.scaredy();
			}
			
		}
	}
	}
	
	
		






	
	