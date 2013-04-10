package model;

//-------------------------------------------------------------------------
/**
 *  Queen Piece
 *  The Queen moves diagonally and straight in 8 different directions.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.08)
 */
public class Queen extends Piece
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Queen object.
     * @param color true if white and false if black
     * @param xLocal xCoordinate of the piece
     * @param yLocal yCoordinate of the piece
     * @param posInArray the position in the array of those color pieces
     * @param chessBoard the board the piece is on
     */
    public Queen(boolean color, int xLocal, int yLocal, int posInArray,
        Chessboard chessBoard)

    {
        super(color, xLocal, yLocal, posInArray, chessBoard);

        legalVectors.add(new int[] {-1, -1});
        legalVectors.add(new int[] {-1, 0});
        legalVectors.add(new int[] {-1, 1});
        legalVectors.add(new int[] {0, -1});
        legalVectors.add(new int[] {0, 1});
        legalVectors.add(new int[] {1, -1});
        legalVectors.add(new int[] {1, 0});
        legalVectors.add(new int[] {1, 1});

    }
    //~ Methods ...............................................................

}
