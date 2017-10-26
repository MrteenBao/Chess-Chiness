package Chess;

public interface Piece {
	/*Return the string to display */
	String imageString();
	
	/*Return color of this piece*/
	PieceColor color();
	
	/*Return type of this piece*/
	PieceType type();
	
	/**/
	boolean makeValidMove(int a,int b);
    public boolean makeMoveCarefull(Move move);
	
	/*Return true if this piece is can being captured at (a,b)*/
	boolean canCapture(int a,int b);
	
	/*Set location of this piece on board*/
	void setLocation(int x, int y);
	
}
