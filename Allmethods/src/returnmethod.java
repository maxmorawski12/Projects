import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
 public class returnmethod{
	 
	 	public static boolean Computer(char X, char O, char empty, char board[][]) {
	 		
	 		ArrayList<Integer> list = new ArrayList<Integer>();
	 		ArrayList<Integer> list2 = new ArrayList<Integer>();
	 	
	 	Random Rand = new Random();
	 	int p = 0;
		int m = 0;
		int r = 0;
		for (int i=0; i<3; i++) {
		for (int j=0; j<3; j++) {
		if (board[i][j] == X) {
			++p;				
		}
		if (board[i][j] == O) {
			++m;
		}
		
		if (board[i][j] == empty) {
			list.add(i);
			list2.add(j);
		}

		}			
		}
		r = list.size();
		r = Rand.nextInt(r);
		int lines = list.get(r);
		int column = list2.get(r);
		System.out.println();
		if (p <= 5 && m <= 5 && m == p - 1 || p == m) {
			board[lines][column] = 'O';
			for(char[] row : board) {
				for(char rows : row) {
					System.out.print(rows);
				}
				System.out.println();
			}
			return  true;
		}
		if (p <= 5 && m <= 5 && p == m - 1) {
		System.out.println("It is the players turn");
		return true;
	 	}
		System.out.println("Invalid Game");
		return false;
	 	}

			
			
			

	
		
	 
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	char O = 'O';
	char X = 'X';
	char empty = '.';
	char[][] board = {{'.', X, '.',},
					  { O, '.', X,},
					  { O, O, X}};
	
	for(char[] row : board) {
		for(char rows : row) {
			System.out.print(rows);
		}
		System.out.println();
		
}
	Computer(X, O, empty,board);

}	
}