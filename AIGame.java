package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * // -------------------------------------------------------------------------
 * /** Tries to get a very simplistic AI to work (Random moves)
 *
 * @author Robert Scheible (scheible)
 * @version Apr 11, 2013
 */
public class AIGame
{

    // ----------------------------------------------------------

    // ----------------------------------------------------------
    /**
     * Attempts to make a random move.
     *
     * @param game
     *            the game in which the AI is playing
     * @return the move in chess notation
     */
    public String run(Game game)
    {
        String output = "";
        Random rand = new Random();
        Piece[] pieces;
        Boolean whiteTurn = game.getWhiteTurn();
        if (whiteTurn)
        {
            pieces = game.getWhitePieces();
        }
        else
        {
            pieces = game.getBlackPieces();
        }

        ArrayList<Piece> piecesWithMoves = new ArrayList<Piece>();
        ArrayList<Location> movesWithPieces = new ArrayList<Location>();
        for (Piece piece : pieces)
        {
            if (piece != null)
            {
                for (Location move : piece.getLegalMoves(game.getBoard()))
                {
                    piecesWithMoves.add(piece);
                    movesWithPieces.add(move);
                }
            }
        }

        boolean illegalMove = true;
        int posInMoveArray = 0;
        while (illegalMove)
        {

            posInMoveArray = rand.nextInt(movesWithPieces.size());
            if (!game.isLegalMove(
                piecesWithMoves.get(posInMoveArray),
                movesWithPieces.get(posInMoveArray)))
            {

                piecesWithMoves.remove(posInMoveArray);
                movesWithPieces.remove(posInMoveArray);
                continue;
            }
            illegalMove = false;

//            Piece[][] chessBoard = game.getBoard();
//            for (int ii = 0; ii < 8; ii++)
//            {
//                for (int jj = 0; jj < 8; jj++)
//                {
//                    if (chessBoard[ii][jj] != null)
//                    {
//                        System.out.println(chessBoard[ii][jj].toString());
//                    }
//                }
//            }
        }

        game.move(
            piecesWithMoves.get(posInMoveArray),
            movesWithPieces.get(posInMoveArray));

        if (whiteTurn)
        {
            output += "White: ";
        }
        else
        {
            output += "Black: ";
        }

        output +=
            movesWithPieces.get(posInMoveArray).toString(
                piecesWithMoves.get(posInMoveArray));

        // board.print();
        return output;

    }

}
