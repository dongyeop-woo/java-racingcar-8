package racingcar.exception;

import racingcar.constants.RacingConstants;

public class Validator {
    public static void validateCarName(String name) {
        if (isNullOrEmpty(name)) {
            throw new RacingCarException();
        }
        validateTrimmedName(name);
    }

    private static void validateTrimmedName(String name) {
        String trimmedName = name.trim();
        if (isInvalidLength(trimmedName)) {
            throw new RacingCarException();
        }
    }

    public static void validateCarNames(String input) {
        if (isNullOrEmpty(input)) {
            throw new RacingCarException();
        }
        String[] names = input.split(",");
        validateEachCarName(names);
    }

    private static void validateEachCarName(String[] names) {
        for (String name : names) {
            validateCarName(name);
        }
    }

    public static void validateTryCount(String input) {
        if (isNullOrEmpty(input)) {
            throw new RacingCarException();
        }
        validateNumericInput(input);
        validateCountValue(input);
    }

    private static void validateNumericInput(String input) {
        if (!isNumeric(input)) {
            throw new RacingCarException();
        }
    }

    private static void validateCountValue(String input) {
        int count = Integer.parseInt(input);
        if (isInvalidCount(count)) {
            throw new RacingCarException();
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isInvalidLength(String name) {
        return name.isEmpty() || name.length() > RacingConstants.MAX_CAR_NAME_LENGTH;
    }

    private static boolean isNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static boolean isInvalidCount(int count) {
        return count < RacingConstants.MIN_TRY_COUNT;
    }
}

