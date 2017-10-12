public class InvalidGridOperationException extends RuntimeException {
    public static final String COLUMN_DOES_NOT_EXIST_MESSAGE = "column does not exist.";
    public static final String COLUMN_IS_FULL_MESSAGE = "column is full.";
    public InvalidGridOperationException(String message) {
        super(message);
    }
}
