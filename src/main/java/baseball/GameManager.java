package baseball;

import baseball.constant.GameStatus;
import baseball.domain.BaseballGame;
import baseball.domain.Game;
import baseball.view.BaseballGameView;

public class GameManager {
	public static final String EXIT_GAME = String.valueOf(GameStatus.EXIT.ordinal());

	public static void main(String[] args) {
		BaseballGameView gameView = new BaseballGameView();
		do {
			Game game = new BaseballGame(gameView);
			game.start();
		} while (isContinue(gameView));
	}

	private static boolean isContinue(BaseballGameView gameView) {
		return !EXIT_GAME.equals(gameView.continueGame());
	}
}
