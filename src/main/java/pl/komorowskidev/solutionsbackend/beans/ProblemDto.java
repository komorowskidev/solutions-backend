package pl.komorowskidev.solutionsbackend.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProblemDto {

    private Long id;

    private String name;

    private String description;

    private String exampleData;

}
