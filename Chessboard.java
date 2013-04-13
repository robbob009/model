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
public class Chessboard
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
    public Chessboard()
    {
        // The Board is an 8x8 array of pieces, with board[x][y]
        // board[0][0] is equivalent to a8, board[0][7] is a1,
        // board[7][0] is h8, board[7][7] is h1
        board = new Piece[8][8];

        blackPieces = new Piece[16];
        whitePieces = new Piece[16];

        // Creates black pieces except pawns
        blackPieces[0] =
            board[0][0] = new Rook(false, new Location(0, 0), 0);
        blackPieces[1] =
            board[1][0] = new Knight(false, new Location(1, 0), 1);
        blackPieces[2] =
            board[2][0] = new Bishop(false, new Location(2, 0), 2);
        blackPieces[3] =
            board[3][0] = new Queen(false, new Location(3, 0), 3);
        blackPieces[4] =
            board[4][0] = new King(false, new Location(4, 0), 4);
        blackPieces[5] =
            board[5][0] = new Bishop(false, new Location(5, 0), 5);
        blackPieces[6] =
            board[6][0] = new Knight(false, new Location(6, 0), 6);
        blackPieces[7] =
            board[7][0] = new Rook(false, new Location(7, 0), 7);

        // Creates white pieces except pawns
        whitePieces[0] =
            board[0][7] = new Rook(true, new Location(0, 7), 0);
        whitePieces[1] =
            board[1][7] = new Knight(true, new Location(1, 7), 1);
        whitePieces[2] =
            board[2][7] = new Bishop(true, new Location(2, 7), 2);
        whitePieces[3] =
            board[3][7] = new Queen(true, new Location(3, 7), 3);
        whitePieces[4] =
            board[4][7] = new King(true, new Location(4, 7), 4);
        whitePieces[5] =
            board[5][7] = new Bishop(true, new Location(5, 7), 5);
        whitePieces[6] =
            board[6][7] = new Knight(true, new Location(6, 7), 6);
        whitePieces[7] =
            board[7][7] = new Rook(true, new Location(7, 7), 7);

        // Creates all pawns
        for (int ii = 0; ii < 8; ii++)
        {
            blackPieces[ii + 8] =
                board[ii][1] =
                    new Pawn(false, new Location(ii, 1), ii + 7);
            whitePieces[ii + 8] =
                board[ii][6] =
                    new Pawn(true, new Location(ii, 6), ii + 7);
        }

        whiteTurn = true;
    }


    // ~ Methods ...............................................................

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


    // ----------------------------------------------------------
    /**
     * Returns the array of all white pieces
     *
     * @return the white pieces
     */
    public Piece[] getWhitePieces()
    {
        return whitePieces;
    }


    // ----------------------------------------------------------
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


    // ----------------------------------------------------------
    /**
     * Returns the array of all black pieces
     *
     * @return the array of all black pieces
     */
    public Piece[] getBlackPieces()
    {
        return blackPieces;
    }


    // ----------------------------------------------------------
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
     * Checks if the current player is in check
     *
     * @param whitePieceArray
     *            the array containing all whitePieces
     * @param blackPieceArray
     *            the array containing all blackPieces
     * @param tempBoard
     * @return true if the player is in check
     */
    public ArrayList<Piece> check(
        Piece[] whitePieceArray,
        Piece[] blackPieceArray,
        Piece[][] tempBoard)
    {
        int kingX;
        int kingY;
        ArrayList<Piece> piecesGivingCheck = new ArrayList<Piece>();

        if (getWhiteTurn())
        {
            if (whitePieceArray[4] == null)
            {
                System.out.println("White has been checkmated!");
                print();
                System.exit(0);
            }
            kingX = whitePieceArray[4].getLocal().x();
            kingY = whitePieceArray[4].getLocal().y();
            for (Piece piece : blackPieceArray)
            {
                if (piece != null && canThisPieceHitXandY(piece, kingX, kingY, tempBoard))
                {
                    piecesGivingCheck.add(piece);
                }
            }
        }
        else
        {
            if (blackPieceArray[4] == null)
            {
                System.out.println("Black has been checkmated!");
                print();
                System.exit(0);
            }
            kingX = blackPieceArray[4].getLocal().x();
            kingY = blackPieceArray[4].getLocal().y();
            for (Piece piece : whitePieceArray)
            {
                if (piece != null && canThisPieceHitXandY(piece, kingX, kingY, tempBoard))
                {
                    piecesGivingCheck.add(piece);
                }
            }
        }

        return piecesGivingCheck;
    }


    /**
     * Place a description of your method here.
     *
     * @param piece
     *            The piece whose move is being checked
     * @param newLocal
     *            location of the move
     * @return whether or not the move is legal (boolean)
     */
    public boolean isLegalMove(Piece piece, Location newLocal)
    {
        if (piece.getIsWhite() != getWhiteTurn())
        {
            return false;
        }

        boolean legalMove = false;
        for (Location move : piece.getLegalMoves(board))
        {
            if (move.equals(newLocal))
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
        Piece[] tempBlackArray = blackPieces;
        Piece[] tempWhiteArray = whitePieces;
        Piece[][] tempBoard = board;

        if (piece.getIsWhite())
        {
            tempWhiteArray[piece.getInColorArray()] = piece;
            if (board[newLocal.x()][newLocal.y()] != null)
            {
                tempBlackArray[board[newLocal.x()][newLocal.y()].getInColorArray()] = null;
                tempBoard[newLocal.x()][newLocal.y()] = null;
            }
        }
        else
        {
            tempBlackArray[piece.getInColorArray()] = piece;
            if (board[newLocal.x()][newLocal.y()] != null)
            {
                tempWhiteArray[board[newLocal.x()][newLocal.y()].getInColorArray()] = null;
                tempBoard[newLocal.x()][newLocal.y()] = null;
            }
        }

        if (!check(tempWhiteArray, tempBlackArray, tempBoard).isEmpty())
        {
            return false;
        }

        return true;
    }


    /**
     * Place a description of your method here.
     *
     * @param piece
     *            The piece being moved
     * @param newLocal
     *            the location the piece is being moved to
     */
    public void move(Piece piece, Location newLocal)
    {
        board[piece.getLocal().x()][piece.getLocal().y()] = null;

        piece.setLocal(newLocal);

        // Taking a piece
        if (board[newLocal.x()][newLocal.y()] != null)
        {
            if (board[newLocal.x()][newLocal.y()].getIsWhite())
            {
                whitePieces[board[newLocal.x()][newLocal.y()].getInColorArray()] =
                    null;
            }
            else
            {
                blackPieces[board[newLocal.x()][newLocal.y()].getInColorArray()] =
                    null;
            }
        }
        Piece newPiece = piece;
        if ((newLocal.y() == 0 || newLocal.y() == 7)
            && piece.getClass() == Pawn.class)
        {
// GET USER INPUT HERE
// Piece newPiece;
// if (Queen)
// {
// newPiece = new Queen (piece.getIsWhite(), newX, newY,
// piece.getInColorArray());
// }
// else if (Rook)
// {
// newPiece = new Rook(piece.getIsWhite(), newX, newY, piece.getInColorArray(),
// this);
// }
// else if (Bishop)
// {
// newPiece = new Bishop (piece.getIsWhite(), newX, newY,
// piece.getInColorArray());
// }
// else
// {
// newPiece = new Knight (piece.getIsWhite(), newX, newY,
// piece.getInColorArray());
// }
            newPiece =
                new Queen(
                    piece.getIsWhite(),
                    newLocal,
                    piece.getInColorArray());
        }
        board[newLocal.x()][newLocal.y()] = newPiece;

        whiteTurn = !whiteTurn;
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
    public boolean canThisPieceHitXandY(Piece piece, int kingX, int kingY, Piece[][] tempBoard)
    {
        for (Location move : piece.getLegalMoves(tempBoard))
        {
            if (move.x() == kingX && move.y() == kingY)
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
