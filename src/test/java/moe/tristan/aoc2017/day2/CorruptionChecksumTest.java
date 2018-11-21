package moe.tristan.aoc2017.day2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CorruptionChecksumTest {

    private final String[] input = new String[]{
            "5  1   9   5",
            "7  5   3",
            "2  4   6   8"
    };

    @Autowired
    private CorruptionChecksum corruptionChecksum;

    @Test
    public void checksumLine() {
        assertThat(corruptionChecksum.checksumLine(input[0])).isEqualTo(8);
        assertThat(corruptionChecksum.checksumLine(input[1])).isEqualTo(4);
        assertThat(corruptionChecksum.checksumLine(input[2])).isEqualTo(6);
    }

    @Test
    public void step1() {
        assertThat(corruptionChecksum.step1(input)).isEqualTo(18);
    }

}
