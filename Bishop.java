package model;

//-------------------------------------------------------------------------
/**
 *  Bishop Actor
 *  Bishops move diagonally until the end of the board or another piece.
 *
 *  @author Loran Steinberger (bkwrm215)
<<<<<<< HEAD:CS Project/ChessProgram/src/com/example/chessprogram/Bishop.java
 *  @author Robert Scheible (scheible)
=======
>>>>>>> 34fd34287986a28f26d7d890be9303f3a8ed28c4:CS Project/Chess Program/src/chessProgram/Bishop.java
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.09)
 */
public class Bishop extends Piece
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bishop object.
     * @param color true for white and false for black
     * @param location The location of the piece
     * @param posInArray the position in the array of those color pieces
     * @param chessBoard the board the piece is on.
     */
    public Bishop(boolean color, Location location, int posInArray,
        Chessboard chessBoard)
    {
        super(color, location, posInArray, chessBoard);

        legalVectors.add(new Location (-1, -1));
        legalVectors.add(new Location (-1, 1));
        legalVectors.add(new Location (1, -1));
        legalVectors.add(new Location (1, 1));
    }

    //~ Methods ...............................................................


}
