package Chess;

public class Advisor implements Piece{
	
	private Game _game;
	private int _selectedX;
	private int _selectedY;
	private PieceColor _color;
	
	public Advisor(PieceColor color,Game game,int x, int y){
		this._color = color;
		this._game = game;
		this._selectedX = x;
		this._selectedY = y;
	}
	@Override
	public String imageString() {
		// Return short string to show on board
		return _color.review()+PieceType.Advisor.review();
	}

	@Override
	public PieceColor color() {
		// Return color of this piece
		return _color;
	}

	@Override
	public PieceType type() {
		// Return type of this piece
		return PieceType.Advisor;
	}

	@Override
	public boolean makeValidMove(int a, int b) {
		
		if(_game.get(a, b)!=null && _game.get(a,b).color()==_color){
			return false;
		}
		else if(this.color() == PieceColor.BLACK && (b>2) && (b<6) &&(a < 3)){
				if(Math.abs(a - _selectedX)==1 && Math.abs(b - _selectedY)==1) return makeMoveCarefull(new Move(this, _selectedX,_selectedY,_game.get(a, b),a,b));
		}
		else if(this.color() == PieceColor.WHILE && (b>2) && (b<6) && (a > 6)){
				if(Math.abs(a - _selectedX)==1 && Math.abs(b - _selectedY)==1) return makeMoveCarefull(new Move(this, _selectedX,_selectedY,_game.get(a, b),a,b));
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
			setLocation(move.get_x2(), move.get_y2());
			
			return true;
		}
	}


	@Override
	public boolean canCapture(int a, int b) {
		if(this.color() == PieceColor.BLACK && (b>2) && (b<6) &&(a < 3)){
			if(Math.abs(a - _selectedX)==1 && Math.abs(b - _selectedY)==1) return true;
			}
		else if(this.color() == PieceColor.WHILE && (b>2) && (b<6) && (a > 6)){
			if(Math.abs(a - _selectedX)==1 && Math.abs(b - _selectedY)==1) return true;
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

	public PieceColor get_color() {
		return _color;
	}

	public void set_color(PieceColor _color) {
		this._color = _color;
	}

	public int get_selectedY() {
		return _selectedY;
	}

	public void set_selectedY(int _selectedY) {
		this._selectedY = _selectedY;
	}


}
