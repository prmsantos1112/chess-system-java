package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			pos.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
				matriz[pos.getRow()][pos.getColumn()] = true;
			}

			pos.setValues(position.getRow() - 2, position.getColumn());
			Position position_1 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)
					&& getBoard().positionExists(position_1) && !getBoard().thereIsAPiece(position_1)
					&& getMoveCount() == 0) {
				matriz[pos.getRow()][pos.getColumn()] = true;
			}

			pos.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				matriz[pos.getRow()][pos.getColumn()] = true;
			}

			pos.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				matriz[pos.getRow()][pos.getColumn()] = true;

			}

			// #SpecialMove En Passant(White);

			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getRow() - 1][left.getColumn()] = true;
				}

				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matriz[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}

		else {
			pos.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
				matriz[pos.getRow()][pos.getColumn()] = true;
			}

			pos.setValues(position.getRow() + 2, position.getColumn());
			Position position_2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)
					&& getBoard().positionExists(position_2) && !getBoard().thereIsAPiece(position_2)
					&& getMoveCount() == 0) {
				matriz[pos.getRow()][pos.getColumn()] = true;
			}

			pos.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				matriz[pos.getRow()][pos.getColumn()] = true;
			}

			pos.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				matriz[pos.getRow()][pos.getColumn()] = true;

			}

			// #SpecialMove En Passant(Black);

			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getRow() + 1][left.getColumn()] = true;
				}

				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matriz[right.getRow() + 1][right.getColumn()] = true;
				}
			}

		}
		return matriz;
	}

	@Override
	public String toString() {
		return "P";

	}
}
