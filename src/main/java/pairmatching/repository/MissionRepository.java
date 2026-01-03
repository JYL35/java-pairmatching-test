package pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import pairmatching.constant.ErrorMessage;
import pairmatching.domain.Mission;

public class MissionRepository {
    private final List<Mission> missions = new ArrayList<>();

    public List<Mission> missions() {
        return Collections.unmodifiableList(missions);
    }

    public void addMission(Mission mission) {
        missions.add(mission);
    }

    public boolean deleteMission(String name) {
        return missions.removeIf(mission -> Objects.equals(mission.getName(), name));
    }

    public void deleteAll() {
        missions.clear();
    }

    public Mission findByName(String name) {
        return missions.stream()
                .filter(mission -> Objects.equals(mission.getName(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_MISSION.getMessage()));
    }
}
