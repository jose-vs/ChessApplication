package Piece;


import Exception.InvalidPathException;
import Game.*;

/**
* This class stores data relating to the movement limitations of the King Piece
* 
* @author Jose Santos 
*
*/
public class King extends Piece {

	public King(Player player){
	
	    super(player);
	    this.setRank(Rank.KING);
	}

	/**
	 * determines if the path taken by the king is valid
	 * 		-	a king can only move one square at a time so this method if the absolute 
	 * 			value of the x and y difference is less than 2 because they could only 
	 * 			be 1 or 0
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return 				a boolean indicating if the move is valid
	 * @throws InvalidPathException 
	 */
	
	@Override
	public boolean isValidPath(BoardSquare bSquare, int xDes, int yDes) throws InvalidPathException {
		
		int xDifference = Math.abs(xDes - bSquare.getxPos());
		int yDifference = Math.abs(yDes - bSquare.getyPos());

		if((xDifference < 2) && (yDifference < 2)) {

			return true;

		} else {
			
			throw new InvalidPathException();
			
		}
	}
/*
	public boolean path(BoardSquare bSquare, int xDes, int yDes){

		int xDifference = Math.abs(xDes - bSquare.getxPos());
		int yDifference = Math.abs(yDes - bSquare.getyPos());

		return ((xDifference < 2) && (yDifference < 2));
	}

	public boolean inCheck(int xKing, int yKing) {

		HashSet<Piece> enemies = this.getPlayer().getEnemyPieces();

		for (Piece e : enemies) {

			if (canKillKing(e, xKing, yKing)) {

				return true;
			}
		}
        return false;
	}

	public boolean canKillKing(Piece enemy, int xKing, int yKing) {
		Board board = enemy.getPlayer().game.gameBoard;

		if(enemy.getRank() == Rank.PAWN && (board.isValidPath(enemy, xKing, yKing) && enemy.isValidPath(xKing, yKing)))
        {
            return true;
        }
	}
*/
	
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
}
