package pairmatching.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mission {
    private final String name;
    private List<List<String>> pairMatching;

    public Mission(String name) {
        this.name = name;
        pairMatching = new ArrayList<>();
    }

    public boolean checkMatching() {
        if (pairMatching.isEmpty()) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<List<String>> getPairMatching() {
        return List.copyOf(pairMatching);
    }

    public void setPairMatching(List<List<String>> pairMatching) {
        this.pairMatching = pairMatching;
    }
}
