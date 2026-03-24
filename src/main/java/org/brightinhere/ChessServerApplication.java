package org.brightinhere;

import org.brightinhere.domain.factory.ChessGameFactory;
import org.brightinhere.domain.model.*;
import org.brightinhere.domain.model.piece.Piece;

import java.util.Map;
import java.util.UUID;

public class ChessServerApplication {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        ChessGame chessGame = ChessGameFactory.createStandardGame(UUID.randomUUID());
        chessGame.displayBoard();


        MoveCommand move = new MoveCommand(
                new Square(1, 1),
                new Square(1, 2),
                null
        );

        MoveResult result = chessGame.handle(move);
        chessGame.displayBoard();

        System.out.println(result.message());
        System.out.println("Chess game created with ID: " + chessGame.getId());
    }
}



