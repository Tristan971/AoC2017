package moe.tristan.aoc2017.day2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import moe.tristan.aoc2017.AocChallenge;

@Component
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
        final String[] lines = input.split("\n");
        return Arrays.asList(
                step1(lines)
        );
    }

    int step1(final String[] lines) {
        int sum = 0;
        for (String line : lines) {
            sum += checksumLine(line);
        }
        return sum;
    }

    int checksumLine(final String lineValues) {
        final Set<Integer> numbers = Stream.of(lineValues.split("\t| +"))
                                           .map(String::trim)
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toSet());
        OptionalInt smallest = smallest(numbers);
        OptionalInt largest = largest(numbers);
        if (smallest.isPresent() && largest.isPresent()) {
            return largest.getAsInt() - smallest.getAsInt();
        }
        return 0;
    }

    private OptionalInt smallest(Collection<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).min();
    }

    private OptionalInt largest(Collection<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).max();
    }

}
