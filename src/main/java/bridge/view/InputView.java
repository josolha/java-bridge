package bridge.view;

import static bridge.constants.ErrorConstants.RETRY_ERROR;
import static bridge.constants.ErrorConstants.SIZE_EXCEPTION;
import static bridge.constants.ErrorConstants.UPDOWN_ERROR;
import static bridge.validator.Validate.validateBridgeCheck;
import static bridge.validator.Validate.validateBridgeNumber;
import static bridge.validator.Validate.validateCheckMove;
import static bridge.validator.Validate.validateCheckRetry;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public int readBridgeSize() {
        String readBridgeSize = Console.readLine();
        try {
            validateBridgeCheck(readBridgeSize);
            validateBridgeNumber(readBridgeSize);
        } catch (IllegalArgumentException e) {
            SIZE_EXCEPTION.printException();
            return readBridgeSize();
        }
        return Integer.parseInt(readBridgeSize);
    }

    public String readMoving() {
        String userMove = Console.readLine();
        try {
            validateCheckMove(userMove);
        } catch (IllegalArgumentException e) {
            UPDOWN_ERROR.printException();
            return readMoving();
        }
        return userMove;
    }

    public String readGameCommand() {
        String command = Console.readLine();
        try {
            validateCheckRetry(command);
        } catch (IllegalArgumentException e) {
            RETRY_ERROR.printException();
            return readGameCommand();
        }
        return command;
    }
}
