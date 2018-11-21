package moe.tristan.aoc2017.day1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InverseCaptchaTest {

    @Autowired
    private InverseCaptcha inverseCaptcha;

    @Test
    public void test1122() {
        assertThat(inverseCaptcha.runPuzzle("1122")).isEqualTo(3);
    }

    @Test
    public void test1111() {
        assertThat(inverseCaptcha.runPuzzle("1111")).isEqualTo(4);
    }

    @Test
    public void test1234() {
        assertThat(inverseCaptcha.runPuzzle("1234")).isEqualTo(0);
    }

    @Test
    public void test91212129() {
        assertThat(inverseCaptcha.runPuzzle("91212129")).isEqualTo(9);
    }

}
