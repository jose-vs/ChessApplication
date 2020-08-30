package Piece;
import Game.*;
import Exception.InvalidPathException;
/**
* This class stores data relating to the movement limitations of the Bishop Piece,
* 
* @author Jose Santos 
*/
public class Bishop extends Piece {

	public Bishop(Player player) {
	
		super(player);
	    this.setRank(Rank.BISHOP);
	}


	/**
	 * determines if the move done by the user is valid based on:
	 * 		- 	since a bishop can only move diagonal, on a (x,y) plane, when it moves diagonally,
	 * 			the change in x and y must be equal
	 * 			the absolute value must be same for the path to be valid
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return 				a boolean indicating if the move is valid
	 * @throws InvalidPathException 
	 */
	@Override
	public boolean isValidPath(BoardSquare bSquare, int xDes, int yDes) throws InvalidPathException{

		int xChange = Math.abs(xDes - bSquare.getxPos());
		int yChange = Math.abs(yDes - bSquare.getyPos());

		if (xChange== yChange) {
			
			return xChange == yChange; 
			
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
		int distance = Math.abs(xDes - xStart);

		int xDirection = 1;
		int yDirection = 1;
		
		if (xDes - xStart < 0)
			xDirection = -1;
		if (yDes - yStart < 0)
			yDirection = -1;

		int [][] journey = new int[2][distance -1];

		if (distance - 1 > 0) {
			for(int i = 0; i < distance - 1; i++) {
				
				journey[0][i] = xStart + (xDirection * 1);
				journey[1][i] = yStart + (yDirection * 1);
			}
		}
		return journey;
	}
}
