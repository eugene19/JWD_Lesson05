package by.epamtc.degtyarovea.exception;

public class NoSuchDeviceTypeException extends Exception {

    public NoSuchDeviceTypeException() {
        super();
    }

    public NoSuchDeviceTypeException(String message) {
        super(message);
    }

    public NoSuchDeviceTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchDeviceTypeException(Throwable cause) {
        super(cause);
    }
}
