package org.brightinhere.domain.model;

import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.piece.Piece;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import java.util.*;

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

        if (piece == null) {
            throw new IllegalStateException("No piece at square: " + from);
        }

        newPieces.put(to, piece);

        return new Board(newPieces);
    }

    public Optional<Square> findKing(Color color) {
        return pieces.entrySet()
                .stream()
                .filter(entry ->
                        entry.getValue().getColor() == color &&
                                entry.getValue().isKing()
                )
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
