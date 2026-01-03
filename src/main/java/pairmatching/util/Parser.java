package pairmatching.util;

public class Parser {

    public static String[] optionParse(String courseAndLevelAndMission) {
        String[] options = courseAndLevelAndMission.split(",");

        Validator.validateOptions(options);

        options[0] = options[0].strip();
        options[1] = options[1].strip();
        options[2] = options[2].strip();
        return options;
    }
}
