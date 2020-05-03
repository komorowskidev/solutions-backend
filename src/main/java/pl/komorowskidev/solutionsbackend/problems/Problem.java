package pl.komorowskidev.solutionsbackend.problems;

import pl.komorowskidev.solutionsbackend.exceptions.DataNotValidException;

public interface Problem {

    String getName();

    String getDescription();

    String getExampleData();

    String getSolution(String data) throws DataNotValidException;

}
