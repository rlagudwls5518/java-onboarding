package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return gameProcess(pobi, crong);
    }

    private static int gameProcess(List<Integer> pobi, List<Integer> crong) {
        if(numberValidator(pobi) == -1 || numberValidator(crong) == -1) {
            return -1;
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
        int sum =0;
        int b = 0;
        while (pageNumber > 0) {
            sum += pageNumber % 10;
            pageNumber /= 10;
        }

        if(b < sum){
            b = sum;
        }
        return b;
    }
    private static int duplicateNumbers(int pageNumber) {
        List<Integer> numbers = new ArrayList<>();
        int sum = 1;

        while (pageNumber > 0) {
            numbers.add(pageNumber % 10);
            pageNumber /= 10;
        }
        for(int i :  numbers){
            sum = sum * i;
        }
        return sum;
    }
    private static int isBigNumber(int num1, int num2) {
        return Math.max(num2, num1);
    }
    private static int isBigResult(int pobiMaxNumber, int crongMaxNumber) {
        if(pobiMaxNumber > crongMaxNumber){
            return 1;
        }
        if(pobiMaxNumber < crongMaxNumber){
            return 2;
        }
        return 0;
    }

    private static int numberValidator(List<Integer> name) {
        if(name.contains(1) ||  name.contains(400) ){
            return -1;
        }
        if(name.get(0) % 2 == 0 || name.get(1) % 2 != 0){
            return -1;
        }
        if(name.get(1)-name.get(0) != 1){
            return -1;
        }

        return 0;
    }
}