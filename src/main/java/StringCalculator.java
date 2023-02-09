import java.util.Scanner;

public class StringCalculator {

    //문자열에서 숫자 뽑아내기
    public static int[] splitNum(String str) {
        String[] split = str.split(" ");
        int[] result = new int[(split.length / 2) + 1];
        for (int i = 0; i < split.length; i = i + 2) {
            result[i / 2] = Integer.parseInt(split[i]);
        }
        return result;
    }

    //문자열에서 연산 기호 뽑아내기
    public static String[] splitString(String str) {
        String[] split = str.split(" ");
        String[] result = new String[split.length / 2];
        for (int i = 1; i < split.length; i = i + 2) {
            result[i / 2] = split[i];
        }
        return result;
    }

    //순서대로 연산하기
    public static int calculator(String str) {
        int[] splitNum = splitNum(str);
        String[] splitString = splitString(str);
        int sum = splitNum[0];
        for (int i = 0; i < splitString.length; i++) {
            switch (splitString[i]) {
                case "+":
                    sum = sum + splitNum[i + 1];
                    break;
                case "-":
                    sum = sum - splitNum[i + 1];
                    break;
                case "*":
                    sum = sum * splitNum[i + 1];
                    break;
                case "/":
                    sum = sum / splitNum[i + 1];
                    break;

            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String split = scanner.nextLine();

        int calculator = calculator(split);

        System.out.println("calculator = " + calculator);
    }

}
