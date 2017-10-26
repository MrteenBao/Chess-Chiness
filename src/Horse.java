package Chess;

import static Chess.PieceType.*;
public class Horse implements Piece{
    private Game _game;

    /*The color of this piece. */
    private PieceColor _color;

    /* The x-location of this piece. */
    private int _x;

    /*THe y-location of this piece. */
    private int _y;

    public Horse(PieceColor color, Game game,int x , int y){
    	_color = color;
    	_game = game;
    	_x =x;
    	_y =y;
    }
    @Override
    public String imageString(){
    	return _color.review()+Horse.review();
    }
    @Override
    public PieceColor color() {
        return _color;
    }

    @Override
    public PieceType type() {
        return Horse;
    }
    
    @Override
    public boolean makeValidMove(int a ,int b){
    	if(_game.get(a, b)!=null && _game.get(a, b).color()==_color){
    		return false;
    	}
    	else if((Math.abs(a-_x)==2 && Math.abs(b-_y)==1 && _game.get((a+_x)/2,_y)==null)||(Math.abs(a-_x) ==1 && Math.abs(b-_y)==2 && _game.get(_x,(b+_y)/2)==null)){
    			return makeMoveCarefull(new Move(this, _x, _y, _game.get(a, b), a, b));
    			}
    	else {
    		return false;
    	}
    }
    @Override 
    public void setLocation(int x,int y){
    	this._x=x;
    	this._y=y;
    }
    @Override
    public boolean canCapture(int a, int b){
    	if((Math.abs(a-_x)==2 && Math.abs(b-_y)==1 && _game.get((a+_x)/2,_y)==null)||(Math.abs(a-_x) ==1 && Math.abs(b-_y)==2 && _game.get(_x,(b+_y)/2)==null)){
			return true;
			}
    	return false;
    }
    @Override
    public boolean makeMoveCarefull(Move move){
        _game.makeMove(move);
        if (_game.inCheck(_game.turn().opposite())) {
            _game.undoMove();
            return false;
        } else {
        	setLocation(move.get_x2(), move.get_y2());
            return true;
        }
    }
    
}
