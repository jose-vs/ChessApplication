package Piece;

import Exception.InvalidPathException;
import Game.*;
/**
* This class stores data relating to the movement limitations of the Pawn Piece
*
* @author Jose Santos
*/
public class Pawn extends Piece{


	public Pawn(Player player) {
	
		super(player);
		this.setRank(Rank.PAWN);
	}

	/**
	 * determines if the move is possible by the pawn piece by:
	 * 		* if moving twice is still valid
	 * 		* if capturing another piece is valid (e.g. moving forward sideways by one square)
	 * 		* if the path forward one square is unobstructed
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return				a boolean indicating if the move is valid
	 * @throws InvalidPathException 
	 */
	@Override
	public boolean isValidPath(BoardSquare bSquare, int xDes, int yDes) throws InvalidPathException {
		if ((isMoveTwiceValid(bSquare, xDes, yDes))||
				(isCaptureValid(bSquare, xDes, yDes)) ||
				(isMoveForwardValid(bSquare, xDes, yDes))) {

			return true;
			
		} else {
			
			throw new InvalidPathException();
		}
	}

	/**
	 * This method draws a path from one point to another based on the piece type and returns the coordinates
	 *
	 * @param xStart 		x starting point
	 * @param yStart 		y starting point
	 * @param xDes 			x destination point the player is moving the piece to
	 * @param yDes 			y destination point the player is moving the piece to
	 * @return path an integer array containing the coordinates of the given path
	 */
	@Override
	public int[][] drawMove(int xStart, int yStart, int xDes, int yDes) {
		int pairs = 0;
		int[][] path = new int[2][pairs];

		return path;

	}


	/**
	 * This method determines if the pawn piece can move twice based on its location on the board
	 * 		a pawn can not move twice when its past its starting position
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return a boolean regarding whether or not the pawn piece has moved or not
	 */
	protected boolean isMoveTwiceValid(BoardSquare bSquare, int xDes, int yDes) {
		int yDifference = Math.abs(yDes - bSquare.getyPos());

		BoardSquare squareDes = this.getPlayer().game.gameBoard.board[yDes][xDes];

		return((yDifference == 2) &&
				(((this.getPlayer().getSide() == Side.WHITE) && (bSquare.getyPos() == 1) && (squareDes.getPiece() == null )||
				((this.getPlayer().getSide() == Side.BLACK) && (bSquare.getyPos() == 6) && (squareDes.getPiece() == null )))));

	}

	/**
	 * This method determines if the pawn piece can move diagonal and take the enemy piece
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return a boolean regarding whether or not the pawn can move diagonal and capture
	 */
	protected boolean isCaptureValid(BoardSquare bSquare, int xDes, int yDes) {
		int yDiffAbs = Math.abs(yDes - bSquare.getyPos());
		int xDiffAbs = Math.abs(xDes - bSquare.getxPos());
		int yDiff = yDes - bSquare.getyPos();

		BoardSquare squareDes = this.getPlayer().game.gameBoard.board[yDes][xDes];

		if((xDiffAbs == yDiffAbs) && (yDiffAbs == 1)) {

			if (this.getPlayer().getSide() == Side.WHITE && ((squareDes.getPiece() != null
					&& (squareDes.getPiece().getPlayer().getSide() == Side.BLACK) && yDiff > 0)))
				return true;
			else if (this.getPlayer().getSide() == Side.BLACK && ((squareDes.getPiece() != null
					&& (squareDes.getPiece().getPlayer().getSide() == Side.WHITE) && yDiff < 0)))
				return true;

		}

		return false;
	}

	/**
	 * This method determines if the pawn piece is blocked from moving forward and if the pawn only moved forward one square
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return a boolean that returns true or false, depending on whether or not the pawn is blocked by another piece infront of it
	 */
	protected boolean isMoveForwardValid(BoardSquare bSquare, int xDes, int yDes) {

		int yDiffAbs = Math.abs(yDes - bSquare.getyPos());
		int yDiff = yDes - bSquare.getyPos();

		BoardSquare squareDes = this.getPlayer().game.gameBoard.board[yDes][xDes];

		return(((this.getPlayer().getSide() == Side.WHITE && yDiff > 0 && yDiffAbs == 1) ||
				(this.getPlayer().getSide() == Side.BLACK && yDiff < 0 && yDiffAbs == 1)) &&
				squareDes.getPiece() == null && xDes == bSquare.getxPos());
	}
}
