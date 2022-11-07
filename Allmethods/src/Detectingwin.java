import java.util.Scanner;

public class Detectingwin {
	public static String Winning(char board[][]) {
		if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X' || board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X' || board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X'
		|| board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X'  || board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'|| board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X'
		|| board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'|| board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X'){
			return "X has won";
		}
		if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O' || board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O' || board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O'
				|| board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'  || board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'|| board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'
				|| board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'|| board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O'){
			return "O has won";

					
			
		}
		return "There is no winner";
		}

public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	char O = 'O';
	char X = 'X';
	char empty = '.';
	char[][] board = {{ O, O, X,},
					  { X, X, O,},
					  { O, X, X}};
	
	for(char[] row : board) {
		for(char rows : row) {
			System.out.print(rows);
		}
		System.out.println();
		
}
	System.out.println(Winning(board));
}
}

