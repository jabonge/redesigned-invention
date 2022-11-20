package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("올바르지 않은 숫자입력시 에러를 던진다")
    void throwErrorIncorrectNumOfDirection() {
        assertThatThrownBy(() -> Direction.of(2)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 올바르지 않은 숫자");
    }

    @Test
    @DisplayName("올바른 숫자 입력")
    void correctNumOfDirection() {
        assertThat(Direction.of(0).getWord()).isEqualTo("U");
        assertThat(Direction.of(1).getWord()).isEqualTo("D");
    }

}