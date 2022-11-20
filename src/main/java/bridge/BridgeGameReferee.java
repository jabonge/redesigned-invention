package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameReferee {

    private static String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    private final BridgeMaker bridgeMaker;
    private final List<String> bridge;
    private final List<String> moves;

    public BridgeGameReferee(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = makeBridge();
        this.moves = new ArrayList<>();
    }

    private List<String> makeBridge() {
        OutputView.print(BRIDGE_SIZE);
        int size = InputView.readBridgeSize();
        OutputView.print(String.valueOf(size));
        return bridgeMaker.makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMoves() {
        return moves;
    }

    public boolean correct(int stage) {
        return bridge.get(stage).equals(moves.get(stage));
    }

    public GameStatus getGameStatus() {
        for (int i = 0; i < moves.size(); i++) {
            if(correct(i)) {
                continue;
            }
            return GameStatus.FAIL;
        }
        if(bridge.size() != moves.size()) {
            return GameStatus.PLAYING;
        }
        return GameStatus.SUCCESS;
    }

    public void addMove(String value) {
        moves.add(value);
        OutputView.printMap(this);
    }

    public enum GameStatus {
        SUCCESS("성공"),
        FAIL("실패"),
        PLAYING("진행중");

        private final String name;

        GameStatus(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
