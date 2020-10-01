import java.util.Scanner;

public class TICTACTOE {
	
		public static  int row;
		public  static int col;
		  public static Scanner scan = new Scanner(System.in);
		  public static char[][] Gameboard = new char[3][3];
		

		public static void main(String[]args) {                    
			// printing  the board with dashes  on console
					for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
							Gameboard[i][j] = '-';
						}
		}			
				 	boolean player1 = true;	
			boolean gameEnded = false;
			System.out.println("<<<<<<GAME STARTS>>>>>");
			System.out.println(  "PLAYER 1 ENTER YOUR NAME:-");
			String p1 = scan.nextLine();
			System.out.println(  "PLAYER 2 ENTER YOUR NAME:-");
			String  p2 = scan.nextLine();
			while(!gameEnded) {
				
				drawBoard(Gameboard);//Draw the board				
			if(player1) {                                                  /*[0,0]    [0,1]   [0,2]
                                                                             [1,0]    [1,1]   [1,2]     
                                                                             [2,0]    [2,1]   [2,2]*/ 	
			System.out.println( p1 + " PLAYER 1 TURN(x):");                                
			} else {                                                    
			System.out.println( p2 +  " PLAYER 2 Turn(o):");
						}

			char c = '-'; //printing a char (x or o)
			if(player1) {
			c = 'x';
			} else {
			c = 'o';
				}
			while(true) {		
			//choosing position of row and col
			System.out.println("Enter a row number :- ");
			row = scan.nextInt() ; 
			System.out.println("Enter a column number :- ");
			col = scan.nextInt();
		       
			//Check if the row and col are 0, 1, or 2 try
					if(row < 0 || col < 0 || row > 2 || col > 2) {
					System.out.println("This position is off the bounds of the board! Try again.");
									
					//if this position has already done then its invalid
					} else if(Gameboard[row][col] != '-') {
					System.out.println("Someone has already made a move at this position! Try again.");				
					//otherwise it is valid        catch
					} else {
					break;
					   }		
					}
					// to set the position on the board at row, col to c
					Gameboard[row][col] = c;

					//Checking who is winner
					if(playerHasWon(Gameboard) == 'x') {
					System.out.println(p1 +" <<<PLAYER 1 is WINNER!>>");
					gameEnded = true;
					} else if(playerHasWon(Gameboard) == 'o') {
					System.out.println( p2 + "<<< PLAYER 2 is WINNER!>>>");
					gameEnded = true;
					} else {
                     //if board is full then it is tie
					if(boardIsFull(Gameboard)) {
					System.out.println("<<<It's a tie!>>>");
					gameEnded = true;
					} else {
					player1 = !player1;
						}
					 }
					}
					// board at the end of the game
					drawBoard(Gameboard);
			System.out.println("<<<GAME ENDED>>>");
			}
				//Make a function to draw the tic tac toe board
			public static void drawBoard(char[][] board) {
			System.out.println("TIC-TAC-TOE:");
			for(int i = 0; i < 3; i++) {								
			for(int j = 0; j < 3; j++) {
			System.out.print(board[i][j]);
				}					
			System.out.println();//separate line
						}
						}

						//Make a function to see if someone has won and return the winning char
			public static char playerHasWon(char[][] board) {
							
					//Check each row
			 for(int i = 0; i < 3; i++) {
			 if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
			 return board[i][0];
			 }
			}
							//Check each column
				for(int j = 0; j < 3; j++) {
				if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
				return board[0][j];
			 }
			}				
							//Check the diagonals
		 if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		 if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {						
			 return board[2][0];			
		  }
		return ' ';
		}
		// all of the positions on the board have been filled
	     public static boolean boardIsFull(char[][] board) {
	    	 for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(board[i][j] == '-') {
					return false;
					}
			  }
			}
			return true;
		}
	 }
		        
		      


