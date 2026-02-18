package org.brightinhere.domain.model;

public record MoveCommand(
        Square from,
        Square to,
        PieceType promotion // nullable
) {}
