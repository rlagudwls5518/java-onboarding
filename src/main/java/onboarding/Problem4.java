package onboarding;

public class Problem4 {
    public static String solution(String word) {

        char[] ch = word.toCharArray();
        char[] temp = new char[ch.length];
        for(int i = 0; i < ch.length; i++){
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                temp[i] = (char) ('a' + ('z' - ch[i]));
            }
            else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                temp[i] = (char) ('A' + ('Z' - ch[i]));
            }
            else {
                temp[i] = ch[i];
            }
        }

        StringBuilder answer = new StringBuilder();
        for(char c : temp){
            answer.append(c);
        }
        return answer.toString();
    }
}
