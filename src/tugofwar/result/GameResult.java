package tugofwar.result;

import java.time.LocalDateTime;

import tugofwar.question.QuizMode;

public class GameResult {

    private final String username;
    private final QuizMode mode;
    private final int score;
    private final String status; // WIN / DRAW / LOSE
    private final LocalDateTime playedAt;

    public GameResult(String username,
                      QuizMode mode,
                      int score,
                      String status,
                      LocalDateTime playedAt) {
        this.username = username;
        this.mode = mode;
        this.score = score;
        this.status = status;
        this.playedAt = playedAt;
    }

    public String getUsername() {
        return username;
    }

    public QuizMode getMode() {
        return mode;
    }

    public int getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public String toCsvLine() {
        return username + ";" + mode + ";" + score + ";" + status + ";" + playedAt;
    }

    public static GameResult fromCsvLine(String line) {
        // username;mode;score;status;timestamp
        String[] parts = line.split(";");
        if (parts.length < 5) return null;
        String username = parts[0].trim();
        QuizMode mode = QuizMode.valueOf(parts[1].trim());
        int score = Integer.parseInt(parts[2].trim());
        String status = parts[3].trim();
        LocalDateTime time = LocalDateTime.parse(parts[4].trim());
        return new GameResult(username, mode, score, status, time);
    }
}
