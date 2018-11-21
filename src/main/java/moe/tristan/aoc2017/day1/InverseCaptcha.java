package moe.tristan.aoc2017.day1;

import org.springframework.stereotype.Component;

import moe.tristan.aoc2017.AocChallenge;

@Component
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
    public Integer runPuzzle(final String input) {
        int sum = 0;

        final char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int prevIndex = i == 0 ? chars.length - 1 : i - 1;

            int prevVal = ((int) chars[prevIndex]) - (int) '0';
            int val = ((int) chars[i]) - (int) '0';
            if (val == prevVal) {
                sum += val;
            }
        }

        return sum;
    }

}
