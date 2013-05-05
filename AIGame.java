package model;

import java.util.Scanner;
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
    private Game game;


    // ----------------------------------------------------------
    /**
     * This is the play game method that plays a game
     */
    public void playGame()
    {
        game = new Game();
        while (true)
        {
            if (game.getWhiteTurn())
            {
                whiteAI();
            }
            else
            {
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                makeMove(input);
            }
            System.out.println(game.getLastMove().toString());
            game.print();
        }
    }


    // ----------------------------------------------------------
    /**
     * Methods for the white AI version
     */
    public void whiteAI()
    {
        ArrayList<Move> whiteMoves = game.getAvailableMoves();
        ArrayList<Double> whiteScores = new ArrayList<Double>(whiteMoves.size());

        for (int kk = 0; kk < whiteMoves.size(); kk++)
        {
            whiteScores.add(Double.POSITIVE_INFINITY);
        }

        int ii = 0;
        for (Move whiteMove : whiteMoves)
        {
            Game whiteGame =
                new Game(
                    game.getBoard(),
                    game.getWhitePieces(),
                    game.getBlackPieces(),
                    game.getWhiteTurn());

            whiteGame.move(whiteMove);
            whiteGame.endTurn();

            ArrayList<Move> blackMoves = whiteGame.getAvailableMoves();
            ArrayList<Double> blackScores = new ArrayList<Double>();

            for (Move blackMove : blackMoves)
            {
                Game blackGame =
                    new Game(
                        whiteGame.getBoard(),
                        whiteGame.getWhitePieces(),
                        whiteGame.getBlackPieces(),
                        whiteGame.getWhiteTurn());

                blackGame.move(blackMove);
                blackGame.endTurn();
                blackScores.add(analyzePosition(blackGame));
            }

            for (Double blackScore : blackScores)
            {
                if (whiteScores.get(ii) > blackScore)
                {
                    whiteScores.set(ii, blackScore);
                }
            }
            ii++;
        }

        double whiteScore = whiteScores.get(0);
        int index = 0;

        for (int jj = 1; jj < whiteScores.size(); jj++)
        {
            if (whiteScores.get(jj) > whiteScore)
            {
                // only comes up with one of
                // all moves that has the same score,
                // rather than random option
                whiteScore = whiteScores.get(jj);

                index = jj;
            }
        }

        game.move(whiteMoves.get(index));
        game.endTurn();
    }


    /**
     * Attempts to make a random move.
     *
     * @param game
     *            the game in which the AI is playing
     * @return the move in chess notation
     */
    public String run()
    {
        String output = "";
        Random rand = new Random();
        ArrayList<Move> moves = game.getAvailableMoves();
        ArrayList<Game> potentialGames = new ArrayList<Game>();

        double bestScore;
        if (game.getWhiteTurn())
        {
            bestScore = Double.MIN_VALUE;
        }
        else
        {
            bestScore = Double.MAX_VALUE;
        }

        double[] score = new double[moves.size()];
        int ii = 0;
        for (Move move : moves)
        {
            Game potentialGame =
                new Game(
                    game.getBoard(),
                    game.getWhitePieces(),
                    game.getBlackPieces(),
                    game.getWhiteTurn());

            potentialGame.move(move);
            potentialGame.endTurn();

            potentialGames.add(potentialGame);
        }

        for (Game possible : potentialGames)
        {
            ArrayList<Move> opponentMoves = possible.getAvailableMoves();
            ArrayList<Game> secondBoard = new ArrayList<Game>();

            double worstScore;
            if (possible.getWhiteTurn())
            {
                worstScore = Double.MIN_VALUE;
            }
            else
            {
                worstScore = Double.MAX_VALUE;
            }

            for (Move move : opponentMoves)
            {
                Game potentialGame =
                    new Game(
                        possible.getBoard(),
                        possible.getWhitePieces(),
                        possible.getBlackPieces(),
                        possible.getWhiteTurn());

                potentialGame.move(move);
                potentialGame.endTurn();

                potentialGames.add(potentialGame);
            }

        }
// double analysisScore = analyzePosition(potentialGame);
//
// if (game.getWhiteTurn() && analysisScore > bestScore)
// {
//
// bestScore = analysisScore;
// potentialGames = new ArrayList<Game>();
// potentialGames.add(potentialGame);
// }
// else if (!game.getWhiteTurn() && analysisScore < bestScore)
// {
// bestScore = analysisScore;
// potentialGames = new ArrayList<Game>();
// potentialGames.add(potentialGame);
// }
// else if (analysisScore == bestScore)
// {
// potentialGames.add(potentialGame);
// }

        int randMove = rand.nextInt(potentialGames.size());

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

// if (moves.get(randMove).getPiece().getIsWhite())
// {
// System.out.println(game.getWhitePieces()[moves.get(randMove)
// .getPiece().getInColorArray()].toString());
// }
// else
// {
// System.out.println(game.getBlackPieces()[moves.get(randMove)
// .getPiece().getInColorArray()].toString());
// }

        output += game.getLastMove().getNotation();

        return output;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param notation is the string to move
     * @return the the string of the move made and any pieces taken
     */
    public String makeMove(String notation)
    {
        Move nextMove = null;
        for (Move move : game.getAvailableMoves())
        {
            if (move.getNotation().equalsIgnoreCase(notation))
            {
                nextMove = move;
                break;
            }
        }

        if (nextMove == null)
        {
            return "Invalid move";
        }

        game.move(nextMove);
        game.endTurn();

        String output = "";
        if (nextMove.getPiece().getIsWhite())
        {
            output += "White: ";
        }
        else
        {
            output += "Black: ";
        }
        output += nextMove.getNotation();
        return output;
    }


    /**
     * Provides a numerical value for the position If the number is positive,
     * white is ahead. If the number is negative, black is ahead. if the number
     * is zero, the game is evenly matched.
     *
     * @param game1
     *            The game position being analyzed
     *            @return is the number analysis of the position
     */
    public double analyzePosition(Game game1)
    {
        double total = 0;

        // Point value for having the piece
        for (Piece piece : game1.getWhitePieces())
        {
            if (piece != null)
            {
                total += getNumValue(piece);
            }
        }

        for (Piece piece : game1.getBlackPieces())
        {
            if (piece != null)
            {
                total -= getNumValue(piece);
            }
        }

        // The move moves available, the better the position.
        // TODO: Get a better number for this.
        total +=
            (game.getWhiteAttackingMoves().size() - game
                .getBlackAttackingMoves().size()) * .1;

        return total;
    }


    /**
     * Gets the numerical value of the piece
     *
     * @param piece
     * @return is the num value of the piece
     */
    public int getNumValue(Piece piece)
    {
        if (piece.getClass() == Pawn.class)
        {
            return 1;
        }

        if (piece.getClass() == Knight.class
            || piece.getClass() == Bishop.class)
        {
            return 3;
        }

        if (piece.getClass() == Rook.class)
        {
            return 5;
        }

        if (piece.getClass() == Queen.class)
        {
            return 9;
        }

        return 0;
    }

    // TODO: Add position analysis

    // TODO: Add stack of games

    // TODO: Add Openings

    // TODO: Add Endings
}