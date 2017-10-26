package Chess;


public enum PieceType {
	/*Declare pieces of chess */
	Soldier, Chariot,Cannon,Horse ,General, Advisor, Elephant;
	/*Return clearly string of piece*/
	String review(){
		switch(this){
		case Soldier:
			return "Tot";
		case Chariot:
			return "Xe";
		case Cannon:
			return  "Phao";
		case Horse:
			return "Ma";
		case General:
			return "TUONG";
		case Advisor:
			return "Si";
		case Elephant:
			return "Tg";
		}
		return "-";
	}
}
