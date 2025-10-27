package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("car1,car2", "1");
                assertThat(output()).contains("최종 우승자");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 여러_라운드_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi", "3");
                assertThat(output()).contains("실행 결과");
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 빈_자동차_이름_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_0_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_시도_횟수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_시도_횟수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_입력_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5자_초과_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("abcdef", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세_대_자동차_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("car1,car2,car3", "1");
                assertThat(output()).contains("car1", "car2", "car3");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
