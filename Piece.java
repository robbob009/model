package model;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Piece Actor
 *  contains methods pertinent to all chess pieces
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.03)
 */
public class Piece
{
    //~ Fields ................................................................

    private boolean isWhite;
    private boolean isActive;
    private ArrayList<int[]> legalMoves;
    private int xCoord;
    private int yCoord;
    private int inColorArray;
    private Chessboard board;

    /**
     * legalVectors
     * will be overwritten by every chess piece upon construction.
     */
    public ArrayList<int[]> legalVectors;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Piece object.
     * @param color true if white and false if black.
     * @param xLocal the x location of the piece.
     * @param yLocal the y location of the piece.
     * @param posInArray the position
     *          in the array holding all of that color pieces
     * @param chessBoard the board the piece is on.
     *
     */
    public Piece(boolean color, int xLocal, int yLocal, int posInArray,
        Chessboard chessBoard)
    {
        inColorArray = posInArray;
        isWhite = color;
        xCoord = xLocal;
        yCoord = yLocal;
        board = chessBoard;
        isActive = false;
        legalVectors = new ArrayList<int[]>();
    }
    //~ Methods ...............................................................

    /**
     * get Legal Moves
     * given legal vectors, finds legal moves for a specific piece.
     * @return returns all legal moves for the piece at this location
     *
     */
    public ArrayList<int[]> getLegalMoves()
    {
        legalMoves = new ArrayList<int[]>();

        for (int[] vector : this.getLegalVectors())
        {
            for (int i = 1; i < 8; i++)
            {
                if ((xCoord + i * vector[0] < 8) &&
                    (xCoord + i * vector[0] > -1) &&
                    (yCoord + i * vector[1] < 8) &&
                    (yCoord + i * vector[1] > -1))
                {
                    if (board.getBoard()[xCoord + i * vector[0]][yCoord + i *
                        vector[1]] == null)
                    {
                        legalMoves.add(new int[] {vector[0] * i,
                            vector[1] * i});
                    }
                    else if ((board.getBoard()
                        [xCoord + i * vector[0]]
                            [yCoord + i * vector[1]]
                                .getIsWhite()) != this.getIsWhite())
                    {
                        legalMoves.add(new int[] {vector[0] * i,
                            vector[1] * i});
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return legalMoves;
    }

    /**
     * Returns the position of the piece in the array of that color
     * @return the position of the piece in the array of that color
     */
    public int getInColorArray()
    {
        return inColorArray;
    }

    /**
     * gets the X coordinate
     * @return the xCoordinate
     */
    public int getxCoord()
    {
        return xCoord;
    }

    /**
     * sets the X coordinate
     * @param xCoord is the new xCoordinate
     */
    public void setxCoord(int xCoord)
    {
        this.xCoord = xCoord;
    }


    /**
     * gets the yCoordinate
     * @return the yCoordinate
     */
    public int getyCoord()
    {
        return yCoord;
    }


    /**
     * Sets the y Coordinate
     * @param yCoord is the new yCoordinate
     */
    public void setyCoord(int yCoord)
    {
        this.yCoord = yCoord;
    }

    /**
     * get Is White
     * @return true if a piece is white
     * and false if a piece is black
     */
    public boolean getIsWhite()
    {
        return isWhite;
    }

    /**
     * get Is Active
     * activation is dependent on has a piece been touched by
     * a user, and are its legal moves displayed on the board.
     * @return true if activated and false if inactivated.
     */
    public boolean getIsActive()
    {
        return isActive;
    }

    /**
     * getLegalVectors
     * @return all possible legal vectors for this piece
     */
    public ArrayList<int[]> getLegalVectors()
    {
        return legalVectors;
    }

    /**
     * set Is Active
     * @param activity true if active and false if inactive.
     */
    public void setIsActive(boolean activity)
    {
        isActive = activity;
    }
}
