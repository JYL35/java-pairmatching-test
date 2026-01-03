package pairmatching.init;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.CourseRepository;
import pairmatching.repository.LevelRepository;
import pairmatching.repository.MissionRepository;

public class ProgramInitializer {
    private static final List<String> COURSES = List.of("백엔드", "프론트엔드");
    private static final List<String> LEVEL_1 = List.of("자동차경주", "로또", "숫자야구게임");
    private static final List<String> LEVEL_2 = List.of("장바구니", "결제", "지하철노선도");
    private static final List<String> LEVEL_4 = List.of("성능개선", "배포");

    public static void initialize() {
        for (String course : COURSES) {
            CourseRepository.addCourse(initCourse(course));
        }
    }

    public static void deleteAll() {
        CourseRepository.deleteAll();
    }

    private static Course initCourse(String name) {
        LevelRepository levelRepository = new LevelRepository();

        levelRepository.addLevel(initLevel("레벨1", LEVEL_1));
        levelRepository.addLevel(initLevel("레벨2", LEVEL_2));
        levelRepository.addLevel(initLevel("레벨4", LEVEL_4));

        return new Course(name, levelRepository);
    }

    private static Level initLevel(String name, List<String> missions) {
        MissionRepository missionRepository = new MissionRepository();

        for (String mission : missions) {
            missionRepository.addMission(new Mission(mission));
        }

        return new Level(name, missionRepository);
    }
}
