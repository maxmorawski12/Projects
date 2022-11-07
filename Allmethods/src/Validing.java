import java.util.Scanner;

public class Validing {
	public static boolean IsValid(char Valid){
		if (Valid == 'X' || Valid == 'O'|| Valid == '.') 
		{
		return true;
		} 
		else 
		{
		return false;
		}


}
	 	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input a valid uppercase game character");
		char a = scan.next().charAt(0);;
		System.out.println(IsValid(a));
	 	
	 	
}
}
