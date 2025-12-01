package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class CrewParser {
    private final List<List<String>> crews;

    public CrewParser(List<List<String>> crews) {
        this.crews = crews;
    }

    public List<Crew> parseCrew(){
        List<Crew> crewObjects = new ArrayList<>();

        for (List<String> crewInfo : this.crews){
            String nickName = crewInfo.get(1);
            String email = crewInfo.get(0);
            crewObjects.add(new Crew(nickName, email));
        }
        return crewObjects;
    }
}
