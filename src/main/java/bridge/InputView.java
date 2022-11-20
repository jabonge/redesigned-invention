package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String input = Console.readLine();
        try {
            return InputValidator.validateBridgeSize(input);
        } catch (IllegalArgumentException ex) {
            OutputView.print(ex.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String input = Console.readLine();
        try {
            return InputValidator.validateMoving(input);
        } catch (IllegalArgumentException ex) {
            OutputView.print(ex.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String input = Console.readLine();
        try {
            return InputValidator.validateGameCommand(input);
        } catch (IllegalArgumentException ex) {
            OutputView.print(ex.getMessage());
            return readGameCommand();
        }
    }
}
