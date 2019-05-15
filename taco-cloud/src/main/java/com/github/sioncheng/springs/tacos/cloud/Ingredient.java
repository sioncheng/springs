package com.github.sioncheng.springs.tacos.cloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }


    private final String id;
    private final String name;
    private final Type type;


}
