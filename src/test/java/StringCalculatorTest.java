import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator sc = new StringCalculator();

    @Test
    void splitNum() {
        //given
        String input = "22 + 33 * 44 / 55";
        //when
        int[] ints = sc.splitNum(input);
        //then
        assertThat(ints).containsExactly(22, 33, 44, 55);
    }

    @Test
    void splitString() {
        //given
        String input = "22 + 33 * 44 / 55";
        //when
        String[] strings = sc.splitString(input);
        //then
        assertThat(strings).containsExactly("+", "*", "/");
    }

    @Test
    void calculator() {
        //given
        String input = "22 + 33 * 44 / 55";
        //when
        int calculator = sc.calculator(input);
        //then
        assertThat(calculator).isEqualTo(44);
    }

}