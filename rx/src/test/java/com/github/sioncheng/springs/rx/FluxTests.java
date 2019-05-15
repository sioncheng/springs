package com.github.sioncheng.springs.rx;


import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class FluxTests {

    @Test
    public void testCreateFlux() {
        Flux<String> stringFlux = Flux.just("a", "b", "c", "d", "e");

        Assert.assertNotNull(stringFlux);


        StepVerifier.create(stringFlux)
                .expectNext("a")
                .expectNext("b")
                .expectNext("c")
                .expectNext("d")
                .expectNext("e")
                .verifyComplete();
    }

    @Test
    public void testMergeFlux() {
        Flux<String> stringFlux1 = Flux.just("a", "b");
        Flux<String> stringFlux2 = Flux.just("c", "d", "e");

        StepVerifier.create(stringFlux1.mergeWith(stringFlux2))
                .expectNext("a")
                .expectNext("b")
                .expectNext("c")
                .expectNext("d")
                .expectNext("e")
                .verifyComplete();
    }

    @Test
    public void collectList() {
        Flux<String> fruitFlux = Flux.just(
                "apple", "orange", "banana", "kiwi", "strawberry");
        Mono<List<String>> fruitListMono = fruitFlux.collectList();
        StepVerifier
                .create(fruitListMono)
                .expectNext(Arrays.asList(
                        "apple", "orange", "banana", "kiwi", "strawberry"))
                .verifyComplete();
    }

    @Test
    public void all() {
        Flux<String> animalFlux = Flux.just(
                "aardvark", "elephant", "koala", "eagle", "kangaroo");
        Mono<Boolean> hasAMono = animalFlux.all(a -> a.contains("a"));
        StepVerifier.create(hasAMono)
                .expectNext(true)
                .verifyComplete();
        Mono<Boolean> hasKMono = animalFlux.all(a -> a.contains("k"));
        StepVerifier.create(hasKMono)
                .expectNext(false)
                .verifyComplete();
    }
}
