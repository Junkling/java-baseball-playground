import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class BaseballGame {

    static int strike = 0;
    static int ball = 0;

    public static void main(String[] args) throws IOException {
        int[] answer = makeAnswer();
        matching(answer);
        boolean roof = roof();

        while (roof != true) {
            reset();
            matching(answer);
            break;
        }

    }

    public static void matching(int[] answer) throws IOException {
        question();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        checkInput(input);
        int[] splitInput = split(input);
        System.out.println(printResult(ballStrike(splitInput, answer)));
    }

    public static void question() {
        System.out.println("숫자를 입력해주세요(3자리)");
    }
    public static boolean roof() {
        if (strike == 3) {
            System.out.println("정답입니다.");
            return true;
        }
        return false;
    }

    public static void checkInput(String input) throws IOException {
        if(input.length()!=3){
            throw new IOException("3자리 수를 입력해야 합니다.(공백 미포함)");
        }
        HashSet<Integer> set = new HashSet<>();
        int[] split = split(input);
        for (int i : split) {
            set.add(i);
        }
        if (set.size() != input.length()) {
            throw new IOException("중복되지 않은 3 숫자를 입력하셔야 합니다.");
        }
    }

    public static String printResult(int[] ballStrike) {
        int ballResult = ballStrike[0];
        int strikeResult = ballStrike[1];

        if (strikeResult == 0 && ballResult == 0) {
            return "낫싱";
        }
        if (strikeResult == 0) {
            return ball + "볼";
        }
        if (ballResult == 0) {
            return strikeResult + "스트라이크";
        }
        return ballResult + "볼 " + strikeResult + "스트라이크";
    }

    public static void reset() {
        strike = 0;
        ball = 0;
    }

    public static void answer() {

    }

    public static int[] makeAnswer() {
        Set<Integer> set = new HashSet<>()  ;
        while (set.size() < 3) {
            set.add((int) (Math.random() * 8) + 1);
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }


    public static int[] split(String str) {
        String[] s = str.split("");
        int[] intSplit = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            intSplit[i] = Integer.parseInt(s[i]);
        }
        return intSplit;
    }

    public static boolean checkStrike(int[] intSplit, int index, int[] answer) {
        return answer[index] == intSplit[index];
    }

    public static boolean checkExist(int[] intSplit, int index, int[] answer) {
        return Arrays.stream(answer).anyMatch(n -> n == intSplit[index]);
    }

    public static int[] ballStrike(int[] intSplit, int[] answer) {
        int[] ballStrike = new int[2];
        for (int i = 0; i < 3; i++) {
            checkStrikeBall(intSplit, answer, i);
        }
        ballStrike[0]=ball;
        ballStrike[1]=strike;
        return ballStrike;
    }

    public static void checkStrikeBall(int[] intSplit, int[] answer, int i) {
        if (checkStrike(intSplit, i, answer) == true) {
            strike++;
        }
        if (checkExist(intSplit, i, answer) == true&&checkStrike(intSplit, i, answer) == false) {
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
