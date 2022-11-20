package bridge;

import java.util.Arrays;

public enum Direction {

    UP("U",1),
    DOWN("D",0);

    private final String word;
    private final int num;

    Direction(String word, int num) {
        this.word = word;
        this.num = num;
    }

    public static Direction of(int num) {
        return Arrays.stream(values()).filter(v -> v.num == num).findAny().orElseThrow(
            () -> new IllegalArgumentException("[ERROR] 올바르지 않은 숫자 입니다. num: " + num)
        );
    }

    public String getWord() {
        return word;
    }
}
