package org.brightinhere.domain.model;

import org.brightinhere.domain.model.enums.PieceType;

public record MoveCommand(
        Square from,
        Square to,
        PieceType promotion // nullable
) {}
