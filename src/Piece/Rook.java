package Piece;

import Game.*;
import Exception.InvalidPathException;
/**
* This class stores data relating to the movement limitations of the Rook Piece,
*
* @author Jose Santos 17993442
*
*/
public class Rook extends Piece{

	public Rook(Player player){

	    super(player);
	    this.setRank(Rank.ROOK);
	}
	
	
	/**
	 * determines whether the path given to the rook is valid
	 * 		- 	since the rook only moves on straight lines, the method only checks 
	 * 			if the yDes value is the same as the initial yPos or if 
	 * 			the xDes value is the same as the xPos value
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return 				a boolean indicating if the move is valid
	 * @throws InvalidPathException 
	 */
	@Override
	public boolean isValidPath(BoardSquare bSquare, int xDes, int yDes) throws InvalidPathException  {
	
		if ((xDes == bSquare.getxPos() )|| (yDes == bSquare.getyPos()) == true){
			
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
		int xDir = 0 , yDir = 0;

		if (xDes - xStart != 0 && yStart == yDes) { // rook is traveling horizontally
			pairs = Math.abs(xDes - xStart);
			if (xDes - xStart < 0)
			{
				xDir = -1;
			}
			else
				xDir = 1;
		
		} else { // rook is traveling vertically
		
			pairs = Math.abs(yDes - yStart);
			
			if (yDes - yStart < 0)
				yDir = -1;
			 else 
				yDir = 1;
			
		}

		int[][] journey = new int[2][pairs];
		
		if (pairs - 1 > 0) {
			for(int i = 0; i < pairs - 1; i++) {
				journey[0][i] = xStart + xDir;
				journey[1][i] = yStart + yDir;
			}
		}
		
		return journey;
	}
}
