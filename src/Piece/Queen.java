package Piece;

import Game.*;
import Exception.InvalidPathException;
/**
* This class stores data relating to the movement limitations of the Queen Piece,
*
* @author Jose Anderson 17993442
*
*/
public class Queen extends Piece {

	public Queen(Player player){

	    super(player);
	    this.setRank(Rank.QUEEN);
	}

	
	/**
	 * determines if the path given to the queen is valid
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return 				a boolean indicating if the move is valid
	 * @throws InvalidPathException 
	 */
	@Override
	public boolean isValidPath(BoardSquare bSquare, int xDes, int yDes) throws InvalidPathException {

		int xChange = Math.abs(xDes - bSquare.getxPos());
		int yChange = Math.abs(yDes - bSquare.getyPos());

		if((xChange == yChange) || (xDes == bSquare.getxPos()) || (yDes == bSquare.getyPos())){  
			
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
	
		int pairs;
		int xDirection = 0;
		int yDirection = 0;

		if (yDes == yStart) 	{
			pairs = Math.abs(xDes - xStart);
			
			if (xDes - xStart < 0) 
				xDirection = -1;
			else
				xDirection = 1;

		} else if (xDes == xStart) {
			
			pairs = Math.abs(yDes - yStart);
			
			if (yDes - yStart < 0)
				yDirection = -1;
			else
				yDirection = 1;

		} else {
			pairs = Math.abs(xDes - xStart);

			if (xDes - xStart < 0)	
				xDirection = -1;
			else
				xDirection = 1;

			if (yDes - yStart < 0)
				yDirection = -1;
			else
				yDirection = 1;
		}

		int[][] journey = new int[2][pairs];

		if (pairs - 1 > 0)	{
			for (int i = 0; i < pairs - 1; i++){
				
				journey[0][i] = xStart + xDirection;
				journey[1][i] = yStart + yDirection;
			}
		}
		return journey;
	}
}
