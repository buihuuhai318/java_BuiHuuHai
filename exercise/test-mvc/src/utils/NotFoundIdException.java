package utils;

public class NotFoundIdException extends Exception {
    public NotFoundIdException() {
    }

    public NotFoundIdException(String message) {
        super(message);
    }
}
