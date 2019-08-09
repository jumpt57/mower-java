package models;

import lombok.Getter;

import java.util.Arrays;

public enum Instruction {

    LEFT("L"),
    RIGHT("R"),
    FORWARD("F");

    @Getter
    private final String name;

    Instruction(String name) {
        this.name = name;
    }

    public static Instruction find(String name) {
        return Arrays.stream(Instruction.values())
                .filter(instruction -> instruction.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(name + "not found"));
    }


}
