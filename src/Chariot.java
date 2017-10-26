package Chess;

import static Chess.PieceType.*;
public class Chariot implements Piece{
    /* The game this piece belongs to. */
    private Game _game;

    /* The color of this piece. */
    private PieceColor _color;

    /* The x-location of this piece. */
    private int _x;

    /* The y-location of this piece. */
    private int _y;

    /* Returns whether this rook has been moved. */

    
    public Chariot(PieceColor color, Game game,int x ,int y){
    	this._color = color;
    	this._game = game;
    	this._x = x;
    	this._y = y;
    }
    @Override 
    public String imageString(){
    	return _color.review() + Chariot.review();
    }
    
    @Override
    public PieceColor color(){
    	return _color;
    }
    
    @Override
    public PieceType type(){
    	return Chariot;
    }
    
    @Override
    public boolean makeValidMove(int a , int b){
    	if(_game.get(a,b)!=null && _game.get(a, b).color()==_color){
    		System.out.println("Cung mau");
    		return false;
    	}
    	else if(a == _x){
    		if(b == _y) {System.out.println("Trung nhau");return false;}
    		int temp = (b -_y)/ Math.abs(b - _y);
    		for(int i = _y+temp;i!=b;i+=temp){
    			if(_game.get(_x, i)!=null){
    			
    				return false;
    			}
    		}
    		Move move = new Move(this,_x,_y,_game.get(a, b),a,b);
    		return makeMoveCarefull(move);
    	}
    	else if(b == _y){
    		int temp = (a- _x)/Math.abs(a-_x);
    		for(int i =_x+temp;i!=a;i+=temp){
    			if(_game.get(i, _y)!=null){
    			
    				return false;
    			}
    		}
    		Move move = new Move(this,_x,_y,_game.get(a, b),a,b);
    		return makeMoveCarefull(move);
    	}
    	else {System.out.println("Ko quy tac "+_x+_y+a+b);return false;}
    }
    @Override
    public void setLocation(int x, int y){
    	_x =x;
    	_y =y;
    }
    

    
    @Override
    public boolean canCapture(int a,int b){
    	if(_x == a && _y == b) return false;
    	if(a == _x){
    		int temp = (b-_y)/Math.abs(b-_y);
    		for(int i = _y+temp; i!=b; i+=temp){
    			if(_game.get(_x, i)!=null){
    				return false;
    			}
    		}
    		return true;
    	}
    	else if(b== _y){
    		int temp = (a-_x)/Math.abs(a-_x);
    		for(int i =_x+temp;i!=a; i+=temp){
    			if(_game.get(i, _y)!=null){
    				return false;
    			}
    		}
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    @Override
    public boolean makeMoveCarefull(Move move){
    	_game.makeMove(move);
    	if(_game.inCheck(_game.turn().opposite())){
    		_game.undoMove();
    		System.out.println("Tuong bi an");
    		return false;
    	}
    	else {
    		setLocation(move.get_x2(), move.get_y2());
    		
    		return true;
    	}
    }

}
