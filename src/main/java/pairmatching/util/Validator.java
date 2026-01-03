package pairmatching.util;

import java.util.List;
import pairmatching.constant.ErrorMessage;

public class Validator {

    public static void validateOption(List<String> options, String input) {
        validateEmpty(input);
        validateContains(options, input);
    }

    public static void validateOptions(String[] options) {
        if (options.length != 3) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }

        for (String option : options) {
            validateEmpty(option);
        }
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getMessage());
        }
    }

    private static void validateContains(List<String> options, String input) {
        if (!options.contains(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INCLUDED.getMessage());
        }
    }
}
