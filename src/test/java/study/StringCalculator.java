package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculator {
    @Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int length = split.length;
        int[] numArr = new int[(length / 2)+1];
        String[] strArr = new String[length / 2];

        for (int i = 0; i <length ; i++) {
            if (i % 2 == 0) {
                numArr[i/2]=Integer.parseInt(split[i]);
            }
            if(i%2==1){
                strArr[i / 2] = split[i];
            }
        }
        int sum = numArr[0];
        for (int i = 0; i < length / 2; i++) {
            if (strArr[i].equals("+")) {
                sum = sum + numArr[i + 1];
                System.out.println("sum = " + sum);
            }
            if (strArr[i].equals("-")) {
                sum = sum - numArr[i + 1];
                System.out.println("sum = " + sum);
            }
            if (strArr[i].equals("*")) {
                sum = sum * numArr[i + 1];
                System.out.println("sum = " + sum);
            }
            if (strArr[i].equals("/")) {
                sum = sum / numArr[i + 1];
                System.out.println("sum = " + sum);
            }
        }
        Assertions.assertEquals(sum, 10);
    }
}
