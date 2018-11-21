package moe.tristan.aoc2017;

import java.util.List;

public interface AocChallenge<T> {

    String inputFileLocation();

    int challengeNumber();

    List<T> puzzles(final String input);

}
