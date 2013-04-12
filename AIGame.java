package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tries to get a very simplistic AI to work (Random moves)
 *
 *  @author Robert Scheible (scheible)
 *  @version Apr 11, 2013
 */
public class AIGame
{
    private Chessboard board;


    // ----------------------------------------------------------

    public String run(Chessboard board)
    {
        boolean cont = true;
        String output = "";
        while (cont)
        {
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

            Piece piece = null;
            while (piece == null)
            {
                piece = pieces[rand.nextInt(15)];
            }
            ArrayList<Location> legalMoves = piece.getLegalMoves();
            if (legalMoves.isEmpty())
            {
                continue;
            }

            Location move = legalMoves.get(rand.nextInt(legalMoves.size()));

            if (!board.isLegalMove(piece, move))
            {
                continue;
            }

            board.move(piece, move);

            if (whiteTurn)
            {
                output += "White: ";
            }
            else
            {
                output += "Black: ";
            }

            output += move.toString(piece);
            cont = false;
        }
        return output;

    }

}
