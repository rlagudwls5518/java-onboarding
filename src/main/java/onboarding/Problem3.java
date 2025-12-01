package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = game(number);
        return answer;
    }

    private static int game(int numbers){
        int count = 0;

        for (int i = 1; i <= numbers; i++){
            count += parcingNumber(i);
        }
        return count;
    }

    private static int parcingNumber(int index){
        int temp = index;
        int count = 0;

        while (temp > 0){
            int digit = temp % 10;

            if (digit == 3 || digit == 6 || digit == 9) {
                count++;
            }

            temp /= 10;
        }
        return count;
    }
}
