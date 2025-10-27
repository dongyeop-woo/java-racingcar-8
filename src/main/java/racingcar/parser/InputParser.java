package racingcar.parser;

import racingcar.exception.Validator;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public void validateCarNames(String input) {
        Validator.validateCarNames(input);
    }

    public void validateTryCount(String input) {
        Validator.validateTryCount(input);
    }

    public List<String> parseCarNames(String input) {
        String[] names = input.split(",");
        return Arrays.stream(names)
            .map(String::trim)
            .toList();
    }

    public int parseTryCount(String input) {
        return Integer.parseInt(input);
    }
}

