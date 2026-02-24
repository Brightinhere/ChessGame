package org.brightinhere.domain.model;

import org.brightinhere.domain.model.enums.GameStatus;

public record MoveResult(
        boolean success,
        String message,
        GameStatus status,
        Board board
) {}

