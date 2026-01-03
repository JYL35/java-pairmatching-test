package pairmatching.domain;

import java.util.List;
import pairmatching.repository.MissionRepository;

public class Level {
    private final String name;
    private final MissionRepository missionRepository;

    public Level(String name, MissionRepository missionRepository) {
        this.name = name;
        this.missionRepository = missionRepository;
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return missionRepository.missions();
    }

    public Mission findMission(String name) {
        return missionRepository.findByName(name);
    }
}
