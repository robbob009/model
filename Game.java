package model;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Chessboard World Holds the instructions, Pieces, and Square highlights
 * referred to as glows. Checks for end game conditions.
 *
 * @author Loran Steinberger (bkwrm215)
 * @author Robert Scheible (scheible)
 * @author Jack Cobb (jack3)
 * @version (2012.12.03)
 */
public class Game
{
    // ~ Fields ................................................................

    // The Board is an 8x8 array of pieces, with board[x][y]
    // board[0][0] is equivalent to a8, board[0][7] is a1,
    // board[7][0] is h8, board[7][7] is h1
    private Piece[][] board;
    private Piece[]   whitePieces;
    private Piece[]   blackPieces;

    private boolean   whiteTurn;


    // ~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new ChessboardWhite object.
     */
    public Game()
    {
        // The Board is an 8x8 array of pieces, with board[x][y]
        // board[0][0] is equivalent to a8, board[0][7] is a1,
        // board[7][0] is h8, board[7][7] is h1
        board = new Piece[8][8];

        blackPieces = new Piece[16];
        whitePieces = new Piece[16];

        // Creates black pieces except pawns
        blackPieces[0] = board[0][0] = new Rook(false, new Location(0, 0), 0);
        blackPieces[1] = board[1][0] = new Knight(false, new Location(1, 0), 1);
        blackPieces[2] = board[2][0] = new Bishop(false, new Location(2, 0), 2);
        blackPieces[3] = board[3][0] = new Queen(false, new Location(3, 0), 3);
        blackPieces[4] = board[4][0] = new King(false, new Location(4, 0), 4);
        blackPieces[5] = board[5][0] = new Bishop(false, new Location(5, 0), 5);
        blackPieces[6] = board[6][0] = new Knight(false, new Location(6, 0), 6);
        blackPieces[7] = board[7][0] = new Rook(false, new Location(7, 0), 7);

        // Creates white pieces except pawns
        whitePieces[0] = board[0][7] = new Rook(true, new Location(0, 7), 0);
        whitePieces[1] = board[1][7] = new Knight(true, new Location(1, 7), 1);
        whitePieces[2] = board[2][7] = new Bishop(true, new Location(2, 7), 2);
        whitePieces[3] = board[3][7] = new Queen(true, new Location(3, 7), 3);
        whitePieces[4] = board[4][7] = new King(true, new Location(4, 7), 4);
        whitePieces[5] = board[5][7] = new Bishop(true, new Location(5, 7), 5);
        whitePieces[6] = board[6][7] = new Knight(true, new Location(6, 7), 6);
        whitePieces[7] = board[7][7] = new Rook(true, new Location(7, 7), 7);

        // Creates all pawns
        for (int ii = 0; ii < 8; ii++)
        {
            blackPieces[ii + 8] =
                board[ii][1] = new Pawn(false, new Location(ii, 1), ii + 7);
            whitePieces[ii + 8] =
                board[ii][6] = new Pawn(true, new Location(ii, 6), ii + 7);
        }

        whiteTurn = true;
    }


    // ~ Methods ...............................................................

    /**
     * Gets all possible moves for the current player.
     *
     * @return the possible moves.
     */
    public ArrayList<Move> getLegalMoves()
    {
        return getLegalMoves(getWhiteTurn());
    }


