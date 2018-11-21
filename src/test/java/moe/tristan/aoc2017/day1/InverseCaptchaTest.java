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
    public void step1_1122() {
        assertThat(inverseCaptcha.step1("1122")).isEqualTo(3);
    }

    @Test
    public void step1_1111() {
        assertThat(inverseCaptcha.step1("1111")).isEqualTo(4);
    }

    @Test
    public void step1_1234() {
        assertThat(inverseCaptcha.step1("1234")).isEqualTo(0);
    }

    @Test
    public void step1_91212129() {
        assertThat(inverseCaptcha.step1("91212129")).isEqualTo(9);
    }

    @Test
    public void step2_1212() {
        assertThat(inverseCaptcha.step2("1212")).isEqualTo(6);
    }

    @Test
    public void step2_1221() {
        assertThat(inverseCaptcha.step2("1221")).isEqualTo(0);
    }

    @Test
    public void step2_123425() {
        assertThat(inverseCaptcha.step2("123425")).isEqualTo(4);
    }

    @Test
    public void step2_123123() {
        assertThat(inverseCaptcha.step2("123123")).isEqualTo(12);
    }

    @Test
    public void step2_12131415() {
        assertThat(inverseCaptcha.step2("4")).isEqualTo(4);
    }

}
