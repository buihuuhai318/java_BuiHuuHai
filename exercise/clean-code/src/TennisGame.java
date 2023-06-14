public class TennisGame {
    public static final int MIN_OF_SCORE = 3;
    public static final int LIMIT_SCORE_TO_WIN = 2;
    public static final int SCORE_FOR_WIN_TURN = 1;
    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        String scoreResult = "";
        int tempScore = 0;
        if (playerScore1 == playerScore2) {
            scoreResult = showReadScore(scoreResult, playerScore1, true);
        } else if (playerScore1 > MIN_OF_SCORE || playerScore2 > MIN_OF_SCORE) {
            scoreResult = showResultWin(playerScore1, playerScore2, scoreResult);
        } else {
            scoreResult = showTempScore(scoreResult, tempScore, playerScore1, playerScore2);
        }
        return scoreResult;
    }

    public static String showReadScore(String scoreResult, int tempScore, boolean deuce) {
        if (deuce) {
            switch (tempScore) {
                case 0 -> scoreResult = "Love-All";
                case 1 -> scoreResult = "Fifteen-All";
                case 2 -> scoreResult = "Thirty-All";
                case 3 -> scoreResult = "Forty-All";
                default -> scoreResult = "Deuce";
            }
        } else {
            switch (tempScore) {
                case 0 -> scoreResult = "Love";
                case 1 -> scoreResult = "Fifteen";
                case 2 -> scoreResult = "Thirty";
                case 3 -> scoreResult = "Forty";
            }
        }
        return scoreResult;
    }
    public static String showTempScore(String scoreResult, int tempScore, int playerScore1, int playerScore2) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerScore1;
            else {
                scoreResult += "-";
                tempScore = playerScore2;
            }
            scoreResult += showReadScore(scoreResult, tempScore, false);
        }
        return scoreResult;
    }
    public static String showResultWin(int playerScore1, int playerScore2, String scoreResult) {
        int minusResult = playerScore1 - playerScore2;
        if (minusResult == SCORE_FOR_WIN_TURN) scoreResult = "Advantage player1";
        else if (minusResult == -SCORE_FOR_WIN_TURN) scoreResult = "Advantage player2";
        else if (minusResult >= LIMIT_SCORE_TO_WIN) scoreResult = "Win for player1";
        else scoreResult = "Win for player2";
        return scoreResult;
    }
}
