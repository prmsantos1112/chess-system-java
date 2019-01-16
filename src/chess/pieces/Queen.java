package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		// Above - Acima;

		pos.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		// Left - Esquerda;

		pos.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		// Right - Direita;

		pos.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		// Below - Para Baixo;

		pos.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		// Nw - Noroeste;

		pos.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setValues(pos.getRow() - 1, pos.getColumn() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		// Ne - Nordeste;

		pos.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setValues(pos.getRow() - 1, pos.getColumn() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		// Se - Sudeste;

		pos.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setValues(pos.getRow() + 1, pos.getColumn() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		// Sw - Sudoeste;

		pos.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setValues(pos.getRow() + 1, pos.getColumn() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;

		}

		return matriz;
	}

}
