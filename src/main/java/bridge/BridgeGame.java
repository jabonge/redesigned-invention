package bridge;

import static bridge.BridgeGameReferee.*;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static String MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static String RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private int tryCount = 0;

    public void start() {
        OutputView.print(GAME_START);
        tryCount += 1;
        BridgeGameReferee referee = new BridgeGameReferee(new BridgeMaker(new BridgeRandomNumberGenerator()));
        // 이동
        do {
            String value = move();
            referee.addMove(value);
        } while (referee.getGameStatus() == GameStatus.PLAYING);
        // 이동 후 처리
        if(referee.getGameStatus() == GameStatus.FAIL) {
            if (retry()) {
                OutputView.printResult(referee,tryCount);
                return;
            }
            start();
            return;
        }
        OutputView.printResult(referee,tryCount);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private String move() {
        OutputView.print(MOVE);
        String value = InputView.readMoving();
        OutputView.print(value);
        return value;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry() {
        OutputView.print(RETRY);
        String value = InputView.readGameCommand();
        OutputView.print(value);
        return value.equals("R");
    }
}
