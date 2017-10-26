package Chess;

import java.util.Scanner;

public class Main {

	
	private static Scanner in;
	public static void main(String[] args) {
       int x1,y1,x2,y2;
		Game game = new Game();
       showBoard(game.board());
       in = new Scanner(System.in);
       System.out.println("CHECK: ");
       
       while(true){
    	   System.out.println("");
           System.out.println("From : ");
           x1 = in.nextInt();
           y1 = in.nextInt();
           System.out.println("To :");
           x2 = in.nextInt();
           y2 = in.nextInt();
           if(game.get(x1, y1)!=null){
        	   
               if(game.get(x1, y1).color()== game.turn()){
            	   if(game.get(x1, y1).makeValidMove(x2, y2)){
                	   showBoard(game.board());
            	   }
            	   else {System.out.println("Ko the di dc "+game.get(x1, y1).imageString());}
               }
               else System.out.println("_->> No match");
           }
           else System.out.println("->>No match");
           
           
           
    	   if(false) break;
       }
       


	}
	public static void showBoard(Piece[][] board){
		
		System.out.println("////////////////////////////////////////////////////");
		for(int x = 0;x < 10;x++){
			System.out.println("");
			for(int y =0;y < 9;y++){
				if(board[x][y]==null){
					System.out.print("---\t");
				}
				else{
					System.out.print(board[x][y].imageString()+"\t");
				}
			}
		}
	}

}
