public class NonexistentColumnException extends IllegalArgumentException {
    public static final String COLUMN_DOES_NOT_EXIST_MESSAGE = "column does not exist.";
    public NonexistentColumnException(String message) {
        super(message);
    }
}
