package bridge;

import bridge.controller.*;
public class Application {

    public static void main(String[] args) {
        gameController controller = new gameController();
        controller.run();
    }
}
