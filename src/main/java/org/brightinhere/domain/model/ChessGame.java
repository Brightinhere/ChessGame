package org.brightinhere.domain.model;

import org.brightinhere.domain.model.enums.Color;
import org.brightinhere.domain.model.enums.GameStatus;
import org.brightinhere.domain.service.MoveExecutor;
import org.brightinhere.domain.service.MoveValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChessGame {

    private final UUID id;
    private final List<MoveCommand> moveHistory;
    // Domain services
    private final MoveValidator validator;
    private final MoveExecutor executor;
    private Board board;
    private Color currentTurn;
    private GameStatus status;

    public ChessGame(UUID id,
                     Board board,
                     Color turn,
                     GameStatus status,
                     MoveValidator validator,
                     MoveExecutor executor) {
        this.id = id;
        this.board = board;
        this.currentTurn = turn;
        this.status = status;
        this.validator = validator;
        this.executor = executor;
        this.moveHistory = new ArrayList<>();
    }

    public MoveResult handle(MoveCommand command) {

        if (status != GameStatus.IN_PROGRESS) {
            return new MoveResult(false, "Game already finished", status, board);
        }

        ValidationResult validation =
                validator.validate(board, command, currentTurn);

        if (!validation.isValid()) {
            return new MoveResult(
                    false,
                    validation.message(),
                    status,
                    board
            );
        }

        // Apply move
        Board newBoard = executor.execute(board, command);
        board = newBoard;

        moveHistory.add(command);

        // Update status (check detection) TODO: Check if opponent is in check after move?
//        updateStatus();

        // Switch turn
        currentTurn = currentTurn.opposite();

        return new MoveResult(
                true,
                "Move applied",
                status,
                board
        );
    }

    private void updateStatus() {
//        Color opponent = currentTurn.opposite();
//        if (checkDetector.isKingInCheck(board, opponent)) {
//            status = GameStatus.CHECK;
//        } else {
//            status = GameStatus.IN_PROGRESS;
//        }
//
//        // Checkmate & stalemate later
    }

    // --- Getters ---

    public UUID getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public Color getCurrentTurn() {
        return currentTurn;
    }

    public GameStatus getStatus() {
        return status;
    }

    public List<MoveCommand> getMoveHistory() {
        return List.copyOf(moveHistory);
    }

    // Print the board to console (for testing)
    public void displayBoard() {
        System.out.println("Board:");
        for (int rank = 7; rank >= 0; rank--) {
            for (int file = 0; file < 8; file++) {
                Square square = new Square(file, rank);
                board.getPiece(square)
                        .ifPresentOrElse(
                                piece -> System.out.print(piece.getClass().getSimpleName().charAt(0) + " "),
                                () -> System.out.print(". ")
                        );
            }
            System.out.println();
        }
    }

}