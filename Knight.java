package model;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Knight Actor
 *  Knights move in L shapes, of every possible orientation.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.09)
 */
public class Knight extends Piece
{
    //~ Fields ................................................................

    private int xCoord;
    private int yCoord;
    private Chessboard board;
    private ArrayList<int[]> legalMoves;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Knight object.
     * @param color true if white and false if black
     * @param xLocal the xCoordinate of the piece
     * @param yLocal the yCoordinate of the piece
     * @param posInArray the position in the array of those color pieces
     * @param chessBoard the board the piece is on
     */
    public Knight(boolean color, int xLocal, int yLocal, int posInArray,
        Chessboard chessBoard)
    {
        super(color, xLocal, yLocal, posInArray, chessBoard);
        xCoord = xLocal;
        yCoord = yLocal;
        board = chessBoard;
        legalVectors.add(new int[] {-2, -1});
        legalVectors.add(new int[] {-2, 1});
        legalVectors.add(new int[] {-1, -2});
        legalVectors.add(new int[] {-1, 2});
        legalVectors.add(new int[] {1, -2});
        legalVectors.add(new int[] {1, 2});
        legalVectors.add(new int[] {2, -1});
        legalVectors.add(new int[] {2, 1});

        legalMoves = new ArrayList<int[]>();

    }

    //~ Methods ...............................................................
    /**
     * getLegalMoves
     *
     * @return legalMoves for the knight at this location.
     *
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
                if (board.getBoard()[vector[0]][vector[1]] == null
                    || board.getBoard()[vector[0]][vector[1]]
                    .getIsWhite() != this.getIsWhite())
                {
                    legalMoves.add(vector);
                }
                else
                {
                    continue;
                }
            }
        }
        return legalMoves;

    }

}
