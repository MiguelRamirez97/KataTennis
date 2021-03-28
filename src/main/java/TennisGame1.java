
public class TennisGame1 implements TennisGame {
    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            score1 += 1;
        } else {
            score2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (score1 == score2) {
            score = RetornarValorEmpate(score1);        /*Caso Empate*/
        }
        else if (score1 >= 4 || score2 >= 4){
            score = ObtenerGanador(score1,score2);      /*Caso Ganador*/
        }
        else {
            score = Puntuacion(score1,score2);          /*Caso General, va mostrando puntuacion*/
        }
        return score;
    }

    public String RetornarValorEmpate(int score1) {
        switch (score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    public String ObtenerGanador(int score1,int score2){
        String score = "";
        int diferenciaPuntaje = score1 - score2;
        if (diferenciaPuntaje == 1){
            score = "Advantage player1";
        }
        else if (diferenciaPuntaje == -1){
            score = "Advantage player2";
        }
        else if (diferenciaPuntaje >= 2) {
            score = "Win for player1";
        }
        else {
            score = "Win for player2";
        }
        return score;
    }

    public String Puntuacion(int score1, int score2){
        String score = "";
        score = PuntuacionATexto(score1) + "-" + PuntuacionATexto(score2);
        return score;
    }

    public String PuntuacionATexto(int score){
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return null;
        }
    }
}