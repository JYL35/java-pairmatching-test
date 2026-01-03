package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.init.ProgramInitializer;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        ProgramInitializer.initialize();
        MatchingController matchingController = new MatchingController(
                new MatchingService(), new InputView(), new OutputView()
        );
        matchingController.start();
    }
}
