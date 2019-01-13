package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null; // N�o � necess�rio atribuir. Se n�o colocar o Java assume como null;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	// Abaixo; M�todo concreto utilizando um m�todo abstrato; Gancho com a subclasse;
	// Template Metod;
	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];

	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] matriz = possibleMoves();
		
		for (int i = 0; i < matriz.length; i ++) {
			for (int j = 0; j < matriz.length; j ++) {
				if (matriz[i][j]) {
					return true;
				}
			}
		}
		return false;		
	}
	

}
