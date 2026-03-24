package org.brightinhere.domain.model.piece;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.Square;
import org.brightinhere.domain.model.enums.Color;

import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public Set<Square> generateMoves(Board board, Square from) {
        return Set.of();
    }
    // TODO: Implement

}
