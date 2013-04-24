package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * // -------------------------------------------------------------------------
 * /** Tries to get a very simplistic AI to work (Random moves)
 *
 * @author Robert Scheible (scheible)
 * @version Apr 11, 2013
 * @author Loran S
 */
public class AIGame
{

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
        int randMove = 0;

        randMove = rand.nextInt(moves.size());

        game.move(moves.get(randMove));
        game.endTurn();

        if (moves.get(randMove).getPiece().getIsWhite())
        {
            output += "White: ";
        }
        else
        {
            output += "Black: ";
        }

//        if (moves.get(randMove).getPiece().getIsWhite())
//        {
//            System.out.println(game.getWhitePieces()[moves.get(randMove)
//                .getPiece().getInColorArray()].toString());
//        }
//        else
//        {
//            System.out.println(game.getBlackPieces()[moves.get(randMove)
//                .getPiece().getInColorArray()].toString());
//        }

        output += moves.get(randMove).getNotation();

        return output;
    }


    //TODO: Add position analysis

    //TODO: Add stack of games

    //TODO: Add Openings

    //TODO: Add Endings
}
