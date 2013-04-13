package model;

import java.util.Set;
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
     * @param board
     *            the board the move is being made on
     * @return the move in chess notation
     */
    public String run(Chessboard board)
    {
        boolean cont = true;
        String output = "";
        int numRuns = 0;
        Random rand = new Random();
        Piece[] pieces;
        Boolean whiteTurn = board.getWhiteTurn();
        if (whiteTurn)
        {
            pieces = board.getWhitePieces();
        }
        else
        {
            pieces = board.getBlackPieces();
        }

        ArrayList<Piece> piecesWithMoves = new ArrayList<Piece>();
        ArrayList<Location> movesWithPieces = new ArrayList<Location>();
        for (Piece piece : pieces)
        {
            if (piece != null)
            {
                for (Location move : piece.getLegalMoves())
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
            if (!board.isLegalMove(
                piecesWithMoves.get(posInMoveArray),
                movesWithPieces.get(posInMoveArray)))
            {

                piecesWithMoves.remove(posInMoveArray);
                piecesWithMoves.remove(posInMoveArray);
                continue;
            }
            illegalMove = false;
        }

        board.move(
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
        output += "-- ";
        output +=
            piecesWithMoves.get(posInMoveArray).getClass() + ", "
                + piecesWithMoves.get(posInMoveArray).getIsWhite() + ", "
                + piecesWithMoves.get(posInMoveArray).getInColorArray();
        cont = false;

        // board.print();
        return output;

    }

}
