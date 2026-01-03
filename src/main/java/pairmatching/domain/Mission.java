package pairmatching.domain;

import pairmatching.constant.ErrorMessage;

public enum Mission {
    자동차경주,
    로또,
    숫자야구게임,
    장바구니,
    결제,
    지하철노선도,
    성능개선,
    배포;

    public static Mission findMission(String input) {
        for (Mission mission : Mission.values()) {
            if (mission.name().equals(input)) {
                return mission;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_MISSION.getMessage());
    }
}
