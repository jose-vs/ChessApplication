package Piece;

import Game.*;
import Exception.InvalidPathException;
/**
* This class stores data relating to the movement limitations of the Knight Piece,
*
* @author Jose Santos 17993442
*/
public class Knight extends Piece {

	public Knight(Player player){

	    super(player);
	    this.setRank(Rank.KNIGHT);
	}

	
	/**
	 * determines if the path taken by the knight is valid
	 * 		- 	a knight can leap over other pieces and travels on an L shaped path
	 * 			the method only returns true if the Knight travels either the 
	 * 			x value changes by 2 and y changes by 1 or
	 * 			y value changes by 2 and x changes by 1
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return 				a boolean indicating if the move is valid
	 * @throws InvalidPathException 
	 */
	public boolean isValidPath(BoardSquare bSquare, int xDes, int yDes) throws InvalidPathException {
	
		int xDif = Math.abs(xDes - bSquare.getxPos());
		int yDif = Math.abs(yDes - bSquare.getyPos());

		if ((xDif == 1 && yDif == 2) || (xDif == 2 && yDif == 1)) { 
			
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
	public int[][] drawMove(int xStart, int yStart, int xDes, int yDes) {

		int pairs = 0;
		int [][] journey = new int[2][pairs];

		return journey;
	}
}
