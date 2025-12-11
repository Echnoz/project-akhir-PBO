package src.tugofwar.result;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import src.tugofwar.question.QuizMode;
import src.tugofwar.ui.CLIView;
import src.tugofwar.ui.InputHandler;

public class LeaderboardService {

    private final ResultLogger resultLogger;

    public LeaderboardService(ResultLogger resultLogger) {
        this.resultLogger = resultLogger;
    }

    public void showLeaderboard(CLIView view, InputHandler input) {
        int choice = input.readInt("Leaderboard untuk: 1) Grammar  2) Vocabulary : ");
        QuizMode mode = (choice == 1) ? QuizMode.GRAMMAR : QuizMode.VOCAB;

        List<GameResult> all = resultLogger.loadAllResults();
        List<GameResult> filtered = all.stream()
                .filter(r -> r.getMode() == mode)
                .sorted(Comparator.comparingInt(GameResult::getScore).reversed())
                .limit(10)
                .collect(Collectors.toList());

        view.showLeaderboard(mode, filtered);
    }

    public void showHistoryForUser(String username, CLIView view) {
        List<GameResult> all = resultLogger.loadAllResults();
        List<GameResult> filtered = all.stream()
                .filter(r -> r.getUsername().equalsIgnoreCase(username))
                .sorted(Comparator.comparing(GameResult::getPlayedAt))
                .collect(Collectors.toList());

        view.showHistory(username, filtered);
    }
}
