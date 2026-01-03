package pairmatching.domain;

import java.util.HashMap;
import java.util.Map;

public class Matching {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private Map<String, String> pairMatching;

    public Matching(Course course, Level level,
                    Mission mission, HashMap<String, String> pairMatching) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairMatching = pairMatching;
    }

    public boolean findPair(Map<String, String> otherPairMatching) {
        for (String key : otherPairMatching.keySet()) {
            if (pairMatching.get(key).equals(otherPairMatching.get(key))) {
                return true;
            }
        }
        return false;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public Map<String, String> getPairMatching() {
        return Map.copyOf(pairMatching);
    }

    public void setPairMatching(Map<String, String> pairMatching) {
        this.pairMatching = pairMatching;
    }
}
