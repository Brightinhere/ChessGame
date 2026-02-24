package org.brightinhere.domain.service;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.Square;
import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.piece.Piece;

import java.util.Map;
import java.util.Set;

public class CheckDetector {

    public boolean isKingInCheck(Board board, Color color) {

        Square kingSquare = board.findKing(color)
                .orElseThrow(() -> new IllegalStateException("King not found"));

        Color opponent = color.opposite();

        for (Map.Entry<Square, Piece> entry : board.getPieces().entrySet()) {

            if (entry.getValue().getColor() != opponent) continue;

            Set<Square> attacks =
                    entry.getValue().generateMoves(board, entry.getKey());

            if (attacks.contains(kingSquare)) {
                return true;
            }
        }

        return false;
    }
}