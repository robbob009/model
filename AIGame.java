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
        ArrayList<Move> moves = game.getAvailableMoves();
        boolean illegalMove = true;
        int randMove = 0;

            randMove = rand.nextInt(moves.size());


// Piece[][] chessBoard = game.getBoard();
// for (int ii = 0; ii < 8; ii++)
// {
// for (int jj = 0; jj < 8; jj++)
// {
// if (chessBoard[ii][jj] != null)
// {
// System.out.println(chessBoard[ii][jj].toString());
// }
// }
// }


        game.move(moves.get(randMove));

        if (moves.get(randMove).getPiece().getIsWhite())
        {
            output += "White: ";
        }
        else
        {
            output += "Black: ";
        }

        output += moves.get(randMove).getNotation();

        return output;

    }

}
