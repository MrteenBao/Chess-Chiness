package Chess;


public class Cannon implements Piece{

	private Game _game;
	private int _selectedX;
	private int _selectedY;
	private PieceColor _color;

	
	public Cannon(PieceColor color,Game game, int x,int y){
		this._color = color;
		this._game = game;
		this._selectedX = x;
		this._selectedY = y;
	}
	@Override
	public String imageString() {
		// return short string to show on board
		return _color.review()+PieceType.Cannon.review();
	}

	@Override
	public PieceColor color() {
		//Return color of this piece
		return _color;
	}

	@Override
	public PieceType type() {
		// Return type of this piece
		return PieceType.Cannon;
	}

	@Override
	public boolean makeValidMove(int a, int b) {
		System.out.println("CHECK0 "+_selectedX+_selectedY+a+b);
		if(_game.get(a, b)!=null && _game.get(a, b).color()==_color){
			return false;
		}
		else if(a == _selectedX){
			System.out.println("CHECK1 "+_selectedX+_selectedY+a+b);
				if(b == _selectedY) return false; 
				int temp = (b - _selectedY)/Math.abs(b - _selectedY);
				for(int i = _selectedY+temp;i != b;i+=temp){
					if(_game.get(a, i)!=null){
						for(int j = i+temp;j != b;j+=temp){
							if(_game.get(a,j)!=null) return false;
						}
						if(_game.get(a, b)!=null){
							return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));

						}
						else return false;

					}
				}
				if(_game.get(a, b)==null){
					return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));

				}
				return false;
				
		}
		else if(b == _selectedY){
			System.out.println("CHECK2 "+_selectedX+_selectedY+a+b);
				int temp =(a - _selectedX)/Math.abs(a - _selectedX);
				for(int i = _selectedX+temp; i != a; i+= temp){
					if(_game.get(i, b)!=null){
						for(int j =i+temp; j != a; j+=temp){
							if(_game.get(j, b)!=null) return false;							
						}
						if(_game.get(a, b)!=null){
							return  makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));

						}
						else return false;
						
					}
				}
				if(_game.get(a, b)==null){
					return makeMoveCarefull(new Move(this,_selectedX,_selectedY,_game.get(a, b),a,b));

				}
				return false;


		}
		return false;
	
	}

	@Override
	public boolean makeMoveCarefull(Move move) {
		_game.makeMove(move);
		if(_game.inCheck(_game.turn().opposite())){
			_game.undoMove();
			System.out.println("Tuong bi an");
			return false;
		}
		else{
			setLocation(move.get_x2(), move.get_y2());
		
			return true;
		}
		
	}



	@Override
	public boolean canCapture(int a, int b) {
		 if(a == _selectedX){
				System.out.println("CHECKCap1 "+_selectedX+_selectedY+a+b);
					if(b == _selectedY) return false; 
					int temp = (b - _selectedY)/Math.abs(b - _selectedY);
					for(int i = _selectedY+temp;i != b;i+=temp){
						if(_game.get(a, i)!=null){
							for(int j = i+temp;j != b;j+=temp){
								if(_game.get(a,j)!=null) return false;
							}
							if(_game.get(a, b)!=null){	
								return true;
							}
							return false;

						}
					}
					if(_game.get(a, b)==null){
						return true;

					}
					return false;
					
			}
			else if(b == _selectedY){
				System.out.println("CHECKCap2 "+_selectedX+_selectedY+a+b);
					int temp =(a - _selectedX)/Math.abs(a - _selectedX);
					for(int i = _selectedX+temp; i != a; i+= temp){
						if(_game.get(i, b)!=null){
							for(int j =i+temp; j != a; j+=temp){
								if(_game.get(j, b)!=null) return false;							
							}
							if(_game.get(a, b)!=null){
								return true;
							}
							else return false;

							
						}
					}
					if(_game.get(a, b)==null){
						return true;

					}
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


	
}
