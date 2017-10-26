package Chess;

public class General implements Piece{
    /* The game this piece belongs to. */
    private Game _game;

    /* The color of this piece. */
    private PieceColor _color;

    /* The x-location of this piece. */
    private int _selectedX;

    /*[ The y-location of this piece. */
    private int _selectedY;

    
	public General(PieceColor color, Game game,int x,int y){
		this._color = color;
		this._game = game;
		this._selectedX = x;
		this._selectedY = y;
	}

	@Override
	public String imageString() {
		// Return string short to show on board
		return _color.review()+PieceType.General.review();
	}

	@Override
	public PieceColor color() {
		// return color of this piece
		return _color;
	}

	@Override
	public PieceType type() {
		// Return type of this piece
		return PieceType.General;
	}

	@Override
	public boolean makeValidMove(int a, int b) {
		System.out.print("CHECK GEN: "+_selectedX+_selectedY+a+b);
		if(_game.get(a, b)!=null && _game.get(a, b).color() == _color){
			return false;
		}
		else if( this.color()==PieceColor.BLACK && (b>2) && (b<6) && (a < 3)){
			if((a == _selectedX) && (b == (_selectedY+1))) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
			if((a == _selectedX) && (b == (_selectedY-1))) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
			if((a == (_selectedX+1)) && (b == _selectedY)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
			if((a == (_selectedX-1)) && (b == _selectedY)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
		}
		else if(this.color()==PieceColor.WHILE && (b>2) && (b<6) && (a > 6)){
			if((a == _selectedX) && (b == (_selectedY+1))) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
			if((a == _selectedX) && (b == (_selectedY-1))) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
			if((a == (_selectedX+1)) && (b == _selectedY)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
			if((a == (_selectedX-1)) && (b == _selectedY)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
		}
		return false;
	}

	@Override
	public boolean makeMoveCarefull(Move move) {
		_game.makeMove(move);
		setLocation(move.get_x2(), move.get_y2());
		if(_game.inCheck(_game.turn().opposite())){
			_game.undoMove();
			setLocation(move.get_x1(), move.get_y1());
			return false;
		}
		else{
			setLocation(move.get_x2(), move.get_y2());
			
			return true;
		}
	}

	@Override
	public boolean canCapture(int a, int b) {
		System.out.println("Can Capture :"+_selectedX+_selectedY+a+b);
		if(this.color()==PieceColor.BLACK && (a>2) && (a<6) && (b < 3)){
			if((a == _selectedX) && (b == (_selectedY+1))) return true;
			if((a == _selectedX) && (b == (_selectedY-1))) return true;
			if((a == (_selectedX+1)) && (b == _selectedY)) return true;
			if((a == (_selectedX-1)) && (b == _selectedY)) return true;
		}
		else if(this.color()==PieceColor.WHILE && (a>2) && (a<6) && (b>6)){
			if((a == _selectedX) && (b == (_selectedY+1))) return true;
			if((a == _selectedX) && (b == (_selectedY-1))) return true;
			if((a == (_selectedX+1)) && (b == _selectedY)) return true;
			if((a == (_selectedX-1)) && (b == _selectedY)) return true;
		}
		return false;
	}

	@Override
	public void setLocation(int x, int y) {
		this._selectedX= x;
		this._selectedY=y;
		
	}

	public Game get_game() {
		return _game;
	}

	public void set_game(Game _game) {
		this._game = _game;
	}

	public PieceColor get_color() {
		return _color;
	}

	public void set_color(PieceColor _color) {
		this._color = _color;
	}

	public int get_selectedX() {
		return _selectedX;
	}

	public void set_selectedX(int _selectedX) {
		this._selectedX = _selectedX;
	}

	public int get_selectedY() {
		return _selectedY;
	}

	public void set_selectedY(int _selectedY) {
		this._selectedY = _selectedY;
	}

}
