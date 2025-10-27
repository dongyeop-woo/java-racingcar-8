package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.RacingConstants;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private final Cars cars;
    private final int tryCount;

    public RacingGameService(List<String> carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    private Cars createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return new Cars(carList);
    }

    public void raceRound() {
        for (int i = 0; i < cars.size(); i++) {
            raceSingleCar(i);
        }
    }

    private void raceSingleCar(int index) {
        int randomValue = getRandomValue();
        Car car = cars.get(index);
        moveCarIfNeeded(car, randomValue);
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(
            RacingConstants.MIN_RANDOM_VALUE, 
            RacingConstants.MAX_RANDOM_VALUE
        );
    }

    private void moveCarIfNeeded(Car car, int randomValue) {
        if (shouldMove(randomValue)) {
            car.increasePosition();
        }
    }

    private boolean shouldMove(int randomValue) {
        return randomValue >= RacingConstants.MIN_MOVE_THRESHOLD;
    }

    public List<String> getCurrentResults() {
        List<String> results = new ArrayList<>();
        List<Car> carList = cars.getCars();
        
        for (Car car : carList) {
            String result = formatCarResult(car);
            results.add(result);
        }
        return results;
    }

    private String formatCarResult(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        appendPositionMark(sb, car.getPosition());
        return sb.toString();
    }

    private void appendPositionMark(StringBuilder sb, int position) {
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        addWinnersToList(winners, maxPosition);
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            maxPosition = updateMaxPosition(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private int updateMaxPosition(int currentMax, int position) {
        if (position > currentMax) {
            return position;
        }
        return currentMax;
    }

    private void addWinnersToList(List<String> winners, int maxPosition) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            if (isWinner(car, maxPosition)) {
                winners.add(car.getName());
            }
        }
    }

    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }


    public int getTryCount() {
        return tryCount;
    }
}

