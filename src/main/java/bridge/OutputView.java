package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void print(String value) {
        System.out.println(value);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGameReferee referee) {
        StringBuilder firstLine = new StringBuilder("[");
        StringBuilder secondLine = new StringBuilder("[");
        List<String> moves = referee.getMoves();
        for(int i = 0; i < moves.size(); i++) {
            StringBuilder moveLine = moves.get(i).equals(Direction.UP.getWord()) ? firstLine : secondLine;
            StringBuilder otherLine = moveLine == firstLine ? secondLine : firstLine;
            if(referee.correct(i)) {
                moveLine.append(" O |");
                otherLine.append("   |");
                continue;
            }
            moveLine.append("   |");
            otherLine.append(" X |");
            break;
        }
        System.out.println(firstLine.substring(0,firstLine.length()-1) + "]");
        System.out.println(secondLine.substring(0,secondLine.length()-1) + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGameReferee referee, int tryCount) {
        System.out.println("최종 게임 결과");
        OutputView.printMap(referee);
        System.out.println("게임 성공 여부: " + referee.getGameStatus().getName());
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
