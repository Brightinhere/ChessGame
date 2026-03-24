package org.brightinhere.domain.service;

import org.brightinhere.domain.model.Board;
import org.brightinhere.domain.model.MoveCommand;
import org.brightinhere.domain.model.Square;
import org.brightinhere.domain.model.ValidationResult;
import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.piece.Piece;

import java.util.Optional;
import java.util.Set;

public class DefaultMoveValidator implements MoveValidator {
    private final CheckDetector checkDetector;
    private final MoveExecutor moveExecutor;

    public DefaultMoveValidator(CheckDetector checkDetector, MoveExecutor moveExecutor) {
        this.checkDetector = checkDetector;
        this.moveExecutor = moveExecutor;
    }

    @Override
    public ValidationResult validate(Board board, MoveCommand command, Color currentTurn) {

        Optional<Piece> pieceOpt = board.getPiece(command.from());

        if (pieceOpt.isEmpty()) return ValidationResult.invalid("No piece on square");

        Piece piece = pieceOpt.get();

        if (piece.getColor() != currentTurn) return ValidationResult.invalid("Not your turn");

        Set<Square> moves = piece.generateMoves(board, command.from());

        if (!moves.contains(command.to())) return ValidationResult.invalid("Illegal move");

        // Check king safety
        Board simulated = board.movePiece(command.from(), command.to());

        if (isKingInCheck(simulated, currentTurn)) return ValidationResult.invalid("Move leaves king in check");

        return ValidationResult.success();
    }

    public boolean isKingInCheck(Board board, Color color) {
        return checkDetector.isKingInCheck(board, color);
    }
}
