package baseball.model;

import baseball.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputNumber {

    private static final int MIN_NUMBER = 100;
    private static final int MAX_NUMBER = 999;

    private final int number;

    public InputNumber(String input) {
        if (!StringUtils.isNumber(input)) {
            throw new IllegalArgumentException();
        }
        number = Integer.parseInt(input);
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();

        String stringNumber = Integer.toString(number);
        for (String str : stringNumber.split("")) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    public boolean isValid() {
        return isValidRange(MIN_NUMBER, MAX_NUMBER) && isNotContains(0) && isDistinct();
    }

    private boolean isValidRange(int from, int to) {
        return from <= number && number <= to;
    }

    private boolean isNotContains(int digit) {
        String stringNumber = Integer.toString(number);
        return !stringNumber.contains(Integer.toString(digit));
    }

    private boolean isDistinct() {
        String stringNumber = Integer.toString(number);
        Set<Character> set = new HashSet<>();
        for (char ch : stringNumber.toCharArray()) {
            set.add(ch);
        }
        return stringNumber.length() == set.size();
    }
}
