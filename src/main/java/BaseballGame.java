import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BaseballGame {

    static int strike = 0;
    static int ball = 0;

    public static void question() {
        System.out.println("숫자를 입력해주세요(3자리)");
    }
    public static boolean inputCheck(String input) throws Exception {
        reset();
        if(input.length()!=3){
            throw new Exception("3자리 수를 입력해야 합니다.");
        }

        int[] answer = makeAnswer();
        int[] inputSplit = split(input);
        result(inputSplit, answer);
        if (strike == 3) {
            return true;
        }

        printResult();

        return false;
    }

    private static void printResult() {
        if (strike == 0 && ball == 0) {
        System.out.println("낫싱 = ");
        }
        if (strike == 0) {
            System.out.println(ball+"볼");
        }
        if (ball == 0) {
            System.out.println(strike+"스트라이크");
        }
        System.out.println(strike+"스트라이크 "+ball+"볼");
    }

    public static void reset() {
        strike = 0;
        ball = 0;
    }

    public static void answer() {

    }

    public static int[] makeAnswer() {
        Set<Integer> set = new HashSet<>()  ;
        while (set.size() < 4) {
            set.add((int) (Math.random() * 8) + 1);
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }


    public static int[] split(String str) {
        String[] s = str.split(" ");
        int[] intSplit = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            intSplit[i] = Integer.parseInt(s[i]);
        }
        return intSplit;
    }

    public static boolean checkStrike(int[] intSplit, int index, int[] answer) {
        return answer[index] == intSplit[index];
    }

    public static boolean checkBall(int[] intSplit, int index, int[] answer) {
        return Arrays.stream(answer).anyMatch(n -> n == intSplit[index]);
    }

    public static int[] result(int[] intSplit, int[] answer) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            checkStrikeBall(intSplit, answer, i);
        }
        result[0]=strike;
        result[1]=ball;
        return result;
    }

    private static void checkStrikeBall(int[] intSplit, int[] answer, int i) {
        if (checkStrike(intSplit, i, answer) == true) {
            strike++;
        }
        if (checkBall(intSplit, i, answer) == true) {
            ball++;
        }
    }

}
