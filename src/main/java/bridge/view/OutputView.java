package bridge.view;

import static bridge.constants.OutputConstants.CHOICE_UP_DOWN_MESSAGE;
import static bridge.constants.OutputConstants.Fail;
import static bridge.constants.OutputConstants.MAKE_BRIDGE_SIZE;
import static bridge.constants.OutputConstants.RESULT_MESSAGE;
import static bridge.constants.OutputConstants.SELECT_RESTART_OR_QUIT;
import static bridge.constants.OutputConstants.START_MESSAGE;
import static bridge.constants.OutputConstants.SUCCEES;
import static bridge.constants.OutputConstants.TOTAL_TRY;

import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private StringJoiner upSb;
    private StringJoiner downSb;

    public OutputView() {
        upSb = new StringJoiner("|", "[", "]");
        downSb = new StringJoiner("|", "[", "]");
    }

    public void printMap() {
        System.out.println(upSb.toString() + "\n" + downSb.toString() + "\n");
    }

    public void makeMap(String userMove, String check) {
        if (userMove.equals("U")) {
            upSb.add(" " + check + " ");
            downSb.add("   ");
        }
        if (userMove.equals("D")) {
            upSb.add("   ");
            downSb.add(" " + check + " ");
        }
    }

    public void clearMap() {
        upSb = new StringJoiner("|", "[", "]");
        downSb = new StringJoiner("|", "[", "]");
    }

    public String finalResult(boolean result) {
        if (result == true) {
            return SUCCEES.getMessage();
        }
        return Fail.getMessage();
    }

    public void printStartAndMake() {
        START_MESSAGE.printMessage();
        MAKE_BRIDGE_SIZE.printMessage();
    }

    public void printAskMoving() {
        CHOICE_UP_DOWN_MESSAGE.printMessage();
    }

    public void printAskRetry() {
        SELECT_RESTART_OR_QUIT.printMessage();
    }

    public void printResult(boolean userMove, int totalCnt) {
        RESULT_MESSAGE.printMessage();
        System.out.println(upSb.toString() + "\n" + downSb.toString() + "\n");
        System.out.println(finalResult(userMove) + TOTAL_TRY.getMessage() + totalCnt);

    }


}
