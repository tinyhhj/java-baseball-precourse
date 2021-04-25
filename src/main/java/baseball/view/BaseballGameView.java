package baseball.view;

import java.io.PrintStream;
import java.util.Scanner;

import baseball.constant.MatchResult;
import baseball.constant.MessageContainer;
import baseball.domain.BaseballNumber;
import baseball.domain.CustomBaseballNumber;
import baseball.domain.GuessResult;
import baseball.util.BaseballMatcher;

public class BaseballGameView {
	private Scanner inputReader;
	private PrintStream outputWriter;

	public BaseballGameView() {
		this(new Scanner(System.in), System.out);
	}

	public BaseballGameView(Scanner inputReader, PrintStream outputWriter) {
		this.inputReader = inputReader;
		this.outputWriter = outputWriter;
	}

	public String readInput() {
		outputWriter.print(MessageContainer.INPUT_MESSAGE);
		return inputReader.nextLine().trim();
	}

	public String continueGame() {
		outputWriter.println(MessageContainer.CONTINUE_GAME_MESSAGE);
		return inputReader.nextLine().trim();
	}

	public void println(String message) {
		outputWriter.println(message);
	}

	public void showGuessResult(GuessResult guessResult) {
		if (guessResult.isNothing()) {
			outputWriter.println(MatchResult.NOTHING.getResultMessage());
			return;
		}
		if (guessResult.getStrikes() > 0 && guessResult.getBalls() > 0) {
			outputWriter.println(String.format("%d %s %d %s",
				guessResult.getStrikes(), MatchResult.STRIKE.getResultMessage(),
				guessResult.getBalls(), MatchResult.BALL.getResultMessage()));
		} else if (guessResult.getStrikes() > 0) {
			outputWriter.println(String.format("%d %s",
				guessResult.getStrikes(), MatchResult.STRIKE.getResultMessage()));
		} else if (guessResult.getBalls() > 0) {
			outputWriter.println(String.format("%d %s",
				guessResult.getBalls(), MatchResult.BALL.getResultMessage()));
		}
	}

	public static void main(String[] args) {
		BaseballGameView view = new BaseballGameView();

		while (true) {
			BaseballNumber target = new BaseballNumber(3);
			view.outputWriter.println(target.getNumbers());
			while (true) {
				BaseballMatcher matcher = new BaseballMatcher(target);
				BaseballNumber guess = new CustomBaseballNumber(view.readInput(), 3);
				MatchResult[] results = matcher.match(guess);
				view.showGuessResult(new GuessResult(results));
			}

		}
	}

}
