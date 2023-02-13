package ro.sda.andrei;

public class OutOfOffersException extends RuntimeException {

    public OutOfOffersException(){
        super("Out of offers!");
    }
}
