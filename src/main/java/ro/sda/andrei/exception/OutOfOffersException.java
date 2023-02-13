package ro.sda.andrei.exception;

public class OutOfOffersException extends RuntimeException {

    public OutOfOffersException(){
        super("Out of offers!");
    }
}
