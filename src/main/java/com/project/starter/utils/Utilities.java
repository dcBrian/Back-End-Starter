package com.project.starter.utils;

import java.util.List;
import java.util.stream.Collectors;

public final class Utilities {

    private Utilities() {
        throw new UnsupportedOperationException("Utility class!");
    }

    public static <T> List<T> findDifferentElements(List<T> listOne, List<T> listTwo) {
        return listOne.stream().filter(element -> !listTwo.contains(element)).collect(Collectors.toList());

    }

}
