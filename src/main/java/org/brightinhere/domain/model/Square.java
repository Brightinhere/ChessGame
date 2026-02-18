package org.brightinhere.domain.model;

public record Square(int file, int rank) {

    public Square {
        if (file < 0 || file > 7 || rank < 0 || rank > 7) {
            throw new IllegalArgumentException("Invalid board coordinates");
        }
    }
}
