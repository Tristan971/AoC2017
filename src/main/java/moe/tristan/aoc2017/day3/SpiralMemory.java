package moe.tristan.aoc2017.day3;

import static java.lang.Integer.parseInt;

import java.util.Collections;
import java.util.List;

import moe.tristan.aoc2017.AocChallenge;

public class SpiralMemory implements AocChallenge<Integer> {

    @Override
    public String inputFileLocation() {
        return "3/input";
    }

    @Override
    public int challengeNumber() {
        return 3;
    }

    @Override
    public List<Integer> puzzles(String input) {
        return List.of(step1(parseInt(input)));
    }

    int step1(int input) {
        final int ringNumber = ringNumberFor(input);
        return ringNumber + offsetInRing(input, ringNumber);
    }

    int ringNumberFor(int value) {
        int maxCurRing = 1;
        int ringNumber = 0;
        while (maxCurRing < value) {
            maxCurRing += 8 * (ringNumber + 1);
            ringNumber++;
        }

        return ringNumber;
    }

    int offsetInRing(int value, int ringNumber) {
        if (value == 1) {
            return 0;
        }

        final int lenRing = lenRing(ringNumber);
        final int minValRing = minValRing(ringNumber);

        // right middle distance from ring min value (bottom right)
        final int middleOffsetBase = ringNumber - 1;
        final int middleOffset = lenRing / 4;

        final int distanceFromMin = value - minValRing;
        return (distanceFromMin - middleOffsetBase) % middleOffset;
    }

    int lenRing(int n) {
        return 8 * n;
    }

    /**
     * https://www.wolframalpha.com/input/?i=a(n)%3Da(n-1)%2B8*n+with+a(0)%3D1
     */
    int minValRing(int n) {
        if (n == 0) {
            return 1;
        }
        return (int) Math.pow((2 * (n - 1) + 1), 2) + 1;
    }

}
