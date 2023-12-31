package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getRows()];

        Position p = new Position(0, 0);

        //above
        colorPossibleMoves(p, mat, -1, 0);

        //below
        colorPossibleMoves(p, mat, 1, 0);

        //left
        colorPossibleMoves(p, mat, 0, -1);

        //right
        colorPossibleMoves(p, mat, 0, 1);

        return mat;
    }

    public void colorPossibleMoves(Position p, boolean[][] mat, int row, int column) {
        p.setValues(position.getRow() + row, position.getColumn() + column);

        while (getBoard().positionExists(p) && !getBoard().thereisAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;

            p.setColumn(p.getColumn() + column);
            p.setRow(p.getRow() + row);

        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }
}
