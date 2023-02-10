import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();


    @Test
    void makeAnswer() {

        //when

        //given
        int[] answer = baseballGame.makeAnswer();
        //then
        assertTrue(answer.length == 3);
    }

    @Test
    void split() {
        //when

        //given
        int[] split = baseballGame.split("792");
        int[] expect = {7, 9, 2};
        //then
        assertArrayEquals(expect,split);
    }


    @Test
    void checkInput() throws Exception {
        //when
        String outOfRange = "1234";
        String duplication = "223";
        //given
        //then
        assertThatThrownBy(() -> baseballGame.checkInput(outOfRange)).isInstanceOf(IOException.class).hasMessageContaining("3자리");
        assertThatThrownBy(() -> baseballGame.checkInput(duplication)).isInstanceOf(IOException.class).hasMessageContaining("중복");
    }

    @AfterEach
    @Test
    void reset() {
        baseballGame.reset();
        int strike = baseballGame.getStrike();
        int ball = baseballGame.getBall();
        assertThat(strike).isEqualTo(0);
        assertThat(ball).isEqualTo(0);
    }


    @Test
    void checkStrike() {
        //when
        int[] input1 = {1,2,3};
        int[] answer1 = {1,5,3};
        //given
        boolean b1 = baseballGame.checkStrike(input1, 0, answer1);
        boolean b2 = baseballGame.checkStrike(input1, 1, answer1);
        boolean b3 = baseballGame.checkStrike(input1, 2, answer1);
        //then
        assertThat(b1).isTrue();
        assertThat(b2).isFalse();
        assertThat(b3).isTrue();

    }

    @Test
    void checkExist() {
        //when
        int[] input1 = {1,2,3};
        int[] input2 = {3,2,1};
        int[] answer = {1,5,3};
        //given
        boolean b1 = baseballGame.checkExist(input1, 0, answer);
        boolean b2 = baseballGame.checkExist(input2, 0, answer);
        boolean b3 = baseballGame.checkExist(input1, 1, answer);
        //then
        assertThat(b1).isTrue();
        assertThat(b2).isTrue();
        assertThat(b3).isFalse();

    }


    @Test
    void checkStrikeBall() {
        //given
        int[] input = {1,3,5};
        int[] answer = {1,5,3};
        //when
        baseballGame.checkStrikeBall(input, answer, 0);
        baseballGame.checkStrikeBall(input, answer, 1);
        baseballGame.checkStrikeBall(input, answer, 2);

        //then
        assertThat(baseballGame.getBall()).isEqualTo(2);
        assertThat(baseballGame.getStrike()).isEqualTo(1);
    }
    @Test
    void ballStrike() {
        //when
        int[] input = {1,3,5};
        int[] answer = {1, 5, 3};

        //given
        int[] ints = baseballGame.ballStrike(input, answer);

        //then
        assertThat(ints).containsExactly(2, 1);

    }


    @Test
    void printResult() {
        //when
        int[] input = {1,3,5};
        int[] answer = {1, 5, 3};
        //given
        String s = baseballGame.printResult(baseballGame.ballStrike(input, answer));

        //then
        assertThat(s).isEqualTo("2볼 1스트라이크");
    }
}
