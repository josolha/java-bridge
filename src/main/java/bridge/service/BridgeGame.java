package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 (서비스 뷰는 관여 하지 않는다)
 */
public class BridgeGame {

    private List<String> makeBridge;
    private final BridgeMaker bridgeMaker;
    public int index = -1;

    public BridgeGame() {
        makeBridge = new ArrayList<>();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void makeBridge(int bridgeSize) {
        makeBridge = bridgeMaker.makeBridge(bridgeSize);
//        System.out.println(makeBridge);
    }

    public void move(String userMove) {
        index++;
        checkMove(userMove);
    }

    public boolean checkMove(String userMove) {
        if (userMove.equals(makeBridge.get(index))) {
            return true;
        }
        return false;
    }

    public boolean checkLast() {
        if (index == makeBridge.size() - 1) {
            return false;
        }
        return true;
    }

    public boolean retry(String result) {
        if (result.equals("R")) {
            return true;
        }
        return false;
    }
}
