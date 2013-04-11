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
        ArrayList<int[]> legalMoves = piece.getLegalMoves();
        if (legalMoves.isEmpty())
        {
            run(board);
            return "";
        }

        int[] move = legalMoves.get(rand.nextInt(legalMoves.size()));

        if (!board.isLegalMove(piece, move[0], move[1]))
        {
            run(board);
            return "";
        }

        board.move(piece, move[0], move[1]);
        String output = "";

        if (whiteTurn)
        {
            output += "White: ";
        }
        else
        {
            output += "Black: ";
        }

        if (piece.getClass() == King.class)
        {
            output += "K";
        }
        else if (piece.getClass() == Queen.class)
        {
            output += "Q";
        }
        else if (piece.getClass() == Rook.class)
        {
            output += "R";
        }
        else if (piece.getClass() == Bishop.class)
        {
            output += "B";
        }
        else if (piece.getClass() == Knight.class)
        {
            output += "K";
        }

        switch (move[0])
        {
            case (0):
                output += "a";
            case (1):
                output += "b";
            case (2):
                output += "c";
            case (3):
                output += "d";
            case (4):
                output += "e";
            case (5):
                output += "f";
            case (6):
                output += "g";
            case (7):
                output += "h";
        }

        output += (8 - move[1]);

        return output;
    }

}
