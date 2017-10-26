package Chess;
import static Chess.PieceType.*;

public class Soldier implements Piece {

	private Game _game;
	private int _selectedX;
	private int _selectedY;
	private PieceColor _color;

	public Soldier(PieceColor color,Game game,int selectedX,int selectedY) {
		
		// Constructor 
		this._color = color;
		this._game = game;
		this._selectedX = selectedX;
		this._selectedY = selectedY;
	}
	@Override
	public String imageString() {
		// Return short Piece to show on board
		return _color.review()+Soldier.review();
	}

	@Override
	public PieceColor color() {
		// Return COLOR of this piece
		return _color;
	}

	@Override
	public PieceType type() {
		//  Return TYPE of this piece
		return PieceType.Soldier;
	}

	@Override
	public boolean makeValidMove(int a, int b) {
		// Return true if Move is valid
		
		if(_game.get(a, b)!=null && _game.get(a, b).color()==_color){
			return false;
		}
		else if(_game.turn()==PieceColor.BLACK){
			
				if(_selectedY < 5){
					if(a == (_selectedX+1) && b == _selectedY) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));
					return false;
				}
				else {
					if(a == _selectedX && b == (_selectedY+1)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));;
					if(a == _selectedX && b == (_selectedY-1)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));;
					if(a == (_selectedX-1) && b ==_selectedY) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));;
				}
		}
		else if(_game.turn() == PieceColor.WHILE){
			
				if(_selectedY > 4){
					if(a == (_selectedX+1) && b == _selectedY) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));;
					return false;
				}
				else {
					if(a == _selectedX && b == (_selectedY-1)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));;
					if(a == _selectedX && b == (_selectedY+1)) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));;
					if(a == (_selectedX-1) && b == _selectedY) return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));;
				}
		}
		return false;
	}


		
	@Override
	//Move can capture another piece in (a,b)
	public boolean canCapture(int a, int b) {
		
		 if(_game.turn()==PieceColor.BLACK){
				
					if(_selectedY < 5){
						if(a == _selectedX && b == (_selectedY+1)) return true;						return false;
					}
					else {
						if(a == _selectedX && b == (_selectedY+1)) return true;
						if(a == _selectedX && b == (_selectedY-1)) return true;
						if(a == (_selectedX+1) && b ==_selectedY) return true;
						}
			}
			else if(_game.turn() == PieceColor.WHILE){
			
					if(_selectedY > 4){
						if(a == _selectedX && b == (_selectedY-1)) return true;
						return false;
					}
					else {
						if(a == _selectedX && b == (_selectedY-1)) return true;
						if(a == _selectedX && b == (_selectedY+1)) return true;
						if(a == (_selectedX-1) && b == _selectedY) return true;
						}
			}
		 return false;
	}

	@Override
	public void setLocation(int x, int y) {
		this._selectedX = x;
		this._selectedY = y;
		
	}
	
	@Override
	//Check Move to General not captured
	public boolean makeMoveCarefull(Move move){
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

	public Game get_game() {
		return _game;
	}

	public void set_game(Game _game) {
		this._game = _game;
	}

	public int get_selectedY() {
		return _selectedY;
	}

	public void set_selectedY(int _selectedY) {
		this._selectedY = _selectedY;
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

}
