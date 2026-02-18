package org.brightinhere.domain.model;

public record MoveResult(
        boolean success,
        String message,
        GameStatus status,
        Board board
) {}

