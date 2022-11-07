import java.util.Scanner;

public class Validboard {
	public static boolean Valid(char X, char O, char board[][]) {
		int p = 0;
		int m = 0;
		for (int i=0; i<3; i++) {
		for (int j=0; j<3; j++) {
		if (board[i][j] == X) {
			++p;				
		}
		if (board[i][j] == O) {
			++m;
		}
		}
			
		}
		if(p <= 5 && m <= 5 && m == p - 1 || p == m - 1 || p == m) {
		System.out.println("This is a Valid Game Board");
		return true;
		}
		
		System.out.println("This is a Invalid Game Board");
		return false;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char O = 'O';
		char X = 'X';
		char empty = '.';
		char[][] board = {{ X, O, '.',},
						  { O, X, O,},
						  { X, X, O}};
		
		for(char[] row : board) {
			for(char rows : row) {
				System.out.print(rows);
			}
			System.out.println();
			
	}
		Valid(X, O, board);
}
}
