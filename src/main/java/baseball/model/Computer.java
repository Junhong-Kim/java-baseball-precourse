package baseball.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void initNumbers() {
        clearNumbers();
        do {
            addNumber(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        } while (numbers.size() < Balls.MAX_SIZE);
    }

    private void clearNumbers() {
        if (!numbers.isEmpty()) {
            numbers.clear();
        }
    }

    private void addNumber(int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
