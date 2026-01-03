package pairmatching.domain;

import pairmatching.constant.ErrorMessage;

public enum Course {
    백엔드,
    프론트엔드;

    public static Course findCourse(String input) {
        for (Course course : Course.values()) {
            if (course.name().equals(input)) {
                return course;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_COURSE.getMessage());
    }
}
