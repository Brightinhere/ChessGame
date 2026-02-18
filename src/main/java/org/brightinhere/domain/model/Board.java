package org.brightinhere.domain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {

    private final Map<Square, Piece> pieces;

    public Board(Map<Square, Piece> pieces) {
        this.pieces = Map.copyOf(pieces);
    }

    public Optional<Piece> getPiece(Square square) {
        return Optional.ofNullable(pieces.get(square));
    }

    public Map<Square, Piece> getPieces() {
        return pieces;
    }

    public Board movePiece(Square from, Square to) {
        Map<Square, Piece> newPieces = new HashMap<>(pieces);

        Piece piece = newPieces.remove(from);
        newPieces.put(to, piece);

        return new Board(newPieces);
    }
}
