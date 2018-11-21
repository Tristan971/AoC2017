package moe.tristan.aoc2017.day2;

import static moe.tristan.aoc2017.day2.CorruptionChecksum.readInput;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CorruptionChecksumTest {

    private final Set<Set<Integer>> inputStep1 = readInput("5 1 9 5\n"
                                                           + "7 5 3\n"
                                                           + "2 4 6 8");

    private final Set<Set<Integer>> inputStep2 = readInput("5 9 2 8\n"
                                                           + "9 4 7 3\n"
                                                           + "3 8 6 5");

    @Autowired
    private CorruptionChecksum corruptionChecksum;

    @Test
    public void maxMinusMin() {
        assertThat(CorruptionChecksum.maxMinusMin(Set.of(5, 1, 9))).isEqualTo(8);
        assertThat(CorruptionChecksum.maxMinusMin(Set.of(7, 5, 3))).isEqualTo(4);
        assertThat(CorruptionChecksum.maxMinusMin(Set.of(2, 4, 6, 8))).isEqualTo(6);
    }

    @Test
    public void step1() {
        assertThat(corruptionChecksum.step(inputStep1, CorruptionChecksum::maxMinusMin)).isEqualTo(18);
    }

    @Test
    public void maxDivMinEvenlyDivisible() {
        assertThat(CorruptionChecksum.maxDivMinEvenlyDivisible(Set.of(5, 9, 2, 8))).isEqualTo(4);
        assertThat(CorruptionChecksum.maxDivMinEvenlyDivisible(Set.of(9, 4, 7, 3))).isEqualTo(3);
        assertThat(CorruptionChecksum.maxDivMinEvenlyDivisible(Set.of(3, 8, 6, 5))).isEqualTo(2);
    }

    @Test
    public void step2() {
        assertThat(corruptionChecksum.step(inputStep2, CorruptionChecksum::maxDivMinEvenlyDivisible)).isEqualTo(9);
    }

}
