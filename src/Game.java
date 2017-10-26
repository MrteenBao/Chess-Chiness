package Chess;

import java.util.ArrayList;
import java.util.List;
import static Chess.PieceColor.*;

public class Game {
	/*Location of selected of this piece*/
	private int _selectedX;   // x= 0,...,9
	private int _selectedY;		// y = 0,....,8
	
	//private General _blackGe;
	//private General _whileGe;
	
	private List<Move> _moves;
	
	private PieceColor _turn;
	
	private Piece[][] _board;
	
	
	private General _whileGe;
	private General _blackGe;
	
	
    /** Sets the selected piece's x-location to X. */
    public void setSelectedX(int x) {
        _selectedX = x;
    }

    /** Sets the selected piece's y-location to Y. */
    public void setSelectedY(int y) {
        _selectedY = y;
    }

	/*Access parameter private from another class*/
	public int selectedX(){
		return _selectedX;
	}
	
	public int selectedY(){
		return _selectedY;
	}
	
	public PieceColor turn(){
		return _turn;
	}
	
	public Piece[][] board(){
		return _board;
	}
    /** Returns the piece present at column I and row J. */
    public Piece get(int i, int j) {
        return _board[i][j];
    }
	
	
	public int generalX (PieceColor color){
		if(color == WHILE){
			return _whileGe.get_selectedX();
		}
		return _blackGe.get_selectedX();
	}
	
	public int generalY (PieceColor color){
		if(color == WHILE){
			return _whileGe.get_selectedY();
		}
		return _blackGe.get_selectedY();
	}
	/*Constructor*/
	Game(){
		_moves = new ArrayList<Move>();
		newGame();
		
	}
	
	/*Create new game */
	public void newGame(){
		initBoard();
		_moves.clear();
		_turn = WHILE;
		_selectedX = -1;
		_selectedY = -1;
	}
	
	/*Quit game*/
	public void quit(){
		System.exit(0);
	}
	
	public Piece lastMover(){
		return _moves.get(_moves.size()-1).movedPiece();
	}
	
//	public boolean noMove(){
//		for(int i =0 ;i<10;i++){
//			for(int j =0;i<9;j++){
//				Piece p = this.get(i, j);
//				if(p!=null && p.color() == this._turn){
//	
//				}
//			}
//		}
//	}
	/*Undo last move */
	public void undoMove(){
		if(_moves.size() > 0){
			Move lastMove = _moves.remove(_moves.size()-1);
			makeMove(lastMove.undoMove());
			if(lastMove.get_target()!=null){
				_board[lastMove.get_x2()][lastMove.get_y2()]=lastMove.get_target();
			}
			_moves.remove(_moves.size()-1);
		}
	}
	/*Make move valid*/
	public void makeMove(Move move){
		_moves.add(move);
		excuteMove(move);
		_turn = _turn.opposite();
	}
	
	/*Execute the single move*/
	public void excuteMove(Move move){
			System.out.println("CAp nhat vi tri");
			_board[move.get_x1()][move.get_y1()] = null;
			_board[move.get_x2()][move.get_y2()] = move.get_selected();
	}
	public boolean inCheck(PieceColor color){

		 int x1 = generalX(color);
		 int y1 = generalY(color);
		 int x2 = generalX(color.opposite());
		 int y2 = generalY(color.opposite());
			System.out.println("INCHECK: "+ _selectedX+_selectedY+x1+y1);
		 //Check captured general
		 for(int i = 0;i < 10; i++){
			 for(int j = 0;j < 9; j++){
				 Piece p = get(i,j);
				 
				 if(p!=null && p.color() == _turn && p.canCapture(x1,y1)){
					 System.out.println("Tuong bi chieu");
					 return true;
				 }

			 }
		 }
		 //Check two general
		 if(y1 == y2){
			 
			 int temp = (x1 - x2)/Math.abs(x1 - x2);
			 for(int i = x2;i != x1;i+=temp){
				 if(get(i,y1)!=null) return false;
			 }
		 }

		 return false;
	 }
	public void initBoard(){
		// black Pieces
		Piece bCha1 = new Chariot(BLACK, this, 0, 0);
		Piece bHor1 = new Horse(BLACK, this,   0, 1);
		Piece bEle1 = new Elephant(BLACK,this, 0, 2);
		Piece bAdv1 = new Advisor(BLACK, this, 0, 3);
	_blackGe = new General(BLACK,this, 0, 4);
		Piece bAdv2 = new Advisor(BLACK, this, 0, 5);
		Piece bEle2 = new Elephant(BLACK,this, 0, 6);
		Piece bHor2 = new Horse(BLACK, this,   0, 7);
		Piece bCha2 = new Chariot(BLACK, this, 0, 8);
		Piece bCan1 = new Cannon(BLACK, this, 2, 1);
		Piece bCan2 = new Cannon(BLACK, this, 2, 7);
		Piece bSol1 = new Soldier(BLACK, this, 3, 0);
		Piece bSol2 = new Soldier(BLACK, this, 3, 2);
		Piece bSol3 = new Soldier(BLACK, this, 3, 4);
		Piece bSol4 = new Soldier(BLACK, this, 3, 6);
		Piece bSol5 = new Soldier(BLACK, this, 3, 8);
		
		//while Pieces 
		Piece tCha1 = new Chariot(WHILE, this, 9, 0);
		Piece tHor1 = new Horse(WHILE,   this, 9, 1);
		Piece tEle1 = new Elephant(WHILE,this, 9, 2);
		Piece tAdv1 = new Advisor(WHILE, this, 9, 3);
		_whileGe = new General(WHILE,this, 9, 4);
		Piece tAdv2 = new Advisor(WHILE, this, 9, 5);
		Piece tEle2 = new Elephant(WHILE,this, 9, 6);
		Piece tHor2 = new Horse(WHILE, this,   9, 7);
		Piece tCha2 = new Chariot(WHILE,this,  9, 8);
		Piece tCan1 = new Cannon(WHILE,this, 7, 1);
		Piece tCan2 = new Cannon(WHILE,this, 7, 7);
		Piece tSol1 = new Soldier(WHILE, this, 6, 0);
		Piece tSol2 = new Soldier(WHILE, this, 6, 2);
		Piece tSol3 = new Soldier(WHILE, this, 6, 4);
		Piece tSol4 = new Soldier(WHILE, this, 6, 6);
		Piece tSol5 = new Soldier(WHILE, this, 6, 8);
		
		Piece[][] board={{bCha1,  bHor1,	bEle1,	 bAdv1,	  _blackGe,	  bAdv2,	bEle2,	bHor2,	bCha2},
						 {null,	  null ,    null ,   null ,   null,   null,     null,   null,   null},
						 {null,   bCan1,    null,    null,    null,	  null,     null,   bCan2,  null},
						 {bSol1,  null,     bSol2,   null,    bSol3,  null,     bSol4,  null,   bSol5},
						 {null,	  null ,    null ,   null ,   null,   null,     null,   null,   null},
						 {null,	  null ,    null ,   null ,   null,   null,     null,   null,   null},
						 {tSol1,  null,     tSol2,   null,    tSol3,  null,     tSol4,  null,   tSol5},
						 {null,   tCan1,    null,    null,    null,   null,     null,   tCan2,  null},
						 {null,	  null ,    null ,   null ,   null,   null,     null,   null,   null},
						 {tCha1,  tHor1,	tEle1,	 tAdv1,	  _whileGe,	  tAdv2,	tEle2,	tHor2,	tCha2}};
		_board = board;
		System.out.println(board[9][0].imageString()+board[8][0]);

	}
	 
	
}
