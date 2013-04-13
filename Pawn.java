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

    private Location local;
    private Chessboard board;
    private ArrayList<Location> legalMoves;
    private Piece offsetObject;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Pawn object.
     * @param color true if white and false if black
     * @param location The location of the piece
     * @param posInArray the position in the array of those color pieces
     * @param chessBoard the board the piece is on
     */
    public Pawn(boolean color, Location location, int posInArray,
        Chessboard chessBoard)
    {
        super(color, location, posInArray, chessBoard);
        local = location;
        board = chessBoard;

        if(color)
        {
            legalVectors.add(new Location (0, -1));
            legalVectors.add(new Location (1, -1));
            legalVectors.add(new Location (-1, -1));
        }
        else
        {
            legalVectors.add(new Location (0, 1));
            legalVectors.add(new Location (1, 1));
            legalVectors.add(new Location (-1, 1));
        }

        legalMoves = new ArrayList<Location>();
    }

    //~ Methods ...............................................................

    /**
     * get Legal Moves
     * returns an arraylist of legal moves
     * @return legalMoves for this pawn's location
     */
    public ArrayList<Location> getLegalMoves()
    {
        legalMoves.clear();

        for (Location vector : this.getLegalVectors())
        {
            if ((local.x() + vector.x() < 8) &&
                (local.x() + vector.x() > -1) &&
                (local.y() + vector.y() < 8) &&
                (local.y() + vector.y() > -1))
            {
                offsetObject = board.getBoard()[local.x() + vector.x()][local.y() + vector.y()];

                if (vector.x() == 0 && offsetObject == null
                    || vector.x() != 0 && offsetObject != null && offsetObject.getIsWhite() != this.getIsWhite())
                {
                    legalMoves.add(new Location (vector.x() + local.x(), vector.y() + local.y()));
                }
            }
        }
        if ((this.getIsWhite()) && (local.y() == 6) &&
            (board.getBoard()[local.x()][local.y() - 2] == null
            && board.getBoard()[local.x()][local.y() - 1] == null))
        {
            legalMoves.add(new Location (local.x(), local.y() -2));
        }
        else if (!this.getIsWhite() && local.y() == 1 &&
            board.getBoard()[local.x()][local.y() + 2] == null
            && board.getBoard()[local.x()][local.y() - 1] == null)
        {
            legalMoves.add(new Location (local.x(), local.y() + 2));
        }
        return legalMoves;
    }

    public void setLocal(Location local)
    {
        this.local = local;
    }


}
