package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null;               // Não é necessário atribuir. Se não colocar o Java assume como null;
	}

	protected Board getBoard() {
		return board;
	}
	
	


	
	

}
