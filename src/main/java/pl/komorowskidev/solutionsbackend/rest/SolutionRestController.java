package pl.komorowskidev.solutionsbackend.rest;

import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.komorowskidev.solutionsbackend.beans.ProblemDto;
import pl.komorowskidev.solutionsbackend.services.SolutionService;

import java.util.Set;

@RestController
public class SolutionRestController {

    private String appVersion;

    private SolutionService solutionService;

    public SolutionRestController(BuildProperties buildProperties, SolutionService solutionService) {
        appVersion = buildProperties.getVersion();
        this.solutionService = solutionService;
    }

    @GetMapping("/names")
    public Set<String> getNames() {
        return solutionService.getProblemNameSet();
    }

    @GetMapping("/problem")
    public ProblemDto getProblem(@RequestParam(value = "name", defaultValue = "empty") String name) {
        return solutionService.getProblem(name);
    }

    @GetMapping("/solution")
    public String getSolution(@RequestParam(value = "name", defaultValue = "empty") String name, @RequestParam(value
            = "data", defaultValue = "") String data) {
        return solutionService.getSolution(name, data);
    }

    @GetMapping("/version")
    public String getApplicationVersion(){
        return appVersion;
    }
}
