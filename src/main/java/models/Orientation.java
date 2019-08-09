package models;

import lombok.Getter;

import java.util.Arrays;

public enum Orientation {

    NORTH("N"),
    EAST("E"),
    WEST("W"),
    SOUTH("S");

    @Getter
    private final String name;

    Orientation(String name) {
        this.name = name;
    }

    public static Orientation find(String name) {
        return Arrays.stream(Orientation.values())
                .filter(orientation -> orientation.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(name + "not found"));

    }

}
