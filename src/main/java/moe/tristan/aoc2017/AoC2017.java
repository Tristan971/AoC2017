package moe.tristan.aoc2017;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AoC2017 {

    private static final Logger LOGGER = LoggerFactory.getLogger(AoC2017.class);

    private final List<AocChallenge> aocChallenges;

    public AoC2017(List<AocChallenge> aocChallenges) {
        this.aocChallenges = aocChallenges;
    }

    public static void main(String[] args) {
        SpringApplication.run(AoC2017.class, args).getBean(AoC2017.class);
    }

    @PostConstruct
    public void runAllChallenges() {
        aocChallenges.forEach(challenge -> {
            LOGGER.info(
                    "Running challenge {}/25 : {}",
                    challenge.challengeNumber(),
                    challenge.getClass().getSimpleName()
            );
            try {
                final InputStream inputFileStream = getClass().getClassLoader().getResourceAsStream(challenge.inputFileLocation());
                final String input = new String(Objects.requireNonNull(inputFileStream, "Cannot read input data.").readAllBytes());
                LOGGER.info("Result : {}", challenge.runPuzzle(input));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
