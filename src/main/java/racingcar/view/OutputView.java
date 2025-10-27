package racingcar.view;

import racingcar.constants.Message;

import java.util.List;

public class OutputView {
    public void printCarNamesPrompt() {
        System.out.println(Message.CAR_NAMES_PROMPT);
    }

    public void printTryCountPrompt() {
        System.out.println(Message.TRY_COUNT_PROMPT);
    }

    public void printExecutionResult() {
        System.out.println();
        System.out.println(Message.EXECUTION_RESULT);
    }

    public void printRoundResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerString = String.join(", ", winners);
        System.out.println(Message.WINNER_PREFIX + winnerString);
    }
}

