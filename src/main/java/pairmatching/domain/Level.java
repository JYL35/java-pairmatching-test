package pairmatching.domain;

import pairmatching.constant.ErrorMessage;

public enum Level {
    레벨1,
    레벨2,
    레벨3,
    레벨4,
    레벨5;

    public static Level findLevel(String input) {
        for (Level level : Level.values()) {
            if (level.name().equals(input)) {
                return level;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_LEVEL.getMessage());
    }
}
