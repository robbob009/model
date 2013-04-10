package model;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  King Actor
 *  Kings can move one space in any direction.
 *  This piece must be captured to win the game.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.09)
 */
public class King extends Piece
{
    //~ Fields ................................................................

    private ArrayList<int[]> legalMoves;
    private int xCoord;
    private int yCoord;
    private Chessboard board;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new BlackKing object.
     * @param color true if white and false if black
     * @param xLocal the xLocation of the piece
     * @param yLocal the yLocation of the piece
     * @param posInArray the position in the array of those color pieces
     * @param chessBoard the board the piece is on
     */
    public King(boolean color, int xLocal, int yLocal, int posInArray,
        Chessboard chessBoard)
    {
        super(color, xLocal, yLocal, posInArray, chessBoard);
        xCoord = xLocal;
        yCoord = yLocal;
        legalVectors.add(new int[] {-1, -1});
        legalVectors.add(new int[] {-1, 0});
        legalVectors.add(new int[] {-1, 1});
        legalVectors.add(new int[] {0, -1});
        legalVectors.add(new int[] {0, 1});
        legalVectors.add(new int[] {1, -1});
        legalVectors.add(new int[] {1, 0});
        legalVectors.add(new int[] {1, 1});

        legalMoves = new ArrayList<int[]>();

    }

    //~ Methods ...............................................................

    /**
     * getLegalMoves method
     * @return gives ArrayList of int arrays containing the coordinate pairs
     * (delta x, delta y) of legal moves
     */
    public ArrayList<int[]> getLegalMoves()
    {
        legalMoves.clear();

        for (int[] vector : this.getLegalVectors())
        {
            if (((xCoord + vector[0] < 8) &&
                (xCoord + vector[0] > -1)
                && (yCoord + vector[1] < 8) &&
                (yCoord + vector[1] > -1))
                || (board.getBoard()[xCoord + vector[0]] //This may cause a null pointer exception
                    [yCoord + vector[1]] == null         //if it checks outside the board
                    || board.getBoard()[vector[0]][vector[1]]
                        .getIsWhite() != this.getIsWhite()))
            {
                legalMoves.add(vector);
            }
            else
            {
                continue;
            }
        }

        return legalMoves;
    }


}
