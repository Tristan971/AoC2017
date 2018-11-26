package moe.tristan.aoc2017.day2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import moe.tristan.aoc2017.AocChallenge;

public class CorruptionChecksum implements AocChallenge<Integer> {

    @Override
    public String inputFileLocation() {
        return "2/input";
    }

    @Override
    public int challengeNumber() {
        return 2;
    }

    @Override
    public List<Integer> puzzles(String input) {
        final Set<Set<Integer>> lines = readInput(input);
        return Arrays.asList(
                step(lines, CorruptionChecksum::maxMinusMin),
                step(lines, CorruptionChecksum::maxDivMinEvenlyDivisible)
        );
    }

    int step(final Set<Set<Integer>> lines, final Function<Set<Integer>, Integer> lineChecksum) {
        return lines.stream().map(lineChecksum).reduce(0, Math::addExact);
    }

    static int maxMinusMin(final Set<Integer> numbers) {
        OptionalInt smallest = smallest(numbers);
        OptionalInt largest = largest(numbers);
        if (smallest.isPresent() && largest.isPresent()) {
            return largest.getAsInt() - smallest.getAsInt();
        }
        return 0;
    }

    static int maxDivMinEvenlyDivisible(final Set<Integer> numbers) {
        for (Integer x : numbers) {
            for (Integer y : numbers) {
                if (y.equals(x)) {
                    continue;
                }
                int min = Math.min(x, y);
                int max = Math.max(x, y);
                if (max % min == 0) {
                    return max / min;
                }
            }
        }
        return 0;
    }

    static Set<Set<Integer>> readInput(final String input) {
        return Arrays.stream(input.split("\n|[\r\n]"))
                     .map(line -> line.split("\t| +"))
                     .map(lineVals -> Arrays.stream(lineVals)
                                            .filter(val -> !val.isBlank())
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toSet()))
                     .collect(Collectors.toSet());
    }

    private static OptionalInt smallest(Collection<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).min();
    }

    private static OptionalInt largest(Collection<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).max();
    }

}
