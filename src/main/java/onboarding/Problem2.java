package onboarding;

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = calculate(cryptogram);
        return answer;
    }
    private static String calculate(String cryptogram) {
        String answer = "";
        Stack<Character> tower = new Stack<>();
        tower.push(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            if (tower.peek() == cryptogram.charAt(i)) {
                tower.pop();
            }
            else  {
                tower.push(cryptogram.charAt(i));
            }
        }

        for(char c : tower) {
            answer += c;
        }
        return answer;
    }
}
