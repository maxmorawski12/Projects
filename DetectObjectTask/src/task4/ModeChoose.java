package task4;
import java.util.Scanner;
public class ModeChoose extends MainClass {
	int usermode;
	Scanner scan = new Scanner(System.in);
	//mode choose for the input from the user
	public void modechoose() {
		System.out.println("Please Put the finch on the ground");
		System.out.println("Pick a mode 1 = Curious Mode 2 = Scaredy Mode and 3 = Any Mode");
		usermode = scan.nextInt();
	
	}
	}
