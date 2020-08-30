package Piece;

import Exception.InvalidPathException;
import Game.*;

/**
 * This Abstract class contains data and methods that relate to the movement of the Chess Pieces
 *
 * @author Jose Santos 17993442
 */
public abstract class Piece {

	protected Rank rank;
    private Player player;

    public Piece(Player player) {
 
       this.player = player;
    }

    public Player getPlayer() {
   
    	return this.player;
    }

	public Rank getRank() {
	
		return this.rank;
	}

	public void setRank(Rank rank) {

		this.rank = rank;
	}

	/**
	 * determines if the move done by the user is valid 
	 *
	 * @param bSquare 		the square that the pawn is currently in. used to acquire its x and y value
	 * @param xDes 			the x destination the player wants to go
	 * @param yDes 			the y destination the player wants to go 
	 * @return 				a boolean indicating if the move is valid
	 * @throws InvalidPathException 
	 */
	public abstract boolean isValidPath(BoardSquare bSquare, int xDes, int yDes) throws InvalidPathException;

	/**
	 * This method draws a path from one point to another based on the piece type and returns the coordinates
	 *
	 * @param xStart 		x starting point
	 * @param yStart 		y starting point
	 * @param xDes 			x destination point the player is moving the piece to
	 * @param yDes 			y destination point the player is moving the piece to
	 * @return path an integer array containing the coordinates of the given path
	 */
	public abstract int[][] drawMove(int xStart, int yStart, int xDes, int yDes);


 	public String toString() {

		return String.valueOf(player.getSide().name().charAt(0)) + String.valueOf( this.getRank().name());

	}

}
