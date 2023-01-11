package pl.lodz.p.sudoku;

public class MyException extends Exception {

    public MyException(final String messageKey) {
        super(messageKey);
    }

    public MyException(final String messageKey, final Throwable cause) {
        super(messageKey, cause);
    }
}
