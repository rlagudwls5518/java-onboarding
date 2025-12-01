package onboarding.problem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculatorCrew {

    private final List<Crew> crewList;
    private final Map<String, Set<String>> subToEmails = new HashMap<>();

    public CalculatorCrew(List<Crew> crewList) {
        this.crewList = crewList;
    }

    public List<String> calculator() {
        buildMap();
        return collectDuplicates();
    }

    private void buildMap() {
        for (Crew crew : crewList) {
            for (String sub : getSubstrings(crew.getNickname())) {
                subToEmails.putIfAbsent(sub, new HashSet<>());
                subToEmails.get(sub).add(crew.getEmail());
            }
        }
    }

    private List<String> collectDuplicates() {
        Set<String> duplicated = new HashSet<>();

        for (Set<String> emails : subToEmails.values()) {
            if (emails.size() > 1) {
                duplicated.addAll(emails);
            }
        }

        return duplicated.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> getSubstrings(String nickname) {
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            subs.add(nickname.substring(i, i + 2));
        }
        return subs;
    }
}
