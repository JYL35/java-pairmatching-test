package pairmatching.controller;

import java.util.List;
import pairmatching.util.Parser;
import pairmatching.util.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public MatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        while (true) {
            try {
                String funcOption = inputView.readFuncOption();
                Validator.validateOption(List.of("1", "2", "3", "Q"), funcOption);
                if (funcOption.equals("Q")) break;

                if (funcOption.equals("1")) pairMatch();
                // 2번 -> 페어 조회
                // 3번 -> 초기화

            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }

    private void pairMatch() {
        String courseAndLevelAndMission = inputView.readCourseLevelMission();
        String[] options = Parser.optionParse(courseAndLevelAndMission);
    }
}
