package pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import pairmatching.constant.ErrorMessage;
import pairmatching.domain.Level;

public class LevelRepository {
    private final List<Level> levels = new ArrayList<>();

    public List<Level> levels() {
        return Collections.unmodifiableList(levels);
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean deleteLevel(String name) {
        return levels.removeIf(level -> Objects.equals(level.getName(), name));
    }

    public void deleteAll() {
        levels.clear();
    }

    public Level findByName(String name) {
        return levels.stream()
                .filter(level -> Objects.equals(level.getName(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_MISSION.getMessage()));
    }
}
