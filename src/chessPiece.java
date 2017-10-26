

public abstract class chessPiece {
	public pieceColor pcolor;
	public Local placeAt;
	public boolean moved;
	
	public chessPiece(){};
	public abstract Local[] validMoves();
	public abstract Local[] validAttacks();
	public abstract Local[] captureFreeMoves();
	public abstract Local[] capturedMoves();
	
}
