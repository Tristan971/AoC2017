package moe.tristan.aoc2017;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @Filter(type = ASSIGNABLE_TYPE, classes = AocChallenge.class))
public class AoC2017 {

    private static final Logger LOGGER = LoggerFactory.getLogger(AoC2017.class);

    private final List<AocChallenge> aocChallenges;

    public AoC2017(List<AocChallenge> aocChallenges) {
        this.aocChallenges = aocChallenges;
    }

    public static void main(String[] args) {
        SpringApplication.run(AoC2017.class, args).getBean(AoC2017.class).runAllChallenges();
    }

    public void runAllChallenges() {
        aocChallenges.forEach(challenge -> {
            LOGGER.info(
                    "[{}/25] {}",
                    challenge.challengeNumber(),
                    challenge.getClass().getSimpleName()
            );
            try {
                final InputStream inputFileStream = getClass().getClassLoader().getResourceAsStream(challenge.inputFileLocation());
                final String input = new String(Objects.requireNonNull(inputFileStream, "Cannot read input data.").readAllBytes());
                final List<?> results = challenge.puzzles(input);
                IntStream.range(0, results.size()).forEach(stepNumber -> LOGGER.info(
                        "\t- Part {}/{} : {}",
                        stepNumber + 1,
                        results.size(),
                        results.get(stepNumber)
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