    // ----------------------------------------------------------
    /**
     * Returns an array of arraylists, containing a list of pieces and a
     * corresponding list of locations those pieces can move to.
     *
     * @param color
     *            The color of the piece
     * @return an array of arrayLists
     */
    public ArrayList<Move> getLegalMoves(boolean color)
    {
        ArrayList<Move> legalMoves = new ArrayList<Move>();
        Piece[] pieces;

        if (color)
        {
            pieces = getWhitePieces();
        }
        else
        {
            pieces = getBlackPieces();
        }

        for (Piece piece : pieces)
        {
            if (piece != null)
            {
                for (Move move : piece.getPossibleMoves(getBoard()))
                {
                    if (isLegalMove(move))
                    {
                        legalMoves.add(move);
                    }
                }
            }
        }
        return legalMoves;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the current player can make any moves. Otherwise, they have
     * been checkmated.
     */
    public void checkMate()
    {
        ArrayList<Move> possibleMoves = getLegalMoves();
        if (possibleMoves.isEmpty())
        {
            String output = "";
            if (getWhiteTurn())
            {
                output += "White ";
            }
            else
            {
                output += "Black ";
            }
            output += "has been checkmated!";
            System.out.println(output);
            System.exit(0);
        }

    }


    /**
     * Prints out the board, showing the positions of all pieces in console.
     * Does not show the color of each piece.
     */
    public void print()
    {
        for (int ii = 0; ii < 8; ii++)
        {
            for (int jj = 0; jj < 8; jj++)
            {
                Piece piece = board[jj][ii];
                if (piece == null)
                {
                    System.out.print("-");
                }
                else if (piece.getClass() == Knight.class)
                {
                    System.out.print("N");
                }
                else if (piece.getClass() == Bishop.class)
                {
                    System.out.print("B");
                }
                else if (piece.getClass() == Rook.class)
                {
                    System.out.print("R");
                }
                else if (piece.getClass() == Pawn.class)
                {
                    System.out.print("P");
                }
                else if (piece.getClass() == King.class)
                {
                    System.out.print("K");
                }
                else if (piece.getClass() == Queen.class)
                {
                    System.out.print("Q");
                }
            }
            System.out.println();
        }
    }


    /**
     * Returns the actual board
     *
     * @return board is the array holding all pieces
     */
    public Piece[][] getBoard()
    {
        return board;
    }


    /**
     * Sets the chessboard to the given board.
     *
     * @param board
     *            is a new chessboard.
     */
    public void setBoard(Piece[][] board)
    {
        this.board = board;
    }


    /**
     * Adds a piece to the board and the array of pieces
     *
     * @param piece
     *            is the piece being added to board.
     */
    public void add(Piece piece)
    {
        if (piece.getIsWhite())
        {
            whitePieces[piece.getInColorArray()] = piece;
        }
        else
        {
            blackPieces[piece.getInColorArray()] = piece;
        }

        board[piece.getLocal().x()][piece.getLocal().y()] = piece;
    }


    /**
     * Returns the array of all white pieces
     *
     * @return the white pieces
     */
    public Piece[] getWhitePieces()
    {
        return whitePieces;
    }


    /**
     * Sets the array of white pieces to whatever the new array is
     *
     * @param whitePieces
     *            is the pieces to be on the board
     */
    public void setWhitePieces(Piece[] whitePieces)
    {
        this.whitePieces = whitePieces;
    }


    /**
     * Returns the array of all black pieces
     *
     * @return the array of all black pieces
     */
    public Piece[] getBlackPieces()
    {
        return blackPieces;
    }


    /**
     * Sets the blackPieces to the new array passed in
     *
     * @param blackPieces
     *            the new array
     */
    public void setBlackPieces(Piece[] blackPieces)
    {
        this.blackPieces = blackPieces;
    }


    /**
     * Clear Board The world removes all actors and text images.
     */
    public void clearBoard()
    {
        for (int ii = 0; ii < 8; ii++)
        {
            for (int jj = 0; jj < 8; jj++)
            {
                board[ii][jj] = null;
            }
        }
        blackPieces = new Piece[16];
        whitePieces = new Piece[16];
    }


    /**
     * get White Turn method
     *
     * @return returns true if it is white's turn, and false if it is blacks
     *         turn.
     */
    public boolean getWhiteTurn()
    {
        return whiteTurn;
    }


    /**
     * Checks if there are any pieces that can give check to the current player
     *
     * @return the arrayList of all pieces that can hit the king
     */
    public boolean check()
    {
        return check(whitePieces, blackPieces, board);
    }


    /**
     * Checks if the current player is in check
     *
     * @param whitePieceArray
     *            the array containing all whitePieces
     * @param blackPieceArray
     *            the array containing all blackPieces
     * @param tempBoard
     * @return the arrayList of all pieces that can hit the king
     */
    public boolean check(
        Piece[] whitePieceArray,
        Piece[] blackPieceArray,
        Piece[][] tempBoard)
    {
        Location kingLocal;
        ArrayList<Piece> piecesGivingCheck = new ArrayList<Piece>();
        boolean inCheck = false;
        if (getWhiteTurn())
        {

            kingLocal = whitePieceArray[4].getLocal();
            ArrayList<Move> moves = getLegalMoves(false);
            for (Move move : moves)
            {
                if (move.getLocal().equals(kingLocal))
                {
                    inCheck = true;
                    break;
                }
            }
        }
        else
        {
            kingLocal = blackPieceArray[4].getLocal();
            ArrayList<Move> moves = getLegalMoves(true);
            for (Move move : moves)
            {
                if (move.getLocal().equals(kingLocal))
                {
                    inCheck = true;
                    break;
                }
            }
        }

        return inCheck;
    }


    /**
     * Checks to see if the move is legal
     *
     * @param move
     *            is the move being checked.
     * @return whether or not the move is legal (boolean)
     */
    public boolean isLegalMove(Move move)
    {
        Piece piece = move.getPiece();
        if (piece.getIsWhite() != getWhiteTurn())
        {
            return false;
        }

        boolean legalMove = false;

        for (Move checkingMove : piece.getPossibleMoves(board))
        {
            if (move.equals(checkingMove))
            {
                legalMove = true;
                break;
            }
        }

        if (!legalMove)
        {
            return false;
        }

        // checks if moving the piece puts their king in check
        Piece[] tempBlackArray = this.getBlackPieces().clone();
        Piece[] tempWhiteArray = this.getWhitePieces().clone();

        Piece[][] tempBoard = new Piece[8][];
        for (int ii = 0; ii < 8; ii++)
        {
            tempBoard[ii] = board[ii].clone();
        }

        tempBoard[piece.getLocal().x()][piece.getLocal().y()] = null;

        if (piece.getIsWhite())
        {
            if (board[move.getLocal().x()][move.getLocal().y()] != null)
            {
                tempBlackArray[board[move.getLocal().x()][move.getLocal().y()]
                    .getInColorArray()] = null;
            }
        }
        else
        {
            if (board[move.getLocal().x()][move.getLocal().y()] != null)
            {
                tempWhiteArray[board[move.getLocal().x()][move.getLocal().y()]
                    .getInColorArray()] = null;
            }
        }

        tempBoard[move.getLocal().x()][move.getLocal().y()] = piece;
        Location oldLocal = piece.getLocal();
        piece.setLocal(move.getLocal());

        if (check(tempWhiteArray, tempBlackArray, tempBoard))
        {
            piece.setLocal(oldLocal);
            return false;
        }
        piece.setLocal(oldLocal);
        return true;
    }


    /**
     * Place a description of your method here.
     *
     * @param move
     *            is the location and the piece to be moved.
     */
    public void move(Move move)
    {
        String notation = move.getPiece().getLetter();

        board[move.getPiece().getLocal().x()][move.getPiece().getLocal().y()] =
            null;

        move.getPiece().setLocal(move.getLocal());

        // Taking a piece
        if (board[move.getLocal().x()][move.getLocal().y()] != null)
        {
            if (board[move.getLocal().x()][move.getLocal().y()].getIsWhite())
            {
                notation +=
                    "x"
                        + board[move.getLocal().x()][move.getLocal().y()]
                            .getLetter();
                whitePieces[board[move.getLocal().x()][move.getLocal().y()]
                    .getInColorArray()] = null;
            }
            else
            {
                notation +=
                    "x"
                        + board[move.getLocal().x()][move.getLocal().y()]
                            .getLetter();
                blackPieces[board[move.getLocal().x()][move.getLocal().y()]
                    .getInColorArray()] = null;
            }
        }
        if ((move.getLocal().y() == 0 || move.getLocal().y() == 7)
            && move.getPiece().getClass() == Pawn.class)
        {
            notation += "=";
            switch (getPawnPromotion())
            {

                case (0):
                    board[move.getLocal().x()][move.getLocal().y()] =
                        new Queen(
                            move.getPiece().getIsWhite(),
                            move.getLocal(),
                            move.getPiece().getInColorArray());
                    notation += "Q";
                    break;
                case (1):
                    board[move.getLocal().x()][move.getLocal().y()] =
                        new Rook(
                            move.getPiece().getIsWhite(),
                            move.getLocal(),
                            move.getPiece().getInColorArray());
                    notation += "R";
                    break;
                case (2):
                    board[move.getLocal().x()][move.getLocal().y()] =
                        new Knight(
                            move.getPiece().getIsWhite(),
                            move.getLocal(),
                            move.getPiece().getInColorArray());
                    notation += "K";
                    break;
                case (3):
                    board[move.getLocal().x()][move.getLocal().y()] =
                        new Bishop(
                            move.getPiece().getIsWhite(),
                            move.getLocal(),
                            move.getPiece().getInColorArray());
                    notation += "B";
                    break;

            }
            board[move.getLocal().x()][move.getLocal().y()] =
                new Queen(move.getPiece().getIsWhite(), move.getLocal(), move
                    .getPiece().getInColorArray());
        }
        else
        {
            board[move.getLocal().x()][move.getLocal().y()] = move.getPiece();
        }
        notation += move.getLocal().toString();
        whiteTurn = !whiteTurn;
        if (check())
        {
            notation += "+";
        }

        move.setNotation(notation);
    }


    /**
     * Gets user input, tells what piece to promote pawn to. 0: Queen 1: Rook 2:
     * Knight 3: Bishop
     *
     * @return the int corresponding to the piece which you want to promote the
     *         pawn to.
     */
    public int getPawnPromotion()
    {
        // TODO: get user input
        return 0;
    }


    /**
     * Place a description of your method here.
     *
     * @param piece
     * @param kingX
     * @param kingY
     * @param tempBoard
     * @return the piece if it can
     */
    public boolean canThisPieceHitXandY(
        Piece piece,
        int kingX,
        int kingY,
        Piece[][] tempBoard)
    {
        for (Move move : piece.getPossibleMoves(tempBoard))
        {
            if (move.getLocal().x() == kingX && move.getLocal().y() == kingY)
            {
                return true;
            }
        }

        return false;
    }


    /**
     * set White Turn sets the value of the whiteTurn boolean.
     *
     * @param turn
     *            true if set to white, false if set to black.
     */
    public void setWhiteTurn(boolean turn)
    {
        whiteTurn = turn;
    }
}
