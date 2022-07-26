package ir.maktabsharif;

import java.util.ArrayList;
import java.util.List;

public class Number {
    public List<Integer> Computing(String input) {
        List<Integer> list = new ArrayList<>();

        String[] inputList = input.split("[\\sa-z]+");

        for (int i = 0; i < inputList.length; i++) {
            if (!inputList[i].equals("")) {
                int number = Integer.parseInt(inputList[i]);

                if (number >= 100)
                    list.add(number);
            }
        }

        return list;
    }
}
