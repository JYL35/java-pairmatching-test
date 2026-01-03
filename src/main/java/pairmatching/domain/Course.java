package pairmatching.domain;


import java.util.List;
import pairmatching.repository.LevelRepository;

public class Course {
    private final String name;
    private final LevelRepository levelRepository;

    public Course(String name, LevelRepository levelRepository) {
        this.name = name;
        this.levelRepository = levelRepository;
    }

    public String getName() {
        return name;
    }

    public List<Level> getLevels() {
        return levelRepository.levels();
    }

    public Level findLevel(String name) {
        return levelRepository.findByName(name);
    }
}
