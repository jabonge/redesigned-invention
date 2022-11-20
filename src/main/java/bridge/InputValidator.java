package bridge;

public class InputValidator {

    private static int MIN_BRIDGE_SIZE = 3;
    private static int MAX_BRIDGE_SIZE = 20;


    public static int validateBridgeSize(String input) {
        try {
            int size = Integer.parseInt(input);
            if(size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
            return size;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static String validateMoving(String input) {
        if(input.equals(Direction.UP.getWord()) || input.equals(Direction.DOWN.getWord())) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] 올바른 문자를 입력해주세요.");
    }

    public static String validateGameCommand(String input) {
        if(input.equals("R") || input.equals("Q")) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] 올바른 문자를 입력해주세요.");
    }
}
