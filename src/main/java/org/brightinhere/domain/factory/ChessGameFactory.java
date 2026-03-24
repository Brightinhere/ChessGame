package org.brightinhere.domain.factory;

import org.brightinhere.domain.model.ChessGame;
import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.enums.GameStatus;
import org.brightinhere.domain.service.*;

import java.util.UUID;

public final class ChessGameFactory {

    private ChessGameFactory() {}

    public static ChessGame createStandardGame(UUID id) {

        MoveExecutor executor = new DefaultMoveExecutor();
        CheckDetector checkDetector = new CheckDetector();
        MoveValidator validator =
                new DefaultMoveValidator(checkDetector, executor);

        return new ChessGame(
                id,
                BoardFactory.createStandardBoard(),
                Color.WHITE,
                GameStatus.IN_PROGRESS,
                validator,
                executor
        );
    }
}
