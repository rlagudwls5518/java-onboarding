package onboarding.problem6;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
       CrewParser crewParser = new CrewParser(forms);
       List<Crew> crews = crewParser.parseCrew();
       CalculatorCrew calculatorCrew = new CalculatorCrew(crews);

       return calculatorCrew.calculator();
    }
}
