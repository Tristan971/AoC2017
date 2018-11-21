package moe.tristan.aoc2017;

public interface AocChallenge<T> {

    String inputFileLocation();

    int challengeNumber();

    T runPuzzle(final String input);

}
