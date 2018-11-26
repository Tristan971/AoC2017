package moe.tristan.aoc2017.day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpiralMemoryTest {

    @Autowired
    private SpiralMemory spiralMemory;

    @Test
    public void ringNumberFor() {
        assertThat(spiralMemory.ringNumberFor(1)).isEqualTo(0);
        IntStream.range(2, 10).forEach(value -> assertThat(spiralMemory.ringNumberFor(value)).isEqualTo(1));
        IntStream.range(10, 26).forEach(value -> assertThat(spiralMemory.ringNumberFor(value)).isEqualTo(2));
        IntStream.range(26, 26 + 8 * 3).forEach(value -> assertThat(spiralMemory.ringNumberFor(value)).isEqualTo(3));
    }

    @Test
    public void lenRingN() {
        assertThat(spiralMemory.lenRing(0)).isEqualTo(0);
        assertThat(spiralMemory.lenRing(1)).isEqualTo(8);
        assertThat(spiralMemory.lenRing(2)).isEqualTo(16);
    }

    @Test
    public void minValRingN() {
        assertThat(spiralMemory.minValRing(0)).isEqualTo(1);
        assertThat(spiralMemory.minValRing(1)).isEqualTo(2);
        assertThat(spiralMemory.minValRing(2)).isEqualTo(10);
    }

    @Test
    public void offsetRing() {
        assertThat(spiralMemory.offsetInRing(1, 0)).isEqualTo(0);
        assertThat(spiralMemory.offsetInRing(8, 1)).isEqualTo(0);
        assertThat(spiralMemory.offsetInRing(9, 1)).isEqualTo(1);
        assertThat(spiralMemory.offsetInRing(21, 2)).isEqualTo(2);
    }

    @Test
    public void step1() {
        assertThat(spiralMemory.step1(1)).isEqualTo(0);
        assertThat(spiralMemory.step1(12)).isEqualTo(3);
        assertThat(spiralMemory.step1(23)).isEqualTo(2);
        assertThat(spiralMemory.step1(1024)).isEqualTo(31);
    }

}
