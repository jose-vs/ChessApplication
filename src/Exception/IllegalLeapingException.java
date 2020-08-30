package Exception;

public class IllegalLeapingException extends Exception{

	public IllegalLeapingException() {
		System.err.println("Invalid Move! Illegal Leaping");
	}
}
