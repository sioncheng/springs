package com.github.sioncheng.springs.tacos.cloud.repo;

import com.github.sioncheng.springs.tacos.cloud.Taco;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TacoRepository {

    public Optional<Taco> findById(long id) {
        return Optional.ofNullable(null);
    }
}
