package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;

	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		// Above - Acima;
		pos.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// Below - Para Baixo;
		pos.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// Left - Para Esquerda;
		pos.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// Right - Para Direita;
		pos.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// Nw - Noroeste;
		pos.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// Ne - Nordeste;
		pos.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// Sw - sudoeste;
		pos.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// Se - sudeste;
		pos.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// # SpecialMove Castling;

		if (getMoveCount() == 0 && !chessMatch.getCheck()) {

			// # SpecialMove Castling KingSide Rook;

			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(posT1)) {
				Position position_1 = new Position(position.getRow(), position.getColumn() + 1);
				Position position_2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(position_1) == null && getBoard().piece(position_2) == null) {
					matriz[position.getRow()][position.getColumn() + 2] = true;
				}
			}

			// # SpecialMove Castling QueenSide Rook;

			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(posT2)) {
				Position position_1 = new Position(position.getRow(), position.getColumn() - 1);
				Position position_2 = new Position(position.getRow(), position.getColumn() - 2);
				Position position_3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(position_1) == null && getBoard().piece(position_2) == null
						&& getBoard().piece(position_3) == null) {
					matriz[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}

		return matriz;
	}

}
