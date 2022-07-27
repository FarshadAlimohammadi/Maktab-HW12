package ir.maktabsharif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Number {
    public List<Integer> Computing(String input) {
        List<Integer> list = new ArrayList<>();

        String[] inputList = input.split("[\\sa-z]");

        list = Arrays.stream(inputList).filter(e -> e.length() > 2).map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        return list;
    }
}
