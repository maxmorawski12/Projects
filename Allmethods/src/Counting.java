import java.util.Scanner;

public class Counting {

		public static int Count(char Character, char board[][]) {
		int p = 0;
		for (int i=0; i<3; i++) {
		for (int j=0; j<3; j++) {
			if (board[i][j] == Character){
			++p;
		}
		}
		}

		System.out.println("Amount of times the character is used on the board ");
		return p;
		}
		
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			char O = 'O';
			char X = 'X';
			char empty = '.';
			char[][] board = {{ X, '.', '.',},
							  { O, X, O,},
							  { X, X, O}};
			
			for(char[] row : board) {
				for(char rows : row) {
					System.out.print(rows);
				}
				System.out.println();
				
		}
			System.out.println("Enter a character you want to check how many times it has shown up");
			char c = scan.next().charAt(0);
			System.out.println(Count(c, board));
}
	}
