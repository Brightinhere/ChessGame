package org.brightinhere.domain.factory;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.Square;
import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.piece.*;

import java.util.HashMap;
import java.util.Map;

public final class BoardFactory {

    private BoardFactory() {}

    public static Board createStandardBoard() {

        Map<Square, Piece> pieces = new HashMap<>();

        // --- White pieces ---

        pieces.put(new Square(0, 0), new Rook(Color.WHITE));
        pieces.put(new Square(1, 0), new Knight(Color.WHITE));
        pieces.put(new Square(2, 0), new Bishop(Color.WHITE));
        pieces.put(new Square(3, 0), new Queen(Color.WHITE));
        pieces.put(new Square(4, 0), new King(Color.WHITE));
        pieces.put(new Square(5, 0), new Bishop(Color.WHITE));
        pieces.put(new Square(6, 0), new Knight(Color.WHITE));
        pieces.put(new Square(7, 0), new Rook(Color.WHITE));

        for (int file = 0; file < 8; file++) {
            pieces.put(new Square(file, 1), new Pawn(Color.WHITE));
        }

        // --- Black pieces ---

        pieces.put(new Square(0, 7), new Rook(Color.BLACK));
        pieces.put(new Square(1, 7), new Knight(Color.BLACK));
        pieces.put(new Square(2, 7), new Bishop(Color.BLACK));
        pieces.put(new Square(3, 7), new Queen(Color.BLACK));
        pieces.put(new Square(4, 7), new King(Color.BLACK));
        pieces.put(new Square(5, 7), new Bishop(Color.BLACK));
        pieces.put(new Square(6, 7), new Knight(Color.BLACK));
        pieces.put(new Square(7, 7), new Rook(Color.BLACK));

        for (int file = 0; file < 8; file++) {
            pieces.put(new Square(file, 6), new Pawn(Color.BLACK));
        }

        return new Board(pieces);
    }
}