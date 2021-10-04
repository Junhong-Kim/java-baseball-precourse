package baseball.model;

import baseball.common.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void initNumbers(InputNumber inputNumber) {
        if (inputNumber == null) {
            throw new NullPointerException(Messages.INPUT_NUMBER_CAN_NOT_BE_NULL);
        }
        clearNumbers();
        String[] split = Integer.toString(inputNumber.getNumber()).split("");
        numbers.addAll(Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void clearNumbers() {
        if (!numbers.isEmpty()) {
            numbers.clear();
        }
    }
}
