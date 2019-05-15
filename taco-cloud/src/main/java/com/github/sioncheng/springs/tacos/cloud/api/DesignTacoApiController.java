package com.github.sioncheng.springs.tacos.cloud.api;

import com.github.sioncheng.springs.tacos.cloud.repo.TacoRepository;
import com.github.sioncheng.springs.tacos.cloud.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoApiController {

    @Autowired
    private TacoRepository tacoRepo;

    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        return Arrays.asList(new Taco(), new Taco());
    }

    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if (optTaco.isPresent()) {
            return optTaco.get();
        }
        return null;
    }
}
