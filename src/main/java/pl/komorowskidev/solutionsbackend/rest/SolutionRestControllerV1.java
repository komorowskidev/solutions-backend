package pl.komorowskidev.solutionsbackend.rest;

import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.*;
import pl.komorowskidev.solutionsbackend.beans.ProblemDto;
import pl.komorowskidev.solutionsbackend.services.SolutionService;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class SolutionRestControllerV1 {

    private final String appVersion;

    private final SolutionService solutionService;

    public SolutionRestControllerV1(BuildProperties buildProperties, SolutionService solutionService) {
        appVersion = buildProperties.getVersion();
        this.solutionService = solutionService;
    }

    @GetMapping("/version")
    public String getApplicationVersion(){
        return appVersion;
    }

    @GetMapping("/problems")
    public List<Map<String, Object>> getProblems(@RequestParam(value = "fields", defaultValue = "") String fields) {
        return solutionService.getProblems(fields.split(","));
    }

    @GetMapping("/problems/:{id}")
    public ProblemDto getProblem(@PathVariable Long id) {
        return solutionService.getProblem(id);
    }

    @PostMapping("/problems/:{id}")
    public Map<String, Object> getSolution(@PathVariable Long id, @RequestBody String data) {
        return solutionService.getSolution(id, data);
    }

}
