package model;

//-------------------------------------------------------------------------
/**
 *  Rook Piece
 *  Moves Left, Up, Down, and Right any number of squares.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.07)
 */
public class Rook extends Piece
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Rook object.
     * @param color true if white and false if black
     * @param xLocal the x location of the piece.
     * @param yLocal the y location of the piece.
     * @param posInArray the position in the array of those color pieces
     * @param chessBoard the board the piece is on.
     */
    public Rook(boolean color, int xLocal, int yLocal, int posInArray,
        Chessboard chessBoard)
    {
        super(color, xLocal, yLocal, posInArray, chessBoard);
        legalVectors.add(new int[] {-1, 0});
        legalVectors.add(new int[] {0, -1});
        legalVectors.add(new int[] {0, 1});
        legalVectors.add(new int[] {1, 0});

    }

    //~ Methods ...............................................................


}
