package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null;               // N�o � necess�rio atribuir. Se n�o colocar o Java assume como null;
	}

	protected Board getBoard() {
		return board;
	}
	
	


	
	

}
