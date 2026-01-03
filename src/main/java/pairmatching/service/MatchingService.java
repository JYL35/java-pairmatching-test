package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MatchingService {

    public List<List<String>> createPairRoster(List<String> file) {
        List<List<String>> pairRoster = new ArrayList<>();
        List<String> shuffled = Randoms.shuffle(file);

        for (int i = 0; i < shuffled.size(); i += 2) {
            List<String> pair = new ArrayList<>();
            pair.add(shuffled.get(i));

            if (i + 1 < shuffled.size()) {
                pair.add(shuffled.get(i+1));
            }
            pairRoster.add(pair);
        }

        return pairRoster;
    }
}
