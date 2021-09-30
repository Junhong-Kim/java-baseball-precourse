package baseball;

import baseball.view.BaseballGame;
import baseball.view.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new BaseballGame();
        game.start();
    }
}
