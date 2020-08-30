package Exception;

public class PieceHasNotMovedException extends Exception{

	public PieceHasNotMovedException() {
		System.err.println("Invalid Move! Piece has not moved");
	}

}
