package racingcar.controller;

import racingcar.parser.InputParser;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputParser inputParser;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputParser = new InputParser();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        RacingGameService racingGameService = initializeGame();
        executeRacing(racingGameService);
    }

    private RacingGameService initializeGame() {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();
        return new RacingGameService(carNames, tryCount);
    }

    private List<String> getCarNames() {
        outputView.printCarNamesPrompt();
        String input = inputView.readCarNames();
        inputParser.validateCarNames(input);
        return inputParser.parseCarNames(input);
    }

    private int getTryCount() {
        outputView.printTryCountPrompt();
        String input = inputView.readTryCount();
        inputParser.validateTryCount(input);
        return inputParser.parseTryCount(input);
    }

    private void executeRacing(RacingGameService racingGameService) {
        outputView.printExecutionResult();
        raceMultipleRounds(racingGameService);
        printFinalWinners(racingGameService);
    }

    private void raceMultipleRounds(RacingGameService racingGameService) {
        for (int i = 0; i < racingGameService.getTryCount(); i++) {
            racingGameService.raceRound();
            printRoundResult(racingGameService);
        }
    }

    private void printRoundResult(RacingGameService racingGameService) {
        List<String> results = racingGameService.getCurrentResults();
        outputView.printRoundResults(results);
    }

    private void printFinalWinners(RacingGameService racingGameService) {
        List<String> winners = racingGameService.getWinners();
        outputView.printWinners(winners);
    }
}

