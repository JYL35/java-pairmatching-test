package pairmatching.constant;

public enum ErrorMessage {
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
