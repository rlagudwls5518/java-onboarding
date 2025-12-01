package onboarding;

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = calculate(cryptogram);
        return answer;
    }
    private static String calculate(String cryptogram) {
        Stack<Character> stack = caculateStack(cryptogram);
        return addCharacter(stack);
    }

    private static Stack<Character> caculateStack(String cryptogram) {
        Stack<Character> tower = new Stack<>();
        tower.push(cryptogram.charAt(0));
        calculateProcess(cryptogram, tower);
        return tower;
    }

    private static String addCharacter(Stack<Character> stack) {
        String answer = "";
        for(char c : stack) {
            answer += c;
        }
        return answer;
    }

    private static void calculateProcess(String cryptogram, Stack<Character> tower) {
        for (int index = 1; index < cryptogram.length(); index++) {
            stackProcess(cryptogram,tower,index);
        }
    }

    private static void stackProcess(String cryptogram, Stack<Character> tower, int index) {
        if (tower.peek() == cryptogram.charAt(index)) {
            tower.pop();
        }
        else{
            tower.push(cryptogram.charAt(index));
        }
    }
}
