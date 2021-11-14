package fa.training.problem02.exception;

public class InvalidDateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidDateException() {
		super();
	}

	public InvalidDateException(String message) {
		super(message);
	}

	public InvalidDateException(Throwable cause) {
		super(cause);
	}
}
