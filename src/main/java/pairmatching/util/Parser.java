package pairmatching.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static String[] optionParse(String courseAndLevelAndMission) {
        String[] options = courseAndLevelAndMission.split(",");
        options[0] = options[0].strip();
        options[1] = options[1].strip();
        options[2] = options[2].strip();
        return options;
    }
}
