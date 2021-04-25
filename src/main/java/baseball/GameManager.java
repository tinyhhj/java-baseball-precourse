package baseball;

import baseball.domain.BaseballGame;
import baseball.view.BaseballGameView;

public class GameManager {

    public static void main(String[] args) {
        BaseballGameView gameView = new BaseballGameView();
        int ballCount = 4;
        while (true) {
            BaseballGame game = new BaseballGame(gameView, ballCount);
            game.start();
            String continueGame = gameView.continueGame();

            if (continueGame.equals("2")) {
                return;
            }
        }
    }

}
