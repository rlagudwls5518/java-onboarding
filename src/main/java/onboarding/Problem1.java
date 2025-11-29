package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1 {
    private static final int RIGHT_PAGE_INDEX = 1;
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int MAX_PAGE_NUMBER = 400;
    private static final int MIN_PAGE_NUMBER = 1;
    private static final int TEN = 10;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int EVEN_CHECK = 2;

    private enum GameResult {
        POBI(1), CRONG(2), DRAW(0), EXCEPTION(-1);

        private final int value;

        GameResult(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return gameProcess(pobi, crong);
    }

    private static int gameProcess(List<Integer> pobi, List<Integer> crong) {
        if (numberValidator(pobi) || numberValidator(crong)) {
            return GameResult.EXCEPTION.getValue();
        }
        int pobiMaxNumber = calculateMaxScore(pobi);
        int crongMaxNumber = calculateMaxScore(crong);

        return determineWinner(pobiMaxNumber, crongMaxNumber);
    }

    private static int calculateMaxScore(List<Integer> name) {
        List<Integer> numbers = new ArrayList<>();
        for (Integer page : name) {
            int allAddNumber = addNumbers(page);
            int allDuplicateNumber = duplicateNumbers(page);
            numbers.add(getMaxOfTwoNumbers(allAddNumber, allDuplicateNumber));
        }
        return Collections.max(numbers);
    }

    private static int addNumbers(int pageNumber) {
        int sum = ZERO;
        while (pageNumber > ZERO) {
            sum += pageNumber % TEN;
            pageNumber /= TEN;
        }
        return sum;
    }

    private static int duplicateNumbers(int pageNumber) {
        int sum = ONE;
        while (pageNumber > ZERO) {
            sum *= pageNumber % TEN;
            pageNumber /= TEN;
        }
        return sum;
    }

    private static int getMaxOfTwoNumbers(int num1, int num2) {
        return Math.max(num2, num1);
    }

    private static int determineWinner(int pobiMaxNumber, int crongMaxNumber) {
        if (pobiMaxNumber > crongMaxNumber) {
            return GameResult.POBI.getValue();
        }
        if (pobiMaxNumber < crongMaxNumber) {
            return GameResult.CRONG.getValue();
        }
        return GameResult.DRAW.getValue();
    }

    private static boolean numberValidator(List<Integer> name) {
        if (name.contains(MIN_PAGE_NUMBER) || name.contains(MAX_PAGE_NUMBER)) {
            return false;
        }
        if (name.get(LEFT_PAGE_INDEX) % EVEN_CHECK == ZERO || name.get(RIGHT_PAGE_INDEX) % EVEN_CHECK != ZERO) {
            return false;
        }
        if (name.get(RIGHT_PAGE_INDEX) - name.get(LEFT_PAGE_INDEX) != ONE) {
            return false;
        }
        return true;
    }
}
