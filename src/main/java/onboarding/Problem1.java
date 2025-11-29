package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1 {
    private static final int EXEPTION_NUMBER = -1;
    private static final int INDEX_NUMBER_ONE = 1;
    private static final int INDEX_NUMBER_ZERO = 0;
    private static final int MAX_PAGE_NUMBER = 400;
    private static final int MIN_PAGE_NUMBER = 1;
    private static final int POBI_WIN_NUMBER = 1;
    private static final int CRONG_WIN_NUMBER = 2;
    private static final int NO_WINNER = 0;

    private static final int TEN = 10;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int EVEN_CHECK = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return gameProcess(pobi, crong);
    }

    private static int gameProcess(List<Integer> pobi, List<Integer> crong) {
        if(numberValidator(pobi) == EXEPTION_NUMBER || numberValidator(crong) == EXEPTION_NUMBER) {
            return EXEPTION_NUMBER;
        }
        int pobiMaxNumber = processAdd(pobi);
        int crongMaxNumber = processAdd(crong);

        return isBigResult(pobiMaxNumber, crongMaxNumber);
    }
    private static int processAdd(List<Integer> name) {
        List<Integer> numbers = new ArrayList<>();

        for(Integer i : name){
            int a = addNumbers(i);
            int b = duplicateNumbers(i);
            numbers.add(isBigNumber(a,b));
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
    private static int isBigNumber(int num1, int num2) {
        return Math.max(num2, num1);
    }
    private static int isBigResult(int pobiMaxNumber, int crongMaxNumber) {
        if(pobiMaxNumber > crongMaxNumber){
            return POBI_WIN_NUMBER;
        }
        if(pobiMaxNumber < crongMaxNumber){
            return CRONG_WIN_NUMBER;
        }
        return NO_WINNER;
    }
    private static int numberValidator(List<Integer> name) {
        if(name.contains(MIN_PAGE_NUMBER) ||  name.contains(MAX_PAGE_NUMBER) ){
            return EXEPTION_NUMBER;
        }
        if(name.get(INDEX_NUMBER_ZERO) % EVEN_CHECK == ZERO || name.get(INDEX_NUMBER_ONE) % EVEN_CHECK != ZERO){
            return EXEPTION_NUMBER;
        }
        if(name.get(INDEX_NUMBER_ONE)-name.get(INDEX_NUMBER_ZERO) != ONE){
            return EXEPTION_NUMBER;
        }

        return ZERO;
    }
}