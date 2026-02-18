package org.brightinhere.domain.model;

public abstract class Piece {

    protected final Color color;

    protected Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract Set<Square> generateMoves(Board board, Square from);
}


