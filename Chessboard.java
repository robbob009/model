package model;

import java.util.ArrayList;

//-------------------------------------------------------------------------
/**
 *  Chessboard World
 *  Holds the instructions, Pieces, and Square highlights referred to
 *  as glows. Checks for end game conditions.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.03)
 */
public class Chessboard
{
    //~ Fields ................................................................

    //The Board is an 8x8 array of pieces, with board[x][y]
    //board[0][0] is equivalent to a8, board[0][7] is a1,
    //board[7][0] is h8, board[7][7] is h1
    private Piece[][] board;
    private Piece[] whitePieces;
    private Piece[] blackPieces;

    private boolean whiteTurn;
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new ChessboardWhite object.
     */
    public Chessboard()
    {
        //The Board is an 8x8 array of pieces, with board[x][y]
        //board[0][0] is equivalent to a8, board[0][7] is a1,
        //board[7][0] is h8, board[7][7] is h1
        board = new Piece[8][8];

        blackPieces = new Piece[16];
        whitePieces = new Piece[16];

        //Creates black pieces except pawns
        blackPieces[0] = board[0][0] = new Rook(false, 0, 0, 0, this);
        blackPieces[1] = board[1][0] = new Knight(false, 1, 0, 1, this);
        blackPieces[2] = board[2][0] = new Bishop(false, 2, 0, 2, this);
        blackPieces[3] = board[3][0] = new Queen(false, 3, 0, 3, this);
        blackPieces[4] = board[4][0] = new King(false, 4, 0, 4, this);
        blackPieces[5] = board[5][0] = new Bishop(false, 5, 0, 5, this);
        blackPieces[6] = board[6][0] = new Knight(false, 6, 0, 6, this);
        blackPieces[7] = board[7][0] = new Rook(false, 7, 0, 7, this);

        //Creates white pieces except pawns
        whitePieces[0] = board[0][7] = new Rook(true, 0, 7, 0, this);
        whitePieces[1] = board[1][7] = new Knight(true, 1, 7, 1, this);
        whitePieces[2] = board[2][7] = new Bishop(true, 2, 7, 2, this);
        whitePieces[3] = board[3][7] = new Queen(true, 3, 7, 3, this);
        whitePieces[4] = board[4][7] = new King(true, 4, 7, 4, this);
        whitePieces[5] = board[5][7] = new Bishop(true, 5, 7, 5, this);
        whitePieces[6] = board[6][7] = new Knight(true, 6, 7, 6, this);
        whitePieces[7] = board[7][7] = new Rook(true, 7, 7, 7, this);

        //Creates all pawns
        for (int ii = 0; ii < 8; ii++)
        {
            blackPieces[ii + 7] = board[ii][1] = new Pawn(false, ii, 1, ii + 7, this);
            whitePieces[ii + 7] = board[ii][6] = new Pawn(true, ii, 6, ii + 7, this);
        }

        whiteTurn = true;
    }
    //~ Methods ...............................................................

    /**
     * Returns the actual board
     * @return board is the array holding all pieces
     */
    public Piece[][] getBoard()
    {
        return board;
    }

    /**
     * Clear Board
     * The world removes all actors and text images.
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
        blackPieces = null;
        whitePieces = null;
    }


    /**
     * get White Turn method
     * @return returns true if it is white's turn,
     * and false if it is blacks turn.
     */
    public boolean getWhiteTurn()
    {
        return whiteTurn;
    }

    /**
     * Checks if the current player is in check
     * @param whitePieceArray the array containing all whitePieces
     * @param blackPieceArray the array containing all blackPieces
     * @return true if the player is in check
     */
    public ArrayList<Piece> check(Piece[] whitePieceArray,
        Piece[] blackPieceArray)
    {
        int kingX;
        int kingY;
        ArrayList<Piece> piecesGivingCheck = new ArrayList<Piece>();

        if (getWhiteTurn())
        {
            kingX = whitePieceArray[4].getxCoord();
            kingY = whitePieceArray[4].getyCoord();
            for (Piece piece: blackPieceArray)
            {
                if (canThisPieceHitXandY(piece, kingX, kingY))
                {
                    piecesGivingCheck.add(piece);
                }
            }
        }
        else
        {
            kingX = blackPieceArray[4].getxCoord();
            kingY = blackPieceArray[4].getyCoord();
            for (Piece piece: whitePieceArray)
            {
                if (canThisPieceHitXandY(piece, kingX, kingY))
                {
                    piecesGivingCheck.add(piece);
                }
            }
        }

        return piecesGivingCheck;
    }

    /**
     * Place a description of your method here.
     * @param piece
     * @param newX
     * @param newY
     */
    public void move(Piece piece, int newX, int newY)
    {
        //Checks if the piece being moved is the color of the current turn
        if (piece.getIsWhite() != getWhiteTurn())
        {
            System.out.println("The piece is the wrong color.");
            return;
        }

        //Checks if the piece can actually move to the new location
        boolean legalMove = false;
        for (int[] move : piece.getLegalVectors())
        {
            if (move[0] == newX
                && move[1] == newY)
            {
                legalMove = true;
                break;
            }
        }
        if (!legalMove)
        {
            System.out.println("The piece cannot move here.");
            return;
        }

        //checks if moving the piece puts their king in check
        Piece[] tempBlackArray = blackPieces;
        Piece[] tempWhiteArray = whitePieces;

        if (piece.getIsWhite())
        {
            tempWhiteArray[piece.getInColorArray()] = piece;
        }
        else
        {
            tempBlackArray[piece.getInColorArray()] = piece;
        }

        if (!check(tempWhiteArray, tempBlackArray).isEmpty())
        {
            System.out.println("Moving this piece puts you in check.");
            return;
        }

        //Congrats, it's a legal move
        blackPieces = tempBlackArray;
        whitePieces = tempWhiteArray;

        board[piece.getxCoord()][piece.getyCoord()] = null;

        piece.setxCoord(newX);
        piece.setyCoord(newY);

        board[piece.getxCoord()][piece.getyCoord()] = piece;

        whiteTurn = !whiteTurn;
    }

    /**
     * Place a description of your method here.
     * @param piece
     * @param kingX
     * @param kingY
     * @return the piece if it can
     */
    public boolean canThisPieceHitXandY(Piece piece, int kingX, int kingY)
    {
        for (int[] move : piece.getLegalMoves())
        {
            if (move[0] == kingX
                && move[1] == kingY)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * set White Turn
     * sets the value of the whiteTurn boolean.
     * @param turn true if set to white, false if set
     * to black.
     */
    public void setWhiteTurn(boolean turn)
    {
        whiteTurn = turn;
    }
}