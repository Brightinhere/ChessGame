package org.brightinhere.domain.service;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.MoveCommand;

public class DefaultMoveExecutor implements MoveExecutor{
    @Override
    public Board execute(Board board, MoveCommand command) {
        return board.movePiece(command.from(), command.to());
    }
}
