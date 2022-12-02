package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class gameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private int totalCnt = 1;
    private String userMove;

    public gameController() {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        init();
        play();
    }

    private void init() {
        outputView.printStartAndMake();
        bridgeGame.makeBridge(inputView.readBridgeSize());
    }

    private void play() {
        boolean playFlag;
        do {
            startMove();
            makeMap(userMove, bridgeGame.checkMove(userMove));
            outputView.printMap();
            playFlag = decideFlag();
        } while (playFlag);
    }

    private void startMove() {
        outputView.printAskMoving();
        userMove = inputView.readMoving();
        bridgeGame.move(userMove);
    }

    private boolean decideFlag() {
        boolean checkMove = bridgeGame.checkMove(userMove);
        boolean checkLast = bridgeGame.checkLast();
        if ((checkMove && checkLast) == false) {
            gameOver(checkMove);
        }
        return checkMove && checkLast;
    }

    private void makeMap(String userMove, boolean checkMove) {
        outputView.makeMap(userMove, changeOX(checkMove));
    }

    private String changeOX(boolean checkMove) {
        if (checkMove == true) {
            return "O";
        }
        return "X";
    }

    private void gameOver(boolean checkMove) {
        if (checkMove == false) {
            retryCheck();
        }
        if (checkMove == true) {
            result(bridgeGame.checkMove(userMove), totalCnt);
        }
    }

    private void retryCheck() {
        outputView.printAskRetry();
        boolean askRetry = bridgeGame.retry(inputView.readGameCommand());
        if (askRetry == true) {
            totalCnt++;
            reset();
            play();
        }
        if (askRetry == false) {
            result(bridgeGame.checkMove(userMove), totalCnt);
        }
    }

    private void result(boolean userMove, int totalCnt) {
        outputView.printResult(userMove, totalCnt);
    }

    private void reset() {
        outputView.clearMap();
        bridgeGame.index = -1;
    }

}

