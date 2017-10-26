package Chess;

public class Elephant implements Piece {
	
	private Game _game;
	private int _selectedX;
	private int _selectedY;
	private PieceColor _color;

	
	public Elephant(PieceColor color, Game game, int x,int y ){
		this._color = color;
		this._game = game;
		this._selectedX = x;
		this._selectedY = y;
	}
	@Override
	public String imageString() {
		// return short string to show on board
		return _color.review()+PieceType.Elephant.review();
	}

	@Override
	public PieceColor color() {
		// Return color of this piece
		return _color;
	}

	@Override
	public PieceType type() {
		// Return type of this piece
		return PieceType.Elephant;
	}

	@Override
	public boolean makeValidMove(int a, int b) {
		if(_game.get(a, b) != null && _game.get(a, b).color() == _color){
			return false;
		}
		else if(_game.turn() == PieceColor.BLACK && a < 5){
			    if(Math.abs(a - _selectedX)==2 && Math.abs(b - _selectedY)==2 && _game.get((a+_selectedX)/2, (b + _selectedY)/2)==null) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a,b),a,b));
			    return false;
		}
		else if(_game.turn() == PieceColor.WHILE && a > 4){
				if(Math.abs(a - _selectedX)==2 && Math.abs(b- _selectedY)==2 && _game.get((a+_selectedX)/2, (b + _selectedY)/2)==null) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a,b),a,b));
				return false;
		}
		return false;
	}
	
	@Override
	public boolean makeMoveCarefull(Move move) {
		_game.makeMove(move);
		if(_game.inCheck(_game.turn().opposite())){
			_game.undoMove();
			return false;
		}
		else{
			System.out.println("makecarefull :"+_selectedX+_selectedY);
			setLocation(move.get_x2(), move.get_y2());
			System.out.println("makecarefull :"+_selectedX+_selectedY);
		
			return true;
		}
	}
	


	@Override
	public boolean canCapture(int a, int b) {
		 if(_game.turn() == PieceColor.BLACK && a < 5){
			    if(Math.abs(a - _selectedX)==2 && Math.abs(b - _selectedY)==2 && _game.get((a+_selectedX)/2, (b + _selectedY)/2)==null) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a,b),a,b));
			    return false;
		}
		else if(_game.turn() == PieceColor.WHILE && a > 4){
				if(Math.abs(a - _selectedX)==2 && Math.abs(b- _selectedY)==2 && _game.get((a+_selectedX)/2, (b + _selectedY)/2)==null) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a,b),a,b));
				return false;
		}
		 return false;
	}

	@Override
	public void setLocation(int x, int y) {
		this._selectedX = x;
		this._selectedY = y;
	}

	public Game get_game() {
		return _game;
	}

	public void set_game(Game _game) {
		this._game = _game;
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

	public PieceColor get_color() {
		return _color;
	}

	public void set_color(PieceColor _color) {
		this._color = _color;
	}
}
