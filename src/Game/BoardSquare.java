package Game;

import Piece.*;

/**
 * Stores information about a board square which includes 
 * 		* its x and y position
 * 		* the piece currently in its position
 * 		* if it is available
 * 
 * @author Jose Santos
 */

public class BoardSquare {

	private int xPos, yPos;
	private Piece piece;
	private boolean available;
	
	public BoardSquare(int yPos, int xPos) {

		this.xPos = xPos;
		this.yPos = yPos;
		this.piece = null;
		this.setAvailable(true);

	}

	
	/**
	 * checks if the current square is available
	 * by checking if the piece is set to null or not
	 * @return		returns true if it is not available
	 * @author Jose Santos 		
	 */
	public boolean isAvailable() {

		if(this.piece != null) {
			this.setAvailable(false);
			return true;
		}
		 else {
			 this.setAvailable(true);
			 return false;
		 }
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public Piece getPiece() { 
		return this.piece;
	}
	
	public int getxPos() { 
    	return xPos; 
    }
    
    public int getyPos() { 
    	return yPos;
    }
	
	public void setPiece(Piece piece) { 
		this.piece = piece; 
	}

	
	public String toString() {

		if (!this.isAvailable()) {
			
			// prints if the spot does not have a piece
			if ((this.xPos % 2 == 0 && this.yPos % 2 == 0) || 
					((this.xPos+1) % 2 == 0 && (this.yPos+1) % 2 == 0))
				return "[ xxxxxxx ]"; // represents black squares
			else
				return "[ _______ ]"; // represents white squares

		} else {

			return "[ " + String.format("%7s", piece.toString()) + " ]";

		}

	}

}
