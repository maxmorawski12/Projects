import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main{
public static void main(String[] args) {
	
//Assign List
ArrayList<Integer> NumberList = new ArrayList<>();

//Assign Scanner to read user input
Scanner Sc = new Scanner(System.in);

//Tell user what to input
System.out.println("Please Enter a number ranging between 1 - 100, 10 times");

//Loop to take 10 numbers from user and parse String to Integer to be put added in List 
	for(int i = 0; i < 10; i++) {	
		String input = Sc.nextLine();
		int number = Integer.parseInt(input);
		NumberList.add(number);
	}





//Using HashSet to remove duplicates within the NumberList
HashSet<Integer> Set = new HashSet<Integer>();
Set.addAll(NumberList);

//Clear all Numbers within the list
NumberList.clear();

//Add numbers back into list without the duplicates
NumberList.addAll(Set);

//Using Collections to Sort the Number List to Ascending then reverse to make order descending
Collections.sort(NumberList);
Collections.reverse(NumberList);

//Displays the list
System.out.println(NumberList);



}
}