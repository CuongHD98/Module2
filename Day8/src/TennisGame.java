public class TennisGame {

    public static final String SCORE0 = "Love";
    public static final String SCORE1 = "15";
    public static final String SCORE2 = "30";
    public static final String SCORE3 = "40";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore = 0;
        boolean equalScore = player1Score == player2Score;
        if (equalScore) {
            switch (player1Score) {
                case 0:
                    score = SCORE0;
                    break;
                case 1:
                    score = SCORE1;
                    break;
                case 2:
                    score = SCORE2;
                    break;
                case 3:
                    score = SCORE3;
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score += "-";
                    tempScore = player2Score;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "15";
                        break;
                    case 2:
                        score += "30";
                        break;
                    case 3:
                        score += "40";
                        break;
                }
            }
        }
        return score;
    }
}