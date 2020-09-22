package pl.komorowskidev.solutionsbackend.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.komorowskidev.solutionsbackend.beans.ProblemDto;
import pl.komorowskidev.solutionsbackend.exceptions.DataNotValidException;
import pl.komorowskidev.solutionsbackend.problems.Problem;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class SolutionService {

    private final Map<Long, Problem> problemMap;

    private AtomicLong problemId;

    public SolutionService() {
        problemId = new AtomicLong();
        problemMap = new TreeMap<>();
    }

    public void addProblem(Problem problem){
        problemMap.put(problemId.getAndIncrement(), problem);
    }

    public List<Map<String, Object>> getProblems(String[] fields) {
        List<Map<String, Object>> result = new ArrayList<>();
        if(fields.length > 0){
            List<String> fieldList = Arrays.asList(fields);
            Iterator<Map.Entry<Long, Problem>> iterator = problemMap.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Long, Problem> entry = iterator.next();
                Map<String, Object> fieldMap = getFieldMap(entry.getKey(), entry.getValue(), fieldList);
                if(!fieldMap.isEmpty()){
                    result.add(fieldMap);
                }
            }
        }
        return result;
    }

    private Map<String, Object> getFieldMap(Long key, Problem value, List<String> fieldList) {
        Map<String, Object> fieldMap = new HashMap<>();
        if(fieldList.contains("id")){
            fieldMap.put("id", key);
        }
        if(fieldList.contains("name")){
            fieldMap.put("name", value.getName());
        }
        if(fieldList.contains("description")){
            fieldMap.put("description", value.getDescription());
        }
        if(fieldList.contains("example")){
            fieldMap.put("example", value.getExampleData());
        }
        return fieldMap;
    }

    public ProblemDto getProblem(Long id){
        Problem problem = problemMap.get(id);
        return problem == null ? new ProblemDto(id,"", "", "") : new ProblemDto(id, problem.getName(), problem.getDescription(), problem.getExampleData());
    }

    public Map<String, Object> getSolution(Long id, String data){
        Problem problem = problemMap.get(id);
        String result = "";
        if(problem != null) {
            result = getSolution(problem, data);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("solution", result);
        return resultMap;
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
