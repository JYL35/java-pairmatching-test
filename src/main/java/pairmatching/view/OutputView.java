package pairmatching.view;

import java.util.List;

public class OutputView {
    private static final String OPTION_GUIDE = "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################";

    public void printOptionGuide() {
        printNewLine();
        System.out.println(OPTION_GUIDE);
    }

    public void printDeleteAll() {
        printNewLine();
        System.out.println("초기화 되었습니다.");
        printNewLine();
    }

    public void printRoster(List<List<String>> pairRoster) {
        printNewLine();
        System.out.println("페어 매칭 결과입니다.");
        for (List<String> pair : pairRoster) {
            System.out.println(pair.getFirst() + " : " + pair.getLast());
        }
        printNewLine();
    }

    public void printError(RuntimeException e) {
        printNewLine();
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
