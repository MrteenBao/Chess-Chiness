package Chess;

public enum PieceColor {
	/*The color of piece chess*/
	BLACK,WHILE;          
	
	/*Return the short string of this color*/
	public String review(){
		switch(this){
		case BLACK:
			return "b";
		case WHILE:
			return "w";
		}
		return "-";
	}
	
	/*Return the full string of this color*/
	public String string(){
		switch(this){
		case BLACK:
			return "BLACK";
		case WHILE:
			return "WHILE";
		default:
			return "-";
		}
	}
	
	/*Return the opposite color*/
	public PieceColor opposite(){
		if(this == WHILE){
			return BLACK;
		}
		return WHILE;
	}
	
	/*Return int of this color 1:BLACK  2:WHILE*/
	public int value(){
		if(this == WHILE){
			return -1;
		}
		return 1;
	}
}
