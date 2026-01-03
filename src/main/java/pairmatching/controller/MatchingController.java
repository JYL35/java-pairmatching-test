package pairmatching.controller;

import java.util.List;
import pairmatching.init.ProgramInitializer;
import pairmatching.repository.CourseRepository;
import pairmatching.service.MatchingService;
import pairmatching.util.Parser;
import pairmatching.util.TextFileReader;
import pairmatching.util.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final MatchingService matchingService;
    private final InputView inputView;
    private final OutputView outputView;

    public MatchingController(MatchingService matchingService, InputView inputView, OutputView outputView) {
        this.matchingService = matchingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        while (true) {
            try {
                String funcOption = inputView.readFuncOption();
                Validator.validateOption(List.of("1", "2", "3", "Q"), funcOption);
                if (funcOption.equals("Q")) break;
                if (funcOption.equals("1")) func1();
                if (funcOption.equals("2")) func2();
                if (funcOption.equals("3")) func3();
            } catch (RuntimeException e) {
                outputView.printError(e);
                break;
            }
        }
    }

    private void func1() {
        outputView.printOptionGuide();

        for (int i = 0; i < 3; i++) {
            try {
                String courseAndLevelAndMission = inputView.readCourseLevelMission();
                String[] options = Parser.optionParse(courseAndLevelAndMission);

                String course = options[0];
                String level = options[1];
                String mission = options[2];

                if (!CourseRepository.isExist(course, level, mission)) {
                    setPairRoster(course, level, mission);
                    return;
                }
                String reMatch = inputView.readReMatching();
                Validator.validateOption(List.of("네", "아니오"), reMatch);

                if (reMatch.equals("네")) {
                    setPairRoster(course, level, mission);
                    return;
                }
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }

    private void setPairRoster(String course, String level, String mission) {
        List<String> file = TextFileReader.readFile(course);
        List<List<String>> pairRoster = matchingService.createPairRoster(file);
        CourseRepository.setPairMatching(course, level, mission, pairRoster);
        outputView.printRoster(pairRoster);
    }

    private void func2() {
        for (int i = 0; i < 3; i++) {
            try {
                outputView.printOptionGuide();

                String courseAndLevelAndMission = inputView.readCourseLevelMission();
                String[] options = Parser.optionParse(courseAndLevelAndMission);

                String course = options[0];
                String level = options[1];
                String mission = options[2];

                outputView.printRoster(CourseRepository.getPairMatching(course, level, mission));
                break;
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }

    private void func3() {
        ProgramInitializer.deleteAll();
        ProgramInitializer.initialize();
        outputView.printDeleteAll();
    }
}
