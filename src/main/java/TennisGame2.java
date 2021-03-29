import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    private int P1point = 0;
    private int P2point = 0;
    private static List<String> Puntos = Arrays.asList(new String[] {"Love","Fifteen","Thirty","Forty"});
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (CondicionEmpateMenorA4()){
            score = Puntos.get(P1point) + "-All";
        }
        if (CondicionEmpateMayorA3()){
            score = "Deuce";
        }
        if (CondicionPuntajes()){
            score = Puntos.get(P1point) + "-" + Puntos.get(P2point);
        }
        if (CondicionVentajaP1()){
            score = "Advantage player1";
        }
        if (CondicionVentajaP2()){
            score = "Advantage player2";
        }
        if (CondicionGanoP1()){
            score = "Win for player1";
        }
        if (CondicionGanoP2()){
            score = "Win for player2";
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }

    public boolean CondicionEmpateMenorA4(){
        return P1point == P2point && P1point < 4;
    }

    public boolean CondicionEmpateMayorA3(){
        return P1point == P2point && P1point >= 3;
    }

    public boolean CondicionPuntajes(){
        return P2point>P1point && P2point < 4 || P1point>P2point && P1point < 4;
    }

    public boolean CondicionVentajaP1(){
        return P1point > P2point && P2point >= 3;
    }

    public boolean CondicionVentajaP2(){
        return P2point > P1point && P1point >= 3;
    }

    public boolean CondicionGanoP1(){
        return P1point>=4 && P2point>=0 && (P1point-P2point)>=2;
    }

    public boolean CondicionGanoP2(){
        return P2point>=4 && P1point>=0 && (P2point-P1point)>=2;
    }

}