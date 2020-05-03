package pl.komorowskidev.solutionsbackend.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.komorowskidev.solutionsbackend.beans.ProblemDto;
import pl.komorowskidev.solutionsbackend.exceptions.DataNotValidException;
import pl.komorowskidev.solutionsbackend.problems.Problem;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Service
@Slf4j
public class SolutionService {

    private Map<String, Problem> problemMap;

    public SolutionService() {
        problemMap = new TreeMap<>();
    }

    public void addProblem(Problem problem){
        problemMap.put(problem.getName(), problem);
    }

    public Set<String> getProblemNameSet() {
        return problemMap.keySet();
    }

    public ProblemDto getProblem(String problemName){
        Problem problem = problemMap.get(problemName);
        return problem == null ? new ProblemDto("", "") : new ProblemDto(problem.getDescription(), problem.getExampleData());
    }

    public String getSolution(String problemName, String data){
        String result = "";
        Problem problem = problemMap.get(problemName);
        if(problem != null) {
            result = getSolution(problem, data);
        }
        return result;
    }

    private String getSolution(Problem problem, String data){
        String result = "";
        try {
            result = problem.getSolution(data);
        } catch (DataNotValidException e) {
            log.error(e.getMessage());
        }
        return result;
    }
}
