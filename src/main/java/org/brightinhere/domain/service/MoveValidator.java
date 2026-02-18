package org.brightinhere.domain.service;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.Color;
import org.brightinhere.domain.model.MoveCommand;

public interface MoveValidator {

    ValidationResult validate(Board board,
                              MoveCommand command,
                              Color currentTurn);
}
