package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.Game;
import baseball.view.BaseballGameView;

public class GameManager {

    public static void main(String[] args) {
        BaseballGameView gameView = new BaseballGameView();
        int ballCount = 4;
        while (true) {
            Game game = new BaseballGame(gameView, ballCount);
            game.start();
            String continueGame = gameView.continueGame();

            if ("2".equals(continueGame)) {
                return;
            }
        }
    }

}
