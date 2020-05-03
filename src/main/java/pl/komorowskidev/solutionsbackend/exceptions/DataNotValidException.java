package pl.komorowskidev.solutionsbackend.exceptions;

public class DataNotValidException extends Exception {

    public DataNotValidException(String errorMessage) {
        super(errorMessage);
    }
}
