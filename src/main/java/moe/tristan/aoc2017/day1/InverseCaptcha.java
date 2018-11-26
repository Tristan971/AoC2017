package moe.tristan.aoc2017.day1;

import java.util.Arrays;
import java.util.List;

import moe.tristan.aoc2017.AocChallenge;

public class InverseCaptcha implements AocChallenge<Integer> {

    @Override
    public String inputFileLocation() {
        return "1/input";
    }

    @Override
    public int challengeNumber() {
        return 1;
    }

    @Override
    public List<Integer> puzzles(final String input) {
        return Arrays.asList(
                step1(input),
                step2(input)
        );
    }

    Integer step1(final String input) {
        return stepN(input, 1);
    }

    Integer step2(final String input) {
        return stepN(input, input.length() / 2);
    }

    private Integer stepN(final String input, final int n) {
        int sum = 0;

        final char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int val = charToInt(chars[i]);
            int nextVal = charToInt(chars[(i + n) % chars.length]);
            if (nextVal == val) {
                sum += val;
            }
        }

        return sum;
    }

    private int charToInt(char c) {
        return (int) c - (int) '0';
    }

}
