import java.util.Scanner;
public class Userdefined {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What Year");
		int p = scan.nextInt();

		if (p % 4 == 0 && p % 100 == 0 && p % 400 == 0) { 
			System.out.println("That year is a leap year");
		}
		else {
			System.out.println("No that is not a leap year");
		}
}
}
