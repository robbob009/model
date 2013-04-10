package model;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Pawn Actor
 * Pawns move one space, attack diagonally forward, and can move two spaces
 * forward on their first move.
 * Reach  the opposite side of the board to promote your pawn to a queen.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.06)
 */
public class Pawn extends Piece
{
    //~ Fields ................................................................

    private int xCoord;
    private int yCoord;
    private Chessboard board;
    private ArrayList<int[]> legalMoves;
    private Piece offsetObject;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Pawn object.
     * @param color true if white and false if black
     * @param xLocal the xLocation of the piece
     * @param yLocal the yLocation of the piece
     * @param posInArray the position in the array of those color pieces
     * @param chessBoard the board the piece is on
     */
    public Pawn(boolean color, int xLocal, int yLocal, int posInArray,
        Chessboard chessBoard)
    {
        super(color, xLocal, yLocal, posInArray, chessBoard);
        xCoord = xLocal;
        yCoord = yLocal;
        board = chessBoard;

        legalVectors.add(new int[] {0, 1});
        legalVectors.add(new int[] {0, -1});
        legalVectors.add(new int[] {1, 1});
        legalVectors.add(new int[] {1, -1});
        legalVectors.add(new int[] {-1, 1});
        legalVectors.add(new int[] {-1, -1});

        legalMoves = new ArrayList<int[]>();
    }

    //~ Methods ...............................................................

    /**
     * get Legal Moves
     * returns an arraylist of legal moves
     * @return legalMoves for this pawn's location
     */
    public ArrayList<int[]> getLegalMoves()
    {
        legalMoves.clear();

        for (int[] vector : this.getLegalVectors())
        {
            if ((xCoord + vector[0] < 8) &&
                (xCoord + vector[0] > -1) &&
                (yCoord + vector[1] < 8) &&
                (yCoord + vector[1] > -1))
            {
                offsetObject = board.getBoard()[xCoord + vector[0]][yCoord + vector[1]];
                if ((((vector[0] == 0) && (offsetObject == null))
                    || ((vector[0] != 0) && (offsetObject != null) &&
                    (offsetObject.getIsWhite() != this.getIsWhite()))) &&
                    (((this.getIsWhite()) && (vector[1] < 0))
                    || ((!this.getIsWhite()) && (vector[1] > 0))) )
                {
                    legalMoves.add(vector);
                }
            }
        }
        if ((this.getIsWhite()) && (yCoord == 6) &&
            (board.getBoard()[xCoord][yCoord - 2] == null))
        {
            legalMoves.add(new int[] {0, -2});
        }
        else if ((!this.getIsWhite()) && (yCoord == 1) &&
            (board.getBoard()[xCoord][yCoord - 2] == null))
        {
            legalMoves.add(new int[] {0, 2});
        }
        return legalMoves;
    }

}
