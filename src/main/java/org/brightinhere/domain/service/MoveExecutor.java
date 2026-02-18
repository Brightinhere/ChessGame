package org.brightinhere.domain.service;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.MoveCommand;

public interface MoveExecutor {
    Board execute(Board board, MoveCommand command);
}

