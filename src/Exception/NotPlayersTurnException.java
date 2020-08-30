package Exception;

public class NotPlayersTurnException extends Exception{

	public NotPlayersTurnException() {
		System.err.println("Invalid Move! Wrong sides turn");
	}
}
