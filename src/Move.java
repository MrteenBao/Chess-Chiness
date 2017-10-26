package Chess;

public class Move {
	  /* The piece being moved in this move. */
    private Piece _selected;

    /* The piece at the move destination. */
    private Piece _target;
    
    private Piece _replace;
    /* x-location of _selected. */
    private int _x1;

    /*y-location of _selected. */
    private int _y1;

    /* x-location of _target. */
    private int _x2;

    /* y-location of _target. */
    private int _y2;
    
    public Move(Piece s, int x1, int y1, Piece t, int x2, int y2) {
        this._selected = s;
        this._x1 = x1;
        this._y1 = y1;
        this._target = t;
        this._x2 = x2;
        this._y2 = y2;
        
    }


    public Move undoMove(){
    	return new Move(_selected,_x2,_y2,null,_x1,_y1);
    }
    
    //Reference to declare private
    public Piece movedPiece(){
    	return _selected;
    }
    
    public Piece get_selected(){
    	return _selected;
    }
    
    public Piece get_target(){
    	return _target;
    }
    
    public int get_x1(){
    	return _x1;
    }
    
    public int get_y1(){
    	return _y1;
    }
    
    public int get_x2(){
    	return _x2;
    }
    
    public int get_y2(){
    	return _y2;
    }


	public Piece get_replace() {
		return _replace;
	}


	public void set_replace(Piece _replace) {
		this._replace = _replace;
	}

}
