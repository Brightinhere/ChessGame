package org.brightinhere.domain.model.piece;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.Square;
import org.brightinhere.domain.service.BoardUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public Set<Square> generateMoves(Board board, Square from) {

        Set<Square> moves = new HashSet<>();

        int[][] offsets = {
                {2, 1}, {2, -1},
                {-2, 1}, {-2, -1},
                {1, 2}, {1, -2},
                {-1, 2}, {-1, -2}
        };

        for (int[] offset : offsets) {
            int file = from.file() + offset[0];
            int rank = from.rank() + offset[1];

            if (!BoardUtils.isInsideBoard(file, rank)) continue;

            Square target = new Square(file, rank);

            Optional<Piece> occupant = board.getPiece(target);

            if (occupant.isEmpty() ||
                    occupant.get().getColor() != this.color) {
                moves.add(target);
            }
        }

        return moves;
    }
}