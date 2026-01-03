package pairmatching.constant;

public enum ErrorMessage {
    NOT_FOUND_COURSE("입력하신 과정은 존재하지 않습니다."),
    NOT_FOUND_LEVEL("입력하신 레벨은 존재하지 않습니다."),
    NOT_FOUND_MISSION("입력하신 미션은 존재하지 않습니다."),
    NOU_FOUND_PAIR_MATCHING("입력하신 미션은 페어 매칭이 되지 않았습니다."),
    IS_EMPTY("빈 값을 입력하셨습니다."),
    NOT_INCLUDED("목록에 존재하지 않은 값을 입력하셨습니다."),
    INVALID_FORMAT("잘못된 형식을 입력하였습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
