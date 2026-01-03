package pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import pairmatching.constant.ErrorMessage;
import pairmatching.domain.Course;

public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();

    public static List<Course> courses() {
        return Collections.unmodifiableList(courses);
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }

    public static boolean deleteCourse(String name) {
        return courses.removeIf(course -> Objects.equals(course.getName(), name));
    }

    public static void deleteAll() {
        courses.clear();
    }

    public static Course findByName(String name) {
        return courses.stream()
                .filter(course -> Objects.equals(course.getName(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_COURSE.getMessage()));
    }

    public static boolean isExist(String courseName, String levelName, String missionName) {
        return courses.stream()
                .filter(course -> Objects.equals(course.getName(), courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_COURSE.getMessage()))
                .findLevel(levelName)
                .findMission(missionName)
                .checkMatching();
    }

    public static void setPairMatching(String courseName, String levelName, String missionName, List<List<String>> pairMatched) {
        courses.stream()
                .filter(course -> Objects.equals(course.getName(), courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_COURSE.getMessage()))
                .findLevel(levelName)
                .findMission(missionName)
                .setPairMatching(pairMatched);
    }

    public static List<List<String>> getPairMatching(String courseName, String levelName, String missionName) {
        return courses.stream()
                .filter(course -> Objects.equals(course.getName(), courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_COURSE.getMessage()))
                .findLevel(levelName)
                .findMission(missionName)
                .getPairMatching();
    }
}
