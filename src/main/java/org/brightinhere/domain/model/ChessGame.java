package org.brightinhere.domain.model;

import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.enums.GameStatus;
import org.brightinhere.domain.service.MoveExecutor;
import org.brightinhere.domain.service.MoveValidator;

import java.util.List;
import java.util.UUID;

public class ChessGame {

    private final UUID id;
    private Board board;
    private Color currentTurn;
    private GameStatus status;
    private final List<MoveCommand> moveHistory;

    private final MoveValidator validator;
    private final MoveExecutor executor;

    public MoveResult handle(MoveCommand command) {

        if (status != GameStatus.IN_PROGRESS) {
            return new MoveResult(false, "Game already finished", status, board);
        }

        ValidationResult validation = validator.validate(board, command, currentTurn);

        if (!validation.isValid()) {
            return new MoveResult(false, validation.message(), status, board);
        }

        Board newBoard = executor.execute(board, command);

        board = newBoard;
        moveHistory.add(command);
        currentTurn = currentTurn.opposite();

        updateGameStatus();

        return new MoveResult(true, "Move applied", status, board);
    }
}
